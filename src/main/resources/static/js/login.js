$(document).ready(function () {
    $("#loginbtn").click(function (event) {
        if (($("#username").val().length == 0) || ($("#password").val().length == 0)) {
            alert("用户名或密码不能为空!")
        } else {
            $.ajax({
                url: "/commonUser/login",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify({
                    "name": $("#username").val,
                    "password": $("#password").val()

                }),
                contentType: 'application/json; charset=UTF-8',
                timeout: 1000,
                cache: false,
            })
                .done(function () {
                    console.log("success");
                    alert("登录成功!");

                    window.location.href = "/stdcenter"
                })
                .fail(function () {
                    alert("用户名或密码错误!")
                    console.log("error");
                })
                .always(function () {
                    console.log("complete");
                });
        }
        /* Act on the event */
        /* Act on the event */
    });
});
