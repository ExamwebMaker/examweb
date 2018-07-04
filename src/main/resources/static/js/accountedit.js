$(document).ready(function () {
    $(".change").click(function () {
        changeinfo()
    })


    $("#changeall").click(function () {
        $.ajax({
            url: "/commonUser/login",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify({
                "username":$("#usernameinput").val(),
                "password":$("#passwordinput").val(),
                "nameinput":$("#nameinput").val(),
                "country":$("#country").val(),
                "credentialtype":$("#crdentialtype").val(),
                "zhengjianhao":$("#zhengjianhaoinput").val(),
                "phone":$("#phonenuminput").val(),
                "email":$("#emailinput").val()

            }),
            contentType: 'application/json; charset=UTF-8',
            timeout: 1000,
            cache: false,
        })
            .done(function () {
              alert(data.message)

                window.location.href = "/stdaccountedit"
            })
            .fail(function () {
              alert(data.message)
            })
            .always(function () {
                console.log("complete");
            });
    })

    function changeinfo() {
        $("#changeall").show()
        $("#username").html("<input id='usernameinput' class='form-control w-50 d-inline'  type='text' value=''/> ");
        $("#password").html("<input id='passwordinput' class='form-control w-50 d-inline'  type='text' value=''/> ");
        $("#name").html("<input id='nameinput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $("#diqu").html("<select name=\"country\" id=\"country\" class=\"form-control w-50 d-inline\" aria-invalid=\"false\">\n" +
            "    <option value=\"CN\">中国大陆</option>\n" +
            "    <option value=\"HK\">香港</option>\n" +
            "    <option value=\"MO\">澳门</option>\n" +
            "    <option value=\"TW\">台湾</option>\n" +
            "\n" +
            "\n" +
            "</select>");
        $("#zhengjianhao").html("<select name=\"credentialtype\" id=\"credentialtype\" class=\"form-control w-25 d-inline\" aria-invalid=\"false\">\n" +
            "    <option value=\"SFZ\" selected=\"selected\">中华人民共和国居民身份证</option>\n" +
            "    <option value=\"QIT\">其他</option>\n" +
            "    <option value=\"SFZ_GAT\">港澳台身份证</option>\n" +
            "    <option value=\"SFZ_HQ\">华侨身份证(无身份证者可填护照号)</option>\n" +
            "    <option value=\"SFZ_HK\">香港身份证</option>\n" +
            "    <option value=\"SFZ_MO\">澳门身份证</option>\n" +
            "    <option value=\"SFZ_TW\">台湾居民来往大陆通行证</option>\n" +
            "\n" +
            "\n" +
            "</select><input id='zhengjianhaoinput' class='form-control w-25 d-inline'  type='text' value=''/> ")
        $("#phonenum").html("<input id='phonenuminput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $("#myemail").html("<input id='emailinput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $.ajax({
            url: "/commonUser/login",
            type: 'POST',
            dataType: 'json',

            contentType: 'application/json; charset=UTF-8',
            timeout: 1000,
            cache: false,

        })
            .done(function (data) {

                $("#usernameinput").val(data.data.username)
                $("#passwordinput").val(data.data.password)
                $("#nameinput").val(data.data.name)
                $("#country").val(data.data.diqu)
                $("#credentialtype").val(data.data.credentialtype)
                $("#zhengjianhaoinput").val(data.data.zhengjianhao)
                $("#phonenuminput").val(data.data.phonenum)
                $("#emailinput").val(data.data.email)
                alert(data.message)
            })
            .fail(function (data) {
                alert(data.message)
            })
            .always(function () {
                console.log("complete");
            });

    }
});