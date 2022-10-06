var formSetting;//传入的form参数
var origionalAction;//提交form原本的Action
var origionalOnBegin;//提交form原本的OnBegin
var origionalOnSuccess;//提交form原本的OnSuccess
var origionalOnFailure;//提交form原本的OnFailure
var origionalOnComplete;//提交form原本的OnComplete
var isSubmiting = false;//是否正在提交
var successFlag = true;//提交是否成功
/***提交指定的form***/
function SubmitTargetForm(_formSetting) {
    if (_formSetting && !isSubmiting) {
        formSetting = _formSetting;
        if (formSetting.AutoResetCallbacks) {
            RecordCallbacks();
        }
        $(formSetting.Form).attr("action", formSetting.Action);
        $(formSetting.Form).attr("data-ajax-begin", "OnSubmitBegin()");
        $(formSetting.Form).attr("data-ajax-success", "OnSubmitSuccess(data)");
        $(formSetting.Form).attr("data-ajax-failure", "OnSubmitFailure()");
        $(formSetting.Form).attr("data-ajax-complete", "OnSubmitComplete()");
        $(formSetting.Form).submit();
    }
}

/***提交开始***/
function OnSubmitBegin() {
    isSubmiting = true;
    formSetting.OnSubmitBegin && formSetting.OnSubmitBegin();
    if (formSetting.LoadingMsg) {
        formSetting.LoadingLayer = layer.msg(formSetting.LoadingMsg + "...", { time: 0, icon: 16, shade: 0.01 });
    }
    else {
        formSetting.LoadingLayer = layer.msg("正在操作，请稍后...", { time: 0, icon: 16, shade: 0.01 });
    }
}

/***提交结束***/
function OnSubmitComplete() {
    isSubmiting = false;
    if (formSetting.LoadingLayer) {
        layer.close(formSetting.LoadingLayer);
    }
    if (formSetting) {
        $(formSetting.Form).removeAttr("data-ajax-begin");
        $(formSetting.Form).removeAttr("data-ajax-success");
        $(formSetting.Form).removeAttr("data-ajax-failure");
        $(formSetting.Form).removeAttr("data-ajax-complete");
    }
    formSetting.OnSubmitComplete && formSetting.OnSubmitComplete();
    if (formSetting.AutoResetCallbacks) {
        ResetCallbacks();
    }
    if (successFlag && formSetting.NextSubmitor) {
        formSetting.NextSubmitor.Submit();
    }
}

/***提交成功***/
function OnSubmitSuccess(data) {
    isSubmiting = false;
    successFlag = true;
    if (formSetting.BlockDefaultCallbacks) {
        formSetting.OnSubmitSuccess && formSetting.OnSubmitSuccess(data);
    }
    else {
        var result = [];
        if (data) {
            try {
                result = eval('(' + data + ')');
            }
            catch (e) {
                layer.alert(e.message, { icon: 2 });
            }
        }
        else {
            successFlag = false;
        }
        if (successFlag) {
            try {
                formSetting.OnSubmitSuccess && formSetting.OnSubmitSuccess(result);

            } catch (e) {
                layer.alert(e.message, { icon: 2 });
                successFlag = false;
            }
        }
        else {
            OnSubmitFailure(result);
        }
    }
}


/***提交失败***/
function OnSubmitFailure(result) {
    isSubmiting = false;
    successFlag = false;
    var msg = '操作失败！'
    if (result) {
        var otherInfo = eval('(' + result.OtherInfo + ')');
        var errorMsg = otherInfo.errorMsg;
        var errorStackTrace = otherInfo.errorStackTrace;
        console.log(errorStackTrace);
        msg = errorMsg;
    }

    layer.alert(msg, {
        end: function () {
            formSetting.OnSubmitFailure && formSetting.OnSubmitFailure(otherInfo);
        }
    });
}

//记录原本的回调信息
function RecordCallbacks() {
    origionalAction = formSetting.Form.attr("action");
    origionalOnBegin = formSetting.Form.attr("data-ajax-begin");
    origionalOnSuccess = formSetting.Form.attr("data-ajax-success");
    origionalOnFailure = formSetting.Form.attr("data-ajax-failure");
    origionalOnComplete = formSetting.Form.attr("data-ajax-complete");
}

//重置原本的回调信息
function ResetCallbacks() {
    $(formSetting.Form).attr("action", origionalAction);
    $(formSetting.Form).attr("data-ajax-begin", origionalOnBegin);
    $(formSetting.Form).attr("data-ajax-success", origionalOnSuccess);
    $(formSetting.Form).attr("data-ajax-failure", origionalOnFailure);
    $(formSetting.Form).attr("data-ajax-complete", origionalOnComplete);
}

//form提交的参数
function FormParam() {
    return {
        //需要提交的action
        Action: "",
        //需要提交的表单
        Form: "",
        //是否自动重置提交之前的回调设置
        AutoResetCallbacks: false,
        ////是否屏蔽默认回调
        BlockDefaultCallbacks: false,
        //OnBegin回调函数
        OnSubmitBegin: undefined,
        //OnSuccess回调函数
        OnSubmitSuccess: undefined,
        //OnFailure回调函数
        OnSubmitFailure: undefined,
        //OnComplete回调函数
        OnSubmitComplete: undefined,
        //遮罩层
        LoadingLayer: "",
        //提示信息
        LoadingMsg: "",
        //添加下一个
        NextSubmitor: undefined,
        //提交
        Submit: function () { SubmitTargetForm(this); }
    }
}