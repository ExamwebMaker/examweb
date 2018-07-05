$(document).ready(function () {
    if ($.cookie('islogin')=='yes'){
        location.assign('/stdcenter')
    }
    $("#username").val($.cookie('name'))
    $("#password").val($.cookie('password'))
    $("#loginbtn").click(function (event) {


        if (($("#username").val().length == 0) || ($("#password").val().length == 0)) {
            alert("用户名或密码不能为空!")
        } else {
            // $.session.set('name', $("#username").val());
            // $.session.set('password', $("#password").val());
            // // sessionStorage.setItem('name',$('#name').va)
            // window.location.href = "center.html"
            if ($("#rempass").is(":checked") == true) {

                $.cookie('name', $("#username").val())
                $.cookie('password', $("#password").val())
            }else if ($("#rempass").is(":checked")==false){

                $("#username").val("")
                $("#password").val("")
            }
            $.ajax({
                url: "/commomuser/login",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify({
                    "name": $("#username").val(),
                    "password": $("#password").val()

                }),
                contentType: 'application/json; charset=UTF-8',
                timeout: 1000,
                cache: false,
            })
                .done(function (data) {

                    alert(data.message);
                    $.cookie('islogin','yes')
                    $.cookie('accountid', data.data.id)
                    $.cookie('password', data.data.password)
                    $.cookie('name', data.data.name)
                    $.cookie('certificateStyle', data.data.certificateStyle)
                    $.cookie('certificateNumber', data.data.certificateNumber)
                    $.cookie('email', data.data.email)
                    $.cookie('phone', data.data.phone)


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
