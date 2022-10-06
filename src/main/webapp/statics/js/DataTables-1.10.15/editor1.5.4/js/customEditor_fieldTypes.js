var ifWriteHiddenField = false;
var ifWriteShowField = true;
(function ($, DataTable) {

    if (!DataTable.ext.editorFields) {
        DataTable.ext.editorFields = {};
    }

    var Editor = DataTable.Editor;
    var _fieldTypes = DataTable.ext.editorFields;
    //自定义下拉框
    _fieldTypes.mySelect = {
        create: function (conf) {
            var that = this;
            var fieldHtml =
                '<div id="' + Editor.safeId(conf.id) + '">' +
                    '<select id="' + Editor.safeId(conf.id) + '_mySelect" class="btn btn-default dropdown-toggle" style="width:100%">';
            $.each(conf.options, function (index, obj) {
                fieldHtml += '<option value="' + obj.value + '" label="' + obj.label + '">' + obj.label + '</option>';
            });
            fieldHtml +=
                    '</select>' +
                '</div>';

            // Create the elements to use for the input
            conf._input = $(fieldHtml);

            $('select', conf._input).change(function () {
                $("title").click();
                return false;
            });
            $('select', conf._input).blur(function () {
                ifWriteHiddenField = true;
                return false;
            });

            return conf._input;
        },

        get: function (conf) {

            var selectOption = $('select option:selected', conf._input);
            //alert("get:text=" + selectOption.text() + "value=" + selectOption.val() + "valueField=" + conf.valueField);
            return selectOption.text() + '<value style="display:none">{' + selectOption.val() + '}{' + conf.valueField + '}' + '</value>\n';
        },

        set: function (conf, val) {
            $("#" + Editor.safeId(conf.id) + "_mySelect option[label='" + val + "']", conf._input).attr("selected", "selected");
        }

    };
    //弹出选择层
    _fieldTypes.popSelect = {
        create: function (conf) {
            var that = this;
            var kvs = "{\"_popSelect\":\"" + conf.showTargetField + "\",";
            var fieldHtml =
                '<div id="' + Editor.safeId(conf.id) + '">' +
                '<div class="input-group">' +
                '<input type="text" class="form-control" id="_popSelect" disabled="disabled" style="height:22px;"/>' +
                '<span class="input-group-addon" id="popSelect_search_button">' +
                '<a href="javascript:"><i class="fa fa-search"></i></a>' +
                '</span></div>';
            $.each(conf.mapping, function (index, obj) {
                fieldHtml += '<input type="hidden" id="_popSelect_' + obj.valueField + '" />';
                kvs += "\"_popSelect_" + obj.valueField + "\":\"" + obj.targetField + "\",";
            });
            kvs = kvs.substring(0, kvs.length - 1);
            kvs += "}";
            fieldHtml += '</div>';
            // Create the elements to use for the input
            conf._input = $(fieldHtml);
            $('#popSelect_search_button', conf._input).click(function () {
                layer.open({
                    type: 2,
                    //  title: '计量单位',
                    maxmin: true,
                    shadeClose: false, //点击遮罩关闭层
                    area: ['500px', '400px'],
                    content: [conf.action + '&kvs_str=' + encodeURIComponent(kvs), 'yes'],
                    success: function (layero, index) {
                        ifWriteHiddenField = true;
                        $("body").click(function (e) {
                            //如果提供了事件对象，则这是一个非IE浏览器 
                            if (e && e.preventDefault)
                                //阻止默认浏览器动作(W3C) 
                                e.preventDefault();
                            else
                                //IE中阻止函数器默认动作的方式 
                                window.event.returnValue = false;
                            return false;
                        })
                    },
                    cancel: function (index, layero) {
                        ifWriteHiddenField = false;
                        ifWriteShowField = false;
                    },
                    end: function (index) {
                        $("body").unbind("click");
                        $("title").click();
                    }
                });
                return false;
            })
            return conf._input;
        },

        get: function (conf) {
            var returnVal = $('#_popSelect', conf._input).val();
            $.each(conf.mapping, function (index, obj) {
                returnVal += '<value style="display:none">{' + $('#_popSelect_' + obj.valueField, conf._input).val() + '}{' + obj.valueField + '}' + '</value>\n';
            })
            $('input[type=hidden]', conf._input).val('');
            return returnVal;
        },

        set: function (conf, val) {
            $('#_popSelect', conf._input).val(val);
        }

    };

})(jQuery, jQuery.fn.dataTable);

