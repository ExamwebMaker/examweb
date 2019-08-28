/*login.js*/
$(document).ready(function () {
    local = ``;

    $(`#loginbutton`).click(function () {
        if ($(`#adminusername`).val().length > 0 && $(`#adminpassword`).val().length > 0 && ($(`#superusername`).val().length === 0 && $(`#superpassword`).val().length === 0)) {
            $.ajax({
                url: local + `/commonManager/managerLogin`,
                type: `post`,
                dataType: `json`,
                data: JSON.stringify({
                    'name': $(`#adminusername`).val(),
                    "password": $(`#adminpassword`).val()
                }),
                contentType: `application/json; charset=UTF-8`,
                timeout: 1000,
                cache: false
            })
                .done(function (data) {
                    if (data.success == true) {
                        alert(data.message);
                        window.location.href = `/adminindex`;
                    } else if (data.success == false) {
                        alert(data.message);
                    }


                })
                .fail(function (data) {
                    alert(data.message);
                })
                .always(function () {
                    console.log(`complete`);
                });

        } else if ($(`#superusername`).val().length > 0 && $(`#superpassword`).val().length > 0 && $(`#adminusername`).val().length == 0 && $(`#adminpassword`).val().length == 0) {

            $.ajax({
                url: local + `/superManager/superLogin`,
                type: `post`,
                dataType: `json`,
                data: JSON.stringify({
                    'name': $(`#superusername`).val(),
                    "password": $(`#superpassword`).val()
                }),
                contentType: `application/json; charset=UTF-8`,
                timeout: 1000,
                cache: false
            })
                .done(function (data) {

                    if (data.success == true) {
                        alert(data.message);
                        window.location.href = `/superindex`;
                    } else if (data.success == false) {
                         alert(data.message);
                    }


                })
                .fail(function (data) {
                    alert(data.message);
                })
                .always(function () {
                    console.log(`complete`);
                });
        } else if ($(`#superadmin`).val().length == 0 && $(`#superpassword`).val().length == 0 &&
            (($(`#adminusername`).val().length == 0 && $(`#adminpass`).val().length == 0)) === 0) {
            alert(`用户名或密码不能为空!`);
        } else {
            alert(`ssdf`);
        }
    });


});
