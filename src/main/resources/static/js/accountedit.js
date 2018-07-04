$(document).ready(function () {
    $("#changeusername").click(function () {
        $("#username").html("<input id='usernameinput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $("#password").html("<input id='passwordinput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $("#name").html("<input id='nameinput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $("#diqu").html("<select name=\"country\" id=\"country\" class=\"form-control w-50 d-inline\" aria-invalid=\"false\">\n" +
            "    <option value=\"CN\">中国大陆</option>\n" +
            "    <option value=\"HK\">香港</option>\n" +
            "    <option value=\"MO\">澳门</option>\n" +
            "    <option value=\"TW\">台湾</option>\n" +
            "\n" +
            "\n" +
            "</select>")
        $("#zhengjianhao").html("<select name=\"credentialtype\" id=\"credentialtype\" class=\"form-control w-50 d-inline\" aria-invalid=\"false\">\n" +
            "    <option value=\"SFZ\" selected=\"selected\">中华人民共和国居民身份证</option>\n" +
            "    <option value=\"QIT\">其他</option>\n" +
            "    <option value=\"SFZ_GAT\">港澳台身份证</option>\n" +
            "    <option value=\"SFZ_HQ\">华侨身份证(无身份证者可填护照号)</option>\n" +
            "    <option value=\"SFZ_HK\">香港身份证</option>\n" +
            "    <option value=\"SFZ_MO\">澳门身份证</option>\n" +
            "    <option value=\"SFZ_TW\">台湾居民来往大陆通行证</option>\n" +
            "\n" +
            "\n" +
            "</select><input id='zhengjianhaoinput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $("#phonenum").html("<input id='phonenuminput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $("#myemail").html("<input id='emailinput' class='form-control w-50 d-inline'  type='text' value=''/> ")
        $.ajax({
            url: 'https://www.easy-mock.com/mock/5b3b731adae7213852e96707/a/a',
            type: 'get',
            dataType: 'json',

        })
            .done(function (data) {
                console.log("success");
                $("#usernameinput").val(data.data.username)
                $("#passwordinput").val(data.data.password)
                $("#nameinput").val(data.data.name)
                $("#country").val(data.data.diqu)
                $("#credentialtype").val(data.data.credentialtype)
                $("#zhengjianhaoinput").val(data.data.zhengjianhao)
                $("#phonenuminput").val(data.data.phonenum)
                $("#emailinput").val(data.data.email)
            })
            .fail(function () {
                console.log("error");
            })
            .always(function () {
                console.log("complete");
            });


    });
    $("#changepassword").click(function () {
        $("#phonenum").html("<input id='phonenuminput' class='form-control w-50 d-inline'  type='text' value=''/> ")

    })

});
