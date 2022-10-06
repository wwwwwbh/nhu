/**
 * index.jsp 页面的用户登录信息， 使用ajax 异步提交到后台；
 */


$("#loginBtn").click(function () {
    var user = new Object();
    user.username = $.trim($("#username").val());
    user.userpwd = $.trim($("#password").val());
    if (user.username == "" || user.username == null) {
        $("#username").focus();
        $("#mylogin-tip").css("color", "red");
        $("#mylogin-tip").html("用户名不能为空");
    } else if (user.userpwd == "" || user.userpwd == null) {
        $("#password").focus();
        $("#mylogin-tip").css("color", "red");
        $("#mylogin-tip").html("密码不能为空");
    } else {
        $("#mylogin-tip").html("");

        $.ajax({
            type: "POST",
            url: "/user/login.html",
            data: {user: JSON.stringify(user)},
            dataType: "html",
            timeout: 1000,
            error: function (e) {
                $("#mylogin-tip").css("color", "red");
                $("#mylogin-tip").html(console.log(e)+"登录失败，请重试error!");
            },
            success: function (result) {
                if (result == "security") {
                    window.location.href = "/user/main.html";
                } else if (result == "failed") {
                    $("#mylogin-tip").css("color", "red");
                    $("#mylogin-tip").html("登录失败，请重试!");
                    $("#username").val("");
                    $("#password").val("");

                } else if (result == "NoUserName") {
                    $("#mylogin-tip").css("color", "red");
                    $("#mylogin-tip").html("用户名不存在，请重试！");

                } else if (result == "pwdError") {
                    $("#mylogin-tip").css("color", "red");
                    $("#mylogin-tip").html("密码错误，请重试!");

                } else if (result == "AccountNotEffective") {
                    $("#mylogin-tip").css("color", "red");
                    $("#mylogin-tip").html("账户未生效!");

                }
            }
        });


    }
});