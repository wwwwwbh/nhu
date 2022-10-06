var App = function ()
{

    var currentPage = ''; // current page
    /*-----------------------------------------------------------------------------------*/
    /* 盒子事件
	/*-----------------------------------------------------------------------------------*/
    var handleBoxTools = function ()
    {
        jQuery('.box .box-title').click(function ()
        {
            var el = jQuery(this).parent(".box").children(".box-body");
            if (el.css("display") == "block")
            {
                var i = jQuery(this).children(".tools").children(".collapse");
                i.removeClass("collapse").addClass("expand");
                i.children(".fa-chevron-up").removeClass("fa-chevron-up").addClass("fa-chevron-down");
                el.slideToggle(200);
                //el.hide(200);
                //el.slideUp(500);
            } else
            {
                var i = jQuery(this).children(".tools").children(".expand");
                i.removeClass("expand").addClass("collapse");
                i.children(".fa-chevron-down").removeClass("fa-chevron-down").addClass("fa-chevron-up");
                el.slideToggle(200);
                //el.show(200)
                //el.slideDown(500);
            }
        });
    }
    /*-----------------------------------------------------------------------------------*/
    /*	时间选择器
	/*-----------------------------------------------------------------------------------*/
    var handleDatePicker = function ()
    {
        $('.form_date').datetimepicker({
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    }
    /*-----------------------------------------------------------------------------------*/
    /*	侧边菜单
	/*-----------------------------------------------------------------------------------*/
    var collapseSidebar = function ()
    {
        jQuery('#sidebar-collapse').click(function ()
        {
            var arrow = $(this).children("i");
            if (arrow.hasClass("fa-angle-double-left"))
            {
                arrow.removeClass("fa-angle-double-left").addClass("fa-angle-double-right");
                jQuery('#main-content').addClass("margin-left-70");
                jQuery('#cd-side-nav').addClass("min");
            } else
            {
                arrow.removeClass("fa-angle-double-right").addClass("fa-angle-double-left");
                jQuery('#main-content').removeClass("margin-left-70");
                jQuery('#cd-side-nav').removeClass("min");
            }
        });
        /* For sidebar
        jQuery('#sidebar').addClass("mini-menu");
        jQuery('#main-content').addClass("margin-left-50");
        jQuery('.sidebar-collapse i').removeClass(iconLeft);
        jQuery('.sidebar-collapse i').addClass(iconRight);
        */
    }
    /*-----------------------------------------------------------------------------------*/
    /*	Handles Profile Edit
	/*-----------------------------------------------------------------------------------*/
    var handleProfileEdit = function ()
    {

    }
    return {

        //Initialise theme pages
        init: function ()
        {
            if (App.isPage("default"))
            {
            }

            handleBoxTools();
            //	handleEditBoxTools();
            collapseSidebar();
            //	handleDatePicker();
        },

        setPage: function (name)
        {
            currentPage = name;
        },
        isPage: function (name)
        {
            return currentPage == name ? true : false;
        },
        addResponsiveFunction: function (func)
        {
            responsiveFunctions.push(func);
        }
    };
}();

/*-----------------------------------------------------------------------------------*/
/*	More.....
/*-----------------------------------------------------------------------------------*/
function submit_layer(str)
{
    layer.open({
        type: 2,
        title: '提交',
        maxmin: true,
        shadeClose: false, //点击遮罩关闭层
        area: ['900px', '550px'],
        content: '/PublicArea/ch_act_usr_id/ch_act_usr_id?kvs_str=' + str,
        scrollbar: false
    });
}
/*-----------------------------------------------------------------------------------*/
/*	选择弹出框方法
/*-----------------------------------------------------------------------------------*/
function select_layer(title, width, height, action, str, mdid, djid, url)
{
    layer.open({
        type: 2,
        title: title,
        maxmin: true,
        shadeClose: false, //点击遮罩关闭层
        area: [width, height],
        //content: '/PublicArea/Public/' + action + '?kvs_str=' + encodeURI(str) + '&mdid=' + mdid + '&djid=' + djid,
        content: '/PublicArea/Public/' + action + '?kvs_str=' + encodeURI(str) + '&mdid=' + mdid + '&djid=' + djid + '&' + url,
        scrollbar: false
    });
}
function select_layer_url(title, width, height, action, str, url)
{
    layer.open({
        type: 2,
        title: title,
        maxmin: true,
        shadeClose: false, //点击遮罩关闭层
        area: [width, height],
        content: '/PublicArea/Public/' + action + '?kvs_str=' + encodeURI(str) + '&' + url,
        scrollbar: false
    });
}
function kvs(vou_no, key_flag1, key_flag2, key_flag3, sys_id, dept_id, st_fill_date, st_dept_id, st_usr_id)
{
    this.vou_no = vou_no;
    this.key_flag1 = key_flag1;
    this.key_flag2 = key_flag2;
    this.key_flag3 = key_flag3;
    this.sys_id = sys_id;
    this.dept_id = dept_id;
    this.st_fill_date = st_fill_date;
    this.st_dept_id = st_dept_id;
    this.st_usr_id = st_usr_id;
}

function Table_totle(api, colNo, footNo, msg)
{
    // var api = this.api(), data;
    var intVal = function (i)
    {
        return typeof i === 'string' ?
            i.replace(/[\$,]/g, '') * 1 :
            typeof i === 'number' ? i : 0;

    };
    total = api.column(colNo).data().reduce(function (a, b)
    {
        return intVal(a) + intVal(b);
    }, 0);
    $(api.column(footNo).footer()).html(msg + "：" + total);
}