(function ($) {
    $.extend($, {
        editorOpen: function (dts) {
            editCurrentRow = dts.row($("div.DTE").parent().parent());
            editCurrentclo = dts.column($("div.DTE").parent().index());
            var input = $("div.DTE input[type='text']");
            if (input.length == 1) {
                input.select();
            }
            //禁止edit中datatime年月下拉
            if ($(".editor-datetime-month").length > 0) {
                $(".editor-datetime-month").attr("disabled", "true");
                $(".editor-datetime-year").attr("disabled", "true");
            }
        }
    })
    $.extend($, {
        editorClose: function (dts, editorName) {
            //console.log("editorClose");
            //获取编辑列列名
            var cloName = editCurrentclo.dataSrc();
            //获取编辑单元格中内容
            var editVal = eval(editorName + ".get()." + cloName);
            var patt = new RegExp('<value style="display:none">{(.*)}{(.*)}</value>', 'g');
            var bool = false;//是否有隐藏域值
            var bool1 = false;//是否有隐藏域
            var result;
            while ((result = patt.exec(editVal)) != null) {
                bool1 = true;
                var val = result[1];
                if (val != "") {
                    bool = true;
                    break;
                }
            }
            if (bool1 && ifWriteHiddenField) {
                var patt1 = new RegExp('<value style="display:none">{(.*)}{(.*)}</value>', 'g');
                var result1;
                //隐藏域正则匹配并赋值给datatables
                while ((result1 = patt1.exec(editVal)) != null) {
                    var val = result1[1];
                    var valField = result1[2];
                    //alert(valField+":"+val);
                    eval("editCurrentRow.data()." + valField + " = '" + val + "'");
                }
                ifWriteHiddenField = false;
            }
            //显示字段正则匹配并赋值给datatables
            if (ifWriteShowField) {
                var reg = /(.*)<value style=\"display:none\">/;
                if (reg.test(editVal)) {
                    reg.exec(editVal);
                    var text = RegExp.$1;
                    eval("editCurrentRow.data()." + cloName + " = '" + text + "'");
                }
                else {
                    eval("editCurrentRow.data()." + cloName + " = '" + editVal + "'");
                }
            }
            else {
                ifWriteShowField = true;
            }
            dts.rows().invalidate().draw(false);
        }
    })

    //可输入弹出关闭
    $.extend($, {
        pop_closeMethod: function (dts, G_arg, arr, jsonData, editCurrentRow, mddj) {
            var arr_0 = arr[0].valueField;
            // 从搜索按钮关闭 或 值未改变
            if (G_arg == '*' || G_arg == editCurrentRow.data()[arr_0]) {
                return;
            }

            if (jsonData == "item") {
                getItem(dts, G_arg, arr, editCurrentRow, mddj);
            } else if (jsonData == "corr") {
                console.log("corr");
            } else {
                defaultSelect(dts, G_arg, arr, jsonData, editCurrentRow);
            }

        }
    })
    //可编辑区域方向键事件
    $.extend($, {
        edit_keyupMethod: function (dts, e, i) {
            var dataLen = dts.rows().data().length;
            var editS = $(dts.table().node()).find("td.canEdit");
            var editLen = editS.length;
            if (editLen == 0) {
                return;
            }

            editS.each(function (i, e) {
                $(e).attr("data-index", i);
            });

            if (e.keyCode == 39) {
                if (i < editLen - 1) {
                    i++;
                }
                $(editS[i]).click();
            }
            if (e.keyCode == 37) {
                if (i > 0) {
                    i--;
                }
                $(editS[i]).click();
            }

            if (e.keyCode == 38) {
                if (i - editLen / dataLen >= 0) {
                    $(editS[i - editLen / dataLen]).click();
                }
            }
            if (e.keyCode == 40) {
                i = Number(i);
                if (i + editLen / dataLen <= editLen) {
                    $(editS[i + editLen / dataLen]).click();
                }
            }
            if (e.keyCode == 13) {
                $("title").click();
            }
        }
    })

    //可输入下拉框
    $.extend($, {
        select_openMethod: function (canhide, editor, currentColName) {
            var field_input = editor.field(currentColName).input();//得到元素节点
            var field_id = "#" + field_input[0].id;
            $(field_id).editableSelect({
                onShow: function (e) {
                    console.log("onShow");
                    canhide = 1;
                    $(".es-list").each(function (ii, ee) {
                        if (ee.style.display != "none") {
                            $(ee).addClass("active");
                        }
                    })
                    $(field_id).removeAttr("readonly");
                    //$(field_id).select();
                },
                onSelect: function (e) {
                    console.log("onSelect");
                    canhide = 2;
                    $(field_id).attr("data-val", $(e).text());
                },
                onHide: function (e) {
                    console.log("onHide", canhide);
                    $(field_id).attr("readonly", "readonly");
                    if (canhide == 1) {
                        var arr = [];
                        $(".es-list.active li").each(function (ii, ee) {
                            if (ee.style.display != "none" && $(ee).text() != "") {
                                arr.push($(ee).text());
                            }
                        })
                        if ($(field_id).val() == "") {
                            $(".es-list").removeClass("active");
                            return;
                        }
                        var len = arr.length;
                        if (len <= 0) {
                            $(field_id).attr("data-val", "|");
                        } else if (len > 1) {
                            $(field_id).attr("data-val", arr[0]);
                        } else if (len == 1) {
                            console.log("1", arr[0]);
                            $(field_id).attr("data-val", arr[0]);
                        }
                    }
                    canhide = 0;
                    $(".es-list").removeClass("active");
                },
            });
        }
    })

}(jQuery))

function getItem(dts, G_arg, arr, editCurrentRow, mddj) {
    mddj = mddj == void (0) ? "" : mddj;
    $.ajax({
        url: "/PublicArea/Public/getItemInfo?" + mddj,
        data: { "item_no": $.trim(G_arg) },
        type: "GET",
        cache: false,
        dataType: "json",
        async: false,
        success: function (data) {
            if (data.length == 0) return;
            var e = data[0];
            $.each(arr, function (ii, ee) {
                var valueField = ee.valueField;
                var targetField = ee.targetField;
                editCurrentRow.data()[valueField] = e[targetField];
            });
            dts.rows().invalidate().draw();
        }
    });
}

function defaultSelect(dts, G_arg, arr, jsonData, editCurrentRow) {
    var arr_0 = arr[0].valueField;
    var issame = false;
    $.each(jsonData, function (i, e) {
        if (e[arr_0] == G_arg) {
            $.each(arr, function (ii, ee) {
                //editCurrentRow.data()[ee] = e[ee];
                var valueField = ee.valueField;
                var targetField = ee.targetField;
                editCurrentRow.data()[valueField] = e[targetField];
            });
            issame = true;
        }
    });
    dts.rows().invalidate().draw(false);
}