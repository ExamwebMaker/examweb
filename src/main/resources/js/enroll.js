$(document).ready(function () {
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
    $("#genkaoshenghao").click(function () {
        alert("报名成功!")
    })
});
