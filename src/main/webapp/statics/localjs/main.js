$(document).ready(function () {
    initSelection();
    /*    var tempyear = $.trim($("#year").val());
        var tempmonth = $.trim($("#month").val());
        console.log(tempmonth);
        console.log(tempyear);*/
});

function initSelection() {
    /*sel1 年份，sel2月份，sel3部门*/
    //var sel1 = document.getElementById("year");
    // var sel2 = document.getElementById("month");
    //var sel3 = document.getElementById("dept");
    //console.log(sel1);
    //console.log(sel2);
    //console.log(sel3);
    var myDate = new Date();
    var thisYear = myDate.getFullYear();  // 获取当年年份
    for (var i = 0; i < 5; i++) {
        $("#year").prepend('<option value="' + thisYear + '">' + thisYear + '</option>');
        thisYear--;
    }
    $("#year").selected = true;

    var thisMonth = myDate.getMonth();
    for (var i = 1; i < 13; i++) {
        if (i === thisMonth + 1) {
            $("#month").prepend('<option value="' + i + '" selected="selected">' + i + '</option>');
        } else {
            $("#month").prepend('<option value="' + i + '">' + i + '</option>');
        }
    }
}

/*$("#sethtml").click(function () {
    var str = "";
    str += "<tr>";
    str += "<td><input type=\"checkbox\" class=\"checkbox\"></td>";
    str += "<td>" + "2019/08/06" + "</td>";
    str += "<td>" + "wu" + "</td>";
    str += "<td>" + "乙醚" + "</td>";
    str += "<td>" + "单元1" + "</td>";
    str += "<td>" + "10" + "</td>";
    str += "<td>" + "N" + "</td>";
    str += "<tr>";
    var body = "#tabli51 tbody";
    $(body).html(str);
});

$("#clearhtml").click(function () {

    $("#tabli51 tbody").html("")

});*/

$("#btn_s_findCKUsed").click(function () {
    console.log($("#year").val());
    console.log($("#month").val());
    $.ajax({
        type: "POST",
        url: "product/CKUsed.html",
        data: {"year": $("#year").val(), "month": $("#month").val()},
        dataType: "html",
        timeout: 1000,
        success: function (CKUsedList) {
            if (CKUsedList === "notLogged") {
                alert("请先登录");
            } else if (CKUsedList === "failed") {
                alert("查询异常");
            } else {
                //1.将字符串转化为JSON对象
                var ckUsedList = JSON.parse(CKUsedList);
                console.log(ckUsedList);
                var CKUsedBodyArr = ["#tabli51 tbody", "#tabli52 tbody", "#tabli53 tbody", "#tabli54 tbody"];
                var page;
                for (var i = 0; i < 4; i++) {
                    page = i + 1;
                    setTableCKUsed(CKUsedBodyArr[i], ckUsedList, page);
                }
                console.log($("#tabli51 tbody"));
            }

        },
        error: function () {
            alert("查询出错")
        }
    })
});

function setTableCKUsed(id, list, page) {
    //1.构造tbody内容
    var html = "";
    for (var i = 0; i < list.length; i++) {
        if (list[i].productTypeid === page) {
            html += "<tr>";
            html += "<td><input type=\"checkbox\" class=\"checkbox\"></td>";
            html += "<td>" + list[i].thedate + "</td>";
            html += "<td>" + list[i].username + "</td>";
            html += "<td>" + list[i].productname + "</td>";
            html += "<td>" + list[i].unitname + "</td>";
            html += "<td>" + list[i].chuku + "</td>";
            html += "<td>" + list[i].isreceived + "</td>";
            html += "<tr>";
        }
    }
    //2.删除页面中的tbody内的内容
    $(id).html = "";
    $(id).html(html);
}

