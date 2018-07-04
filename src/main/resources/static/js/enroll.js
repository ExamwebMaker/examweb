$(document).ready(function () {
    $("#genkaoshenghao").click(function () {
        $.ajax({
            url: '/commomuser/addExam',
            type: 'post',
            dataType: 'json',
            data: JSON.stringify({
                "account_id": $("#accountid").val(),
                "zhaoshengUnit": $("#zhaoshengdanwei1").val(),
                "examWay": $("#kaoshifangshi").val(),
                "specialPlan": $("#zhuanxiangjihua").val(),
                "name": $("#studentname").val(),
                "nameSpell": $("#studentnamepinyin").val(),
                "nowSolier": $("#xianyijunren").val(),
                "nation": $("#kaoshengminzu").val(),
                "sex": $("input[name=sex]:checked").val(),
                "marriage": $("input[name=marriage]:checked").val(),
                "policy": $("#zhengzhimianmao").val(),
                "connectAddress": $("#tongxundizhi").val(),
                "connectPostalcode": $("#youzhengbianma").val(),
                "certificateStyle": $("#zhengjianleixing").val(),
                "certificateNumber": $("#zhengjianhaoma").val(),
                "nativePlace": $("#kaoshengjiguan1").val() + $("#kaoshengjiguan2").val() + $("#kaoshengjiguan3").val(),
                "hukouPlace": $("#hukou1").val() + $("#hukou2").val() + $("#hukou3").val(),
                "hukouDetail": $("#hukouxiangxixinxi").val(),
                "birthPlace": $("#chushengdi1").val() + $("#chushengdi2").val() + $("#chushengdi3").val(),
                "nowStudyOrWorkUnit": $("#xianzaixuexi").val(),
                "filePlace": $("#dangansuozaidi").val(),
                "fileUnitName": $("#danganmingzi").val(),
                "fileUnitAddress": $("#dangandizhi").val(),
                "fileUnitPostalcode": $("#danganyoubian").val(),
                "rewardAndPunishment": $("#jianglichufen").val(),
                "wantDepartmentName": $("#baokaoyuanxiao").val(),
                "wantMajorName": $("#baokaozhuanye").val(),
                "researchWay": $("#yanjiufangxiang").val(),
                "learnWay": $("#xuexifangshi").val(),
                "examSubject": $("#kaoshikemu").val(),
                "examPointAddress": $("#baokaodianchengshi").val(),
                "examPointName": $("#baokaodianmingcheng").val(),


            }),
            contentType: 'application/json; charset=UTF-8',
            timeout: 1000,
            cache: false
        })
            .done(function (data) {
                console.log("success");
                alert(data.message)
                window.location.href = ""

            })
            .fail(function (data) {
                alert(data.message)
            })
            .always(function () {
                console.log("complete");
            });
    })

    /**
     * @author YangZhengqian
     * @date 2018/6/22
     * @Description: 进入公告
     */
    $("#addNewEnroll").click(function () {
        $(this).hide();
        $("#announcement").show('slow');

    })
    /**
     * @author YangZhengqian
     * @date 2018/6/22
     * @Description: 考试承诺书
     */
    $("#showcommitment").click(function (event) {

        $("#announcement").hide();
        $("#commitment").show('slow', function () {
            $.ajax({
                url: '/commonUser/getSchoolNameByProvince/',
                type: 'post',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                timeout: 1000,
                cache: false
            })
                .done(function (data) {
                    $("#accountid").val(data.data.account_id)
                    $("#kaoshengminzu").val(data.data.name)
                    $("#zhengjianleixing").val(data.data.certificateStyle)
                    $("#zhengjianhaoma").val(data.data.certificateNumber)
                })
                .fail(function () {
                    console.log("error");
                })
                .always(function () {
                    console.log("complete");
                });
        });
        /* Act on the event */
    });
    $("#uptoannouncement").click(function () {
        $("#announcement").show('slow', function () {

        });
        $("#commitment").hide()
    })
    /**
     * @Author: yanni
     * @Description:
     * @Date: 09:39 2018/6/22
     * @Modified By:
     * @Params:
     */
    $('#showprovince').click(function (event) {
        $('#commitment').hide('slow', function () {

        });
        $("#province").show('slow', function () {

        });
        /* Act on the event */
    });
    $('#uptocommitment').click(function (event) {
        $('#commitment').show('slow', function () {

        });
        $("#province").hide('slow', function () {

        });
        /* Act on the event */
    });
    /**
     * @Author: yanni
     * @Description:填写个人信息
     * @Date: 10:29 2018/6/22
     * @Modified By:
     * @Params:
     */
    $("#showpersoninfo1").click(function () {
        $("#province").hide('slow')
        $("#personinfo1").show('slow')


    });
    $("#uptoprovince").click(function () {
        $("#province").show('slow')
        $("#personinfo1").hide('slow')
    })
    /**
     * @Author: yanni
     * @Description:填写个人信息2
     * @Date: 11:09 2018/6/22
     * @Modified By:
     * @Params:
     */
    $("#showpersoninfo2").click(function () {
        $("#personinfo1").hide('slow')
        $("#personinfo2").show('slow')
    });
    $("#uptopersoninfo1").click(function () {
        $("#personinfo1").show('slow')
        $("#personinfo2").hide('slow')
    });
    $("#uptopersoninfo2").click(function () {

        $("#baokaodanwei").hide('slow')
        $("#personinfo2").show('slow')
    });
    $("#showbaokaodanwei").click(function () {
        $("#personinfo2").hide('slow')
        $("#baokaodanwei").show('slow')
    });

    $("#showbaokaodian").click(function () {
        $("#baokaodanwei").hide('slow')
        $("#baokaodian").show('slow')
    });

    $("#showyanzhengma").click(function () {
        $("#baokaodian").hide('slow')
        $("#yanzhengma").show('slow')
    });


    $("#zhaoshengdanwei1").change(function () {

        $.ajax({
            url: '/commonUser/getSchoolNameByProvince/' + $("#zhaoshengdanwei1").val(),
            type: 'post',
            dataType: 'json',

            contentType: 'application/json; charset=UTF-8',
            timeout: 1000,
            cache: false
        })
            .done(function (data) {

                $("#zhaoshengdanwei2").empty()
                for (var i = 0; i < data.data.length; i++) {

                    $("#zhaoshengdanwei2").append("<option value='" + data.data[i] + "'>" + data.data[i] + "</option>");
                }
            })
            .fail(function () {
                console.log("error");
            })
            .always(function () {
                console.log("complete");
            });
    })
});
