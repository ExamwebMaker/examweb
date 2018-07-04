$(document).ready(function () {
    $("#enrollnumber").append($.cookie('accountid'))

    //  $.session.set(obj)
    // alert($.session.get('obj.abc'))
    $("#jiaofei").click(function () {
        $("#jiaofei").hide();
        $("#alipayimage").show()
        $("#jiaofeiwarning").removeClass("d-none")

        setInterval(showsuccess, 5000);
    })
});



function showsuccess() {
    $("#alipayimage").addClass("d-none")
    $("#jiaofeiwarning").html("缴费成功!")
    $("#jiaofeiwarning").removeClass("text-danger").addClass("text-info")
    $("#enrollsuccess").removeClass("d-none")
    $("#downzhunkaozheng").removeClass("d-none")
}