//写几个查询Btn，根据年，月，(部门)；
$("#btn_s_findDeptUsed").click(function () {
    /*    var info = new Object();
        info.year = $.trim($("#year").val())
        info.month = $.trim($("#month").val())
        var infomonth = $.trim($("#month").val());*/
    $.ajax({
        type: "POST",
        //url: "product/.html",
        /*        data: {info: JSON.stringify(info)},*/
        data: {"year": $.trim($("#month").val()), "month": $.trim($("#month").val())},
        dataType: "html",
        timeout: 1000,
        success: function (result) {

        }
    })
});
$("#SearchCKUsedBtn").click(function () {
    var date = new Object();
    date.year = $.trim($("#CKUsedyear").val())
    date.month = $.trim($("#CKUsedmonth").val())
    if (date.year == "" || date.year == null) {
        $("#CKUsedyear").focus();
        $("#myCKUsed-tip").css("color", "red");
        $("#myCKUsed-tip").html("年份不能为空");
    } else if (date.month == "" || date.month == null) {
        $("#CKUsedmonth").focus();
        $("#myCKUsed-tip").css("color", "red");
        $("#myCKUsed-tip").html("月份不能为空");
    } else {
        $("#myCKUsed-tip").html("");

        $.ajax({
            type: "POST",
            url: "/user/CKUsed.html",
            data: {date: JSON.stringify(date)},
            dataType: "html",
            timeout: 1000,
            error: function () {
                $("#myCKUsed-tip").css("color", "red");
                $("#myCKUsed-tip").html("查询失败，请重试error!");
            },
            success: function (result) {
                var list = result.split('@');

                console.log(list[0]);
                var ckUsed1 = jQuery.parseJSON(list[0]);
                console.log(ckUsed1);

                console.log(list[1]);
                var ckUsed2 = jQuery.parseJSON(list[1]);
                console.log(ckUsed2);

                console.log(list[2]);
                var ckUsed3 = jQuery.parseJSON(list[2]);
                console.log(ckUsed3);

                console.log(list[3]);
                var ckUsed4 = jQuery.parseJSON(list[3]);
                console.log(ckUsed4);

                setTableDeptIncome($("#tabli11"), ckUsed1);
            }
        });
    }
})

function setTableDeptIncome(id, list) {
    var html = "";
    for (var i = 0; i < list.length(); i++) {
        html += list[i].name;
    }
}

/*
$("#myDelTrainBtn").click(function () {
    var trs = $("table").find("tr"); //获取表格每一行
    var selectIds = "";
    trs.each(function () {  // 遍历
        var isChecked = $(this).find(".checkbox").prop("checked");  // 获取当前行checkbox选择状态；
        if (isChecked == true || isChecked == "true") { // 如果选中
            selectIds += $(this).find(".checkbox").val() + " "; // checkbox的value
        }
    })

    if (selectIds != "" && selectIds != null) {

        $.ajax({
            type: "POST",
            url: "delete.html",
            data: {"trainNos": selectIds},
            dataType: "html",
            timeout: 1000,
            error: function () {
                alert("删除失败error");
                window.location.href = "backend/trainList.html";
            },
            success: function (result) {
                if (result == "success") {
                    window.location.href = "backend/trainList.html";
                    alert("车次" + selectIds + "删除成功了");
                } else if (result == "failed") {
                    window.location.href = "backend/trainList.html";
                    alert("删除失败");
                }
            },
        });

    } else {
        alert("请选择车次");
    }

});*/

/*
//用于点击id查看火车信息详情
$('.viewtrain').click(function(e){
	var m_id = $(this).attr('id');
	$.ajax({
		url: 'backend/getTrain.html',
		type: 'POST',
		data: {id:m_id},
		dataType: 'html',
		timeout: 1000,
		error: function(){
			alert("error");
		},
		success:function(result){
			if("failed" == result){
				alert("操作超时！");
			}else if("nodata" == result){
				alert("没有数据！");
			}else{
				m = eval('(' + result + ')');
				$("#trainNo").html(m.train_no);
				$("#trainStartStation").html(m.start_station);
				$("#trainAarrivalStation").html(m.arrival_station);
				$("#trainStartTime").html(m.start_time);
				$("#trainAarrivalTime").html(m.arrival_time);
				$("#trainType").html(m.type);
				$("#trainRuntime").html(m.runtime);
				$("#trainMile").html(m.mile);
			}
		}
	});
	
	e.preventDefault();
	$('#viewTrainModal').modal('show');
});*/

