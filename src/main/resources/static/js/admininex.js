$(document).ready(function () {
    $("#showkaoshengtable").show()

    local = "http://eepyuf.natappfree.cc"
    $("#showkaosheng").click(function () {
        $("#showkaoshengtable").show()
    })

    /**
     * @Author: yanni
     * @Description:待审核
     * @Date: 16:28 2018/7/5
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: local + '',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        timeout: 1000,
        cache: false
    })
        .done(function (data) {
            $("#daishenhe").dataTable({
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
                            + "' onclick='showdetail1(\""
                            + data.id
                            + "\")' href='#' data-toggle=\"modal\" data-target=\"#changeadmininfo\">修改</a>"
                    }
                }, {
                    targets: 4,
                    render: function (data, type, row, meta) {

                        return "<a  class='btn btn-danger"
                            + "' onclick='deluser1(\""
                            + data.id
                            + "\")' href='#' >删除</a>"
                    }
                }]

            })
        })
        .fail(function (data) {
            alert("sdfsdlfsdklfskssfsdfsdfsdfsdfsdf")
            alert(data.message)
        })
        .always(function () {
            console.log("complete");
        });

    /**
     * @Author: yanni
     * @Description:审核通过
     * @Date: 16:28 2018/7/5
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: local + '',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        timeout: 1000,
        cache: false
    })
        .done(function (data) {
            $("#shenhetongguo").dataTable({
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
     * @Description:审核不通过
     * @Date: 16:28 2018/7/5
     * @Modified By:
     * @Params:
     */
    $.ajax({
        url: local + '',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        timeout: 1000,
        cache: false
    })
        .done(function (data) {
            $("#shenhebutongguo").dataTable({
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


})