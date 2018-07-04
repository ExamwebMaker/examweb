$(document).ready(function () {
    welcom()

    function welcom() {

        alert('请点击左侧导航栏进行操作')
    }

    $("#addadminlink").click(function () {
        $(".col-md-8").hide()
        $("#addadmin").show()
    });
    $("#showalldata").click(function () {
        $(".col-md-8").hide()
        $("#showdata").show()
    })
    $("#addgonggaolink").click(function () {
        $(".col-md-8").hide()
        $("#addgonggao").show()
    })
    $("#showgonggao").click(function (event) {
        $(".col-md-8").hide()
        $("#showgonggaolist").show();

        /* Act on the event */
    });
    /**
     * @Author: yanni
     * @Description:公告列表
     * @Date: 16:03 2018/7/4
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: 'https://www.easy-mock.com/mock/5b3b731adae7213852e96707/a/admin',
        type: 'get',
        dataType: 'json',
        timeout: 1000,
        cache: false,
    })
        .done(function (data1) {
            alert(data1.data.account.id)
            $("#gonggaolist").dataTable({
                "data": data1.data.account,
                "columns": [
                    {"data": "id"},
                    {"data": "name"}


                ],
                language: {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "表中数据为空",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                },

            })
        })
        .fail(function () {
            console.log("error");
        })
        .always(function () {
            console.log("complete");
        });
    /**
     * @Author: yanni
     * @Description: 添加管理员
     * @Date: 15:39 2018/7/4
     * @Modified By:
     * @Params:
     */
    $("#addnewadmin").click(function () {
        $.ajax({
            url: "http://ciiibv.natappfree.cc/commomuser/rigesterCommomUser",
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify({
                "id": $("#adminid").val(),
                "password": $("#adminpass1").val()

            }),
            contentType: 'application/json; charset=UTF-8',
            timeout: 1000,
            cache: false,
        })
            .done(function (data) {
                alert(data.message)
            })
            .fail(function (data) {
                alert(data.message)
            })
            .always(function () {
                console.log("complete");
            });

    })
    /**
     * @Author: yanni
     * @Description:查看表格数据
     * @Date: 15:41 2018/7/4
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: 'https://www.easy-mock.com/mock/5b3b731adae7213852e96707/a/account',
        type: 'get',
        dataType: 'json',
        timeout: 1000,
        cache: false,
        beforeSend: LoadFunction,
        error: errorFunction,
        success: succeedFunction
    });

    function LoadFunction() {

    }

    function errorFunction() {
        alert("错误11111")
    }

    //datatables的ajax方法
    function succeedFunction(data) {
console.log(data.data)
        $("#userinfo").DataTable({
            "data": data.data.account,
            "columns": [
                {"data": "id"},
                {"data": "sex"},
                {"data": "examSubject"}

            ],
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },

        })

    }


    $("#adminpass1").on('input propertychange', function () {
        checktwopass()
    });
    $("#adminpass2").on('input propertychange', function () {
        checktwopass()
    });

    function checktwopass() {
        var pwd1 = $("#adminpass1").val();
        var pwd2 = $("#adminpass2").val();
        <!-- 对比两次输入的密码 -->
        if (pwd1.length >= 6) {
            if (pwd1 == pwd2) {
                $("#passdismatch").hide();
                $("#passmatch").show("slow")
            } else {
                $("#passmatch").hide()
                $("#passdismatch").show("slow")
            }
        }
    }
})