/*$('.viewproduct').click(function (e) {
    var m_id = $(this).attr('id');
    $.ajax({
        url: 'product/getProduct.html',
        type: 'POST',
        data: {id: m_id},
        dataType: 'html',
        timeout: 1000,
        error: function () {
            alert("error");
        },
        success: function (result) {
            if ("failed" == result) {
                alert("操作超时！");
            } else if ("nodata" == result) {
                alert("没有数据！");
            } else {
                m = eval('(' + result + ')');
                $("#productid").html(m.productid);
                $("#trainStartStation").html(m.start_station);
                $("#trainAarrivalStation").html(m.arrival_station);
                $("#trainStartTime").html(m.start_time);
                $("#trainAarrivalTime").html(m.arrival_time);
                $("#trainType").html(m.type);
                $("#trainRuntime").html(m.runtime);
                $("#trainMile").html(m.mile);
            }
        }
    });

    e.preventDefault();
    $('#viewproductModal').modal('show');
});*/

/*
$('.viewuser').click(function (e) {
    var m_id = $(this).attr('id');
    $.ajax({
        url: 'backend/getUser.html',
        type: 'POST',
        data: {id: m_id},
        dataType: 'html',
        timeout: 1000,
        error: function () {
            alert("error");
        },
        success: function (result) {
            if ("failed" == result) {
                alert("操作超时！");
            } else if ("nodata" == result) {
                alert("没有数据！");
            } else {
                m = eval('(' + result + ')');
                $("#userId").html(m.id);
                $("#userUsername").html(m.username);
                $("#userPassword").html(m.password);
                $("#userRealname").html(m.realname);
                $("#userBirth").html(m.birthday);
                $("#userTelphone").html(m.telphone);
                $("#userAddress").html(m.address);

            }
        }
    });

    e.preventDefault();
    $('#myUserModal').modal('show');
});*/

//Date日期类型以json形式显示到前台时，显示为[object Object]问题
//解决方法二：在js中转换
//function toDate(v,r,i) {
//    var date = new Date();
//    date.setTime(v.time);
//    var y = date.getFullYear();
//    var m = date.getMonth()+1;
//    m = m<10?'0'+m:m;
//    var d = date.getDate();
//    d = d<10?("0"+d):d;
//    var h = date.getHours();
//    h = h<10?("0"+h):h;
//    var M = date.getMinutes();
//    M = M<10?("0"+M):M;
//   // var str = y+"-"+m+"-"+d+" "+h+":"+M;
//    var str = y+" 年 "+m+" 月 "+d+" 日";
//    return str;
//
//}

/*
$('.addTrain').click(function (e) {
    $("#add_formtip").html('');
    e.preventDefault();
    $('#addTrainDiv').modal('show');
});


function addTrainFunction() {
    $("#add_formtip").html("");
    var result = true;
    if ($("#a_trainNo").val() == "") {
        $("#add_formtip").css("color", "red");
        $("#add_formtip").append("<li>对不起，车次不能为空。</li>");
        result = false;
    }
    if ($("#a_trainStartStation").val() == "") {
        $("#add_formtip").css("color", "red");
        $("#add_formtip").append("<li>对不起，发车不能为空。</li>");
        result = false;
    }
    if ($("#a_trainArrStation").val() == "") {
        $("#add_formtip").css("color", "red");
        $("#add_formtip").append("<li>对不起，到达不能为空。</li>");
        result = false;
    }
    if ($("#a_trainStartTime").val() == "") {
        $("#add_formtip").css("color", "red");
        $("#add_formtip").append("<li>对不起，发时不能为空。</li>");
        result = false;
    }
    if ($("#a_trainArrTime").val() == "") {
        $("#add_formtip").css("color", "red");
        $("#add_formtip").append("<li>对不起，到时不能为空。</li>");
        result = false;
    }
    if ($("#a_trainType").val() == "") {
        $("#add_formtip").css("color", "red");
        $("#add_formtip").append("<li>对不起，车型不能为空。</li>");
        result = false;
    }
    if (result == true) alert("添加成功 ^_^");
    return result;
}

$('.addtraincancel').click(function (e) {
    $('#a_trainNo').val('');
    $('#a_trainMile').val('');
    $('#a_trainStartStation').val('');
    $('#a_trainArrStation').val('');
    $('#a_trainStartTime').val('');
    $('#a_trainArrTime').val('');
    $('#a_trainType').val('');
    $('#a_trainRuntime').val('');
});


*/


