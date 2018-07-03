/*login.js*/
$(document).ready(function () {

    $.ajax({
        url: "http://localhost:8080/getCourseGroup_Teacher",
        type: 'GET',
        dataType: 'json',
        timeout: 1000,
        contentType: 'application/json; charset=UTF-8',
        // beforeSend: LoadFunction,
        error: geterrorFunction,
        success: gettsucceedFunction
    });

    function geterrorFunction() {
        alert("服务器连接失败") // body...
    }

    // 渲染课程组
    function gettsucceedFunction(data) {
        for (var i = data.data.courseGroups.length - 1; i >= 0; i--) {
            $("#usertype").append("<option value='" + data.data.courseGroups[i].id + "'>" + data.data.courseGroups[i].name + "</option>");
        }
        // body...
    };

    $(".forget a").click(function () {
        console.log(1)
        alert("请联系超级管理员，询问或重新设置密码")
    })

    $("#loginbutton").click(
        function sub() {
            $.ajax({
                url: "http://localhost:8080/login",
                type: 'POST',
                data: JSON.stringify({
                    "account": $(".user-name").val(),
                    "password": $(".user-psw").val()
                }),
                success: function (data) {
                    // if (data.code == "###") {
                    console.log(data);
                    if (data.success) {
                        window.location.href = "/superadmin"
                    } else {
                        alert("用户名或密码不正确！")
                    }
                },
                error: function (data) {
                    console.log(data);
                    alert(data);
                    alert("服务器响应时间过长，请稍后重试！")
                }
            })
        })


});
