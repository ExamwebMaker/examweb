$(document).ready(function () {


    local = "http://eepyuf.natappfree.cc"
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
    });
    $("#showadminlink").click(function () {
        $(".col-md-8").hide()
        $("#showadmin").show()
    })
    $("#showgonggao").click(function (event) {
        $(".col-md-8").hide()
        $("#showgonggaolist").show();

        /* Act on the event */
    });
    /**
     * @Author: yanni
     * @Description:添加管理员
     * @Date: 11:03 2018/7/5
     * @Modified By:
     * @Params:
     */

    $("#addnewadmin").click(function () {
        $.ajax({
            url: local + '/superManager/designAccount',
            type: 'post',
            dataType: 'json',
            data: JSON.stringify({
                'name': $('#adminid').val(),
                "phone": "1212121121",
                "password": $('#adminpass1').val()
            }),
            contentType: 'application/json; charset=UTF-8',
            timeout: 1000,
            cache: false
        })
            .done(function (data) {

                if (data.success == true) {
                    alert(data.message)
                    window.location.href = 'superindex.html'
                } else if (data.success == false) {
                    alert(data.message)
                }


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
     * @Description:查看管理员
     * @Date: 11:14 2018/7/5
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: local + '/superManager/selectManager/1',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        timeout: 1000,
        cache: false
    })
        .done(function (data) {
            $("#adminlist").dataTable({
                "data": data.data.list,
                "aLengthMenu": [5, 10, 15, 20, 25], //更改显示记录数选项     "iDisplayLength" : 2, //默认显示的记录数
                "bLengthChange": true,                  //是否允许用户自定义每页显示条数。
                "bPaginate": true,                      //是否分页。
                "bProcessing": true,                    //当datatable获取数据时候是否显示正在处理提示信息。
                "sPaginationType": 'full_numbers',      //分页样式
                "columns": [
                    {"data": "id"},
                    {"data": "name"},
                    {"data": "password"},
                    {"data": null},
                    {"data": null}


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
                }, columnDefs: [{
                    targets: 3,
                    render: function (data, type, row, meta) {
                        return "<a  class='btn btn-primary"
                            + "' onclick='toupdateadmin(\""
                            + data.id
                            + "\")' href='#' data-toggle=\"modal\" data-target=\"#changeadmininfo\">修改</a>"
                    }
                }, {
                    targets: 4,
                    render: function (data, type, row, meta) {

                        return "<a  class='btn btn-danger"
                            + "' onclick='deladmin(\""
                            + data.id
                            + "\")' href='#' >删除</a>"
                    }
                }]

            })
        })
        .fail(function (data) {
            alert(data.message)
        })
        .always(function () {
            console.log("complete");
        });

 /**
     * @Author: yanni
     * @Description:查看用户
     * @Date: 11:14 2018/7/5
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: local + '/',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        timeout: 1000,
        cache: false
    })
        .done(function (data) {



    /**
     * @Author: yanni
     * @Description:公告列表
     * @Date: 16:03 2018/7/4
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: local + '',
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
            url: local + "",
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

    });

    /**
     * @Author: yanni
     * @Description:更新了
     * @Date: 15:26 2018/7/5
     * @Modified By:
     * @Params:
     */
    $("#changeadmin").click(function () {
        $.ajax({
            url: local + '/superManager/updateManager',
            type: 'post',
            dataType: 'json',
            data: JSON.stringify({
                'id': $('#adminidchange').val(),
                'name': $('#adminnamechange').val(),
                "phone": "1212121121",
                "password": $('#adminpasschange').val()
            }),
            contentType: 'application/json; charset=UTF-8',
            timeout: 1000,
            cache: false
        })
            .done(function (data) {

                if (data.success == true) {
                    alert("更新成功")
                    $('#showadmin').modal('hide')
                } else if (data.success == false) {
                    alert("失败了")
                }


            })
            .fail(function (data) {
                alert(data.message)
            })
            .always(function () {
                console.log("complete");
            });
       window.location.href='superindex.html'
    })


    /**
     * @Author: yanni
     * @Description:查看用户列表
     * @Date: 15:41 2018/7/4
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: local + "",
        type: '',
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
    }

//datatables的ajax方法
    function succeedFunction(data) {
        console.log(data.data)
        $("#userinfo").dataTable({
            "data": data.data,
            "aLengthMenu": [5, 10, 15, 20, 25], //更改显示记录数选项     "iDisplayLength" : 2, //默认显示的记录数
            "bLengthChange": true,                  //是否允许用户自定义每页显示条数。
            "bPaginate": true,                      //是否分页。
            "bProcessing": true,                    //当datatable获取数据时候是否显示正在处理提示信息。
            "sPaginationType": 'full_numbers',      //分页样式
            "columns": [
                {"data": "id"},
                {"data": "name"},
                {"data": "password"},
                {"data": null},
                {"data": null}


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
            }, columnDefs: [{
                targets: 3,
                render: function (data, type, row, meta) {
                    return "<a  class='btn btn-primary"
                        + "' onclick='toupdateadmin(\""
                        + data.id
                        + "\")' href='#' data-toggle=\"modal\" data-target=\"#changeadmininfo\">修改</a>"
                }
            }, {
                targets: 4,
                render: function (data, type, row, meta) {

                    return "<a  class='btn btn-danger"
                        + "' onclick='deladmin(\""
                        + data.id
                        + "\")' href='#' >删除</a>"
                }
            }]

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

/**
 * @Author: yanni
 * @Description:点击更新按钮
 * @Date: 12:26 2018/7/5
 * @Modified By:
 * @Params:
 */
function toupdateadmin(id) {


    $.ajax({
        url: local + "/superManager/getManagerById/" + id,
        type: 'POST',
        dataType: 'json',

        contentType: 'application/json; charset=UTF-8',
        timeout: 1000,
        cache: false,
    })
        .done(function (data) {

            $("#adminidchange").val(data.data.id)
            $("#adminnamechange").val(data.data.name);
            $("#adminpasschange").val(data.data.password)


        })
        .fail(function (data) {

            alert(data.message)
        })
        .always(function () {
            console.log("complete");
        });
}
function deladmin(adminid) {
    $.ajax({
        url: local + '/superManager/deleteManager/'+adminid,
        type: 'post',
        dataType: 'json',

        contentType: 'application/json; charset=UTF-8',
        timeout: 1000,
        cache: false
    })
        .done(function (data) {

            if (data.success == true) {
                alert(data.message)
                window.location.href='superindex.html'
            } else if (data.success == false) {
                alert(data.message)
            }


        })
        .fail(function (data) {
            alert(data.message)
        })
        .always(function () {
            console.log("complete");
        });
}
