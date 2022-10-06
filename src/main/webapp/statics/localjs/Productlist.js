/*$(document).ready(function () {
    initTable();
    //QueryProductType();
    //QueryProduct();
    //DoubleClick();
    //$('#me').trigger('click');//模拟鼠标点击让页签刷新
    //table_typetwo.rows().recalcHeight().draw();

    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        //当切换tab时，强制重新计算列宽
        $.fn.dataTable.tables({visible: true, api: true}).columns.adjust();
    });
});*/
/*

function initTable() {
    /!*车间端databales*!/
    /!*$("#column").html(data);*!/
    /!*var one = "<%=session.getAttribute("Col1")%>";*!/
    table_typeone = $('tb_typeone').DataTable({
        dom: 'Bfrtip',
        buttons: [
            'PageLength',
            'excel'
        ],
        "PageLength": 10,//每页默认最大显示行数
        scrollY: "300px",
        scrollX: true,
        scrollCollapse: true,
        colReorder: true,
        stateSave: true,
        fixedColumns: {
            leftColumns: 1
        },
        rowReorder: {
            selector: 'tr'
        },
        columns: [
            {title: "日期", data: "Day"},
        ]
    })

}

*/
