(function ($)
{
    $.extend($, {//行号获取
        getDtsRowNO: function (table, columnIndex)
        {
            var rowNos = table.column(columnIndex).data().sort(function (a, b) { return a - b });
            if (rowNos.length == 0)
            {
                return 1;
            }
            else
            {
                return Number(rowNos[rowNos.length - 1].toString()) + 1;
            }
        }
    })
    $.extend($, {//将datatables表格中数据转换为可提交数据
        setPostDataTablesData: function (formID, tableObj, vmListProperty)
        {
            var dts_p_d_c = $("#" + vmListProperty + "_dataTables_Post_Data_Container");
            if (dts_p_d_c.length > 0)
            {
                dts_p_d_c.remove();
            }
            var s = '<div id="' + vmListProperty + '_dataTables_Post_Data_Container" style="display:none">';
            tableObj.rows().every(function (index, tableLoop, rowLoop)
            {
                var rowData = tableObj.row(index).data();
                tableObj.columns().every(function ()
                {
                    s += '<input type="hidden" name="' + vmListProperty + '[' + index + '].' + this.dataSrc() + '" value="' + eval("rowData." + this.dataSrc()) + '"/>';
                });
            })
            s = s + '</div>';
            $("#" + formID).append(s);
        }
    })
    $.extend($, {//将datatables表格中选择的数据转换为可提交数据
        setPostDataTablesDataByStrNo: function (formID, tableObj, vmListProperty, str)
        {
            var dts_p_d_c = $("#" + vmListProperty + "_dataTables_Post_Data_Container");
            if (dts_p_d_c.length > 0)
            {
                dts_p_d_c.remove();
            }
            var rowData_sel = tableObj.rows().data();
            var columns = tableObj.columns().dataSrc();
            var s = '<div id="' + vmListProperty + '_dataTables_Post_Data_Container" style="display:none">';
            rowData_sel.each(function (rowdata, index)
            {
                for (var i = str; i < columns.length; i++)
                {
                    s += '<input type="hidden" name="' + vmListProperty + '[' + index + '].' + columns[i] + '" value="' + eval("rowdata." + columns[i]) + '"/>';
                }
            });
            s = s + '</div>';
            $("#" + formID).append(s);
        }
    })
    $.extend($, {//将datatables表格中选择的数据转换为可提交数据
        setSelectPostDataTablesData: function (formID, tableObj, vmListProperty, str)
        {
            var dts_p_d_c = $("#" + vmListProperty + "_dataTables_Post_Data_Container");
            if (dts_p_d_c.length > 0)
            {
                dts_p_d_c.remove();
            }
            var rowData_sel = tableObj.rows('.selected').data();
            var columns = tableObj.columns().dataSrc();
            var s = '<div id="' + vmListProperty + '_dataTables_Post_Data_Container" style="display:none">';
            rowData_sel.each(function (rowdata, index)
            {
                for (var i = str; i < columns.length; i++)
                {
                    s += '<input type="hidden" name="' + vmListProperty + '[' + index + '].' + columns[i] + '" value="' + eval("rowdata." + columns[i]) + '"/>';
                }
            });
            s = s + '</div>';
            $("#" + formID).append(s);
        }
    })
    $.extend($, {//getBmddj 字符串拼接 (代替 Model._Bmddj.bmddjURL) 解决代码块折叠问题
        getBmddj: function ()
        {
            var B_com_id = $("input[name='_Bmddj.com_id']").val();
            var B_mdid = $("input[name='_Bmddj.mdid']").val();
            var B_djid = $("input[name='_Bmddj.djid']").val();
            var B_fid = $("input[name='_Bmddj.fid']").val();
            var B_ver_i = $("input[name='_Bmddj.ver_i']").val();
            var B_act_name = $("input[name='_Bmddj.act_name']").val();
            var B_act_type = $("input[name='_Bmddj.act_type']").val();
            var B_opr_flag = $("input[name='_Bmddj.opr_flag']").val();
            var B_org_mdid = $("input[name='_Bmddj.org_mdid']").val();
            var B_org_djid = $("input[name='_Bmddj.org_djid']").val();
            var B_act_flag = $("input[name='_Bmddj.act_flag']").val();
            var B_flw_flag = $("input[name='_Bmddj.flw_flag']").val();
            var B_mdid_opr_flag = $("input[name='_Bmddj.mdid_opr_flag']").val();

            var str = "";
            str = "_Bmddj.com_id=" + B_com_id;
            str += "&_Bmddj.mdid=" + B_mdid;
            str += "&_Bmddj.djid=" + B_djid;
            str += "&_Bmddj.fid=" + B_fid;
            str += "&_Bmddj.ver_i=" + B_ver_i;
            str += "&_Bmddj.act_name=" + B_act_name;
            str += "&_Bmddj.act_type=" + B_act_type;
            str += "&_Bmddj.opr_flag=" + B_opr_flag;
            str += "&_Bmddj.org_mdid=" + B_org_mdid;
            str += "&_Bmddj.org_djid=" + B_org_djid;
            str += "&_Bmddj.act_flag=" + B_act_flag;
            str += "&_Bmddj.flw_flag=" + B_flw_flag;
            str += "&_Bmddj.mdid_opr_flag=" + B_mdid_opr_flag;

            return str;
        }
    })
}(jQuery))
