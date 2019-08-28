/*
 * @Author: taoyifeng
 * @Date: 2018-07-05 22:06:51
 * @Description:
 * @Last Modified by: taoyifeng
 * @Last Modified time: 2018-07-06 07:52:32
 */

$(document).ready(function() {
  $(`#showkaoshengtable`).show();
  local = ``;
  $(`#showkaosheng`).click(function() {
    $(`#showkaoshengtable`).show();
  });

  /**
   * @Author: yanni
   * @Description:待审核
   * @Date: 16:28 2018/7/5
   * @Modified By:
   * @Params:
   */
  $.ajax({
    url: local + `/commonManager/getUncheckedSchoolExaminee/天津大学/1`,
    type: `post`,
    dataType: `json`,
    contentType: `application/json; charset=UTF-8`,
    timeout: 3000,
    cache: false
  })
    .done(function(data) {
      $(`#daishenhe`).dataTable({
        data: data.data.list,
        aLengthMenu: [5, 10, 15, 20, 25], //更改显示记录数选项     "iDisplayLength" : 2, //默认显示的记录数
        bLengthChange: true, //是否允许用户自定义每页显示条数。
        bPaginate: true, //是否分页。
        bProcessing: true, //当datatable获取数据时候是否显示正在处理提示信息。
        sPaginationType: `full_numbers`, //分页样式
        columns: [
          // 设置每列数据源
          { data: `id` },
          { data: `name` },
          { data: `sex` },
          { data: `examWay` },
          { data: `specialPlan` },
          { data: `wantDepartmentName` },
          { data: `learnWay` }
        ],
        language: {
          sProcessing: `处理中...`,
          sLengthMenu: `显示 _MENU_ 项结果`,
          sZeroRecords: `没有匹配结果`,
          sInfo: `显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项`,
          sInfoEmpty: `显示第 0 至 0 项结果，共 0 项`,
          sInfoFiltered: `(由 _MAX_ 项结果过滤)`,
          sInfoPostFix: ``,
          sSearch: `搜索:`,
          sUrl: ``,
          sEmptyTable: `表中数据为空`,
          sLoadingRecords: `载入中...`,
          sInfoThousands: `,`,
          oPaginate: {
            sFirst: `首页`,
            sPrevious: `上页`,
            sNext: `下页`,
            sLast: `末页`
          },
          oAria: {
            sSortAscending: `: 以升序排列此列`,
            sSortDescending: `: 以降序排列此列`
          }
        },
        columnDefs: [
          {
            targets: 7,
            render: function(data, type, row, meta) {
              let html =
                `<a href="javascript:void(0);" style="float:left" class="btn btn-success sure">通过</a><br/><a href="javascript:void(0);" style="float:left;margin-left:5px;margin-top:-15%;" class="btn btn-danger unsure">不通过</a>`;
              return html;
            }
          }
        ]
      });

      $(`.sure`).click(function() {
        let id = $(this)
          .parent()
          .parent()
          .children()
          .first()
          .html();
        let _this = $(this)
          .parent()
          .parent();
        // console.log($(this).parent().parent().children().first().html())
        $.ajax({
          type: `POST`,
          url: local + `/commonManager/check/` + id,
          dataType: `application/text; charset=UTF-8`,
          success: function(data) {
            if (data.success) {
              _this.remove();
            } else {
              alert(data.message);
            }
          },
          error: function() {
            alert(`error`);
          }
        });
      });
      $(`.unsure`).click(function() {
        let id = $(this)
          .parent()
          .parent()
          .children()
          .first()
          .html();
        let _this = $(this)
          .parent()
          .parent();
        // console.log($(this).parent().parent().children().first().html())
        $.ajax({
          type: `POST`,
          url: local + `/commonManager/uncheck/` + id,
          dataType: `application/text; charset=UTF-8`,
          success: function(data) {
            if (data.success) {
              _this.remove();
            } else {
              alert(data.message);
            }
          },
          error: function() {
            alert(`error`);
          }
        });
      });
    })
    .fail(function(data) {
      alert(data.message);
    })
    .always(function() {
      console.log(`complete`);
    });

  /**
   * @Author: yanni
   * @Description:审核通过
   * @Date: 16:28 2018/7/5
   * @Modified By:
   * @Params:
   */
  $(`.is-sure`).click(function() {
    $.ajax({
      url: local + `/commonManager/getCheckedSchoolExaminee/天津大学/1`,
      type: `post`,
      dataType: `json`,
      contentType: `application/json; charset=UTF-8`,
      timeout: 3000,
      cache: false
    })
      .done(function(data) {
        $(`#shenhetongguo`).dataTable({
          data: data.data.list,
          aLengthMenu: [5, 10, 15, 20, 25], //更改显示记录数选项     "iDisplayLength" : 2, //默认显示的记录数
          bLengthChange: true, //是否允许用户自定义每页显示条数。
          bPaginate: true, //是否分页。
          bProcessing: true, //当datatable获取数据时候是否显示正在处理提示信息。
          sPaginationType: `full_numbers`, //分页样式

          columns: [
            { data: `id` },
            { data: `name` },
            { data: `sex` },
            { data: `examWay` },
            { data: `specialPlan` },
            { data: `wantDepartmentName` }
          ],
          language: {
            sProcessing: `处理中...`,
            sLengthMenu: `显示 _MENU_ 项结果`,
            sZeroRecords: `没有匹配结果`,
            sInfo: `显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项`,
            sInfoEmpty: `显示第 0 至 0 项结果，共 0 项`,
            sInfoFiltered: `(由 _MAX_ 项结果过滤)`,
            sInfoPostFix: ``,
            sSearch: `搜索:`,
            sUrl: ``,
            sEmptyTable: `表中数据为空`,
            sLoadingRecords: `载入中...`,
            sInfoThousands: `,`,
            oPaginate: {
              sFirst: `首页`,
              sPrevious: `上页`,
              sNext: `下页`,
              sLast: `末页`
            },
            oAria: {
              sSortAscending: `: 以升序排列此列`,
              sSortDescending: `: 以降序排列此列`
            }
          },
          columnDefs: [
            {
              targets: 7,
              render: function(data, type, row, meta) {
                let html =
                  `<a href="javascript:void(0);" style="float:left" data-toggle="modal" data-target="#myModal" class="btn btn-success change">修改</a><br/><a href="javascript:void(0);" style="float:left;margin-left:5px;margin-top:-15%;" class="btn btn-danger unsure">不通过</a>`;
                return html;
              }
            }
          ]
        });
        $(`.change`).click(function() {
          let id = $(this)
            .parent()
            .parent()
            .children()
            .first()
            .html();
          $.ajax({
            type: `POST`,
            contentType: `application/json; charset=utf-8`,
            dataType: `application/json; charset=UTF-8`,
            url: local + `/commonManager/getExamineeForUpdate/` + id,
            success: function(response) {
              if (response.success) {
                $(`#form-body`)
                  .find(`input:eq(0)`)
                  .val(response.data.id);
                $(`#form-body`)
                  .find(`input:eq(1)`)
                  .val(response.data.name);
                $(`#form-body`)
                  .find(`input:eq(2)`)
                  .val(response.data.nameSpell);
                $(`#form-body`)
                  .find(`input:eq(3)`)
                  .val(response.data.examWay);
                $(`#form-body`)
                  .find(`input:eq(4)`)
                  .val(response.data.policy);
                $(`#form-body`)
                  .find(`input:eq(5)`)
                  .val(response.data.zhaoshengUnit);
                $(`#form-body`)
                  .find(`input:eq(6)`)
                  .val(response.data.specialPlan);
                $(`#form-body`)
                  .find(`input:eq(7)`)
                  .val(response.data.nation);
                $(`#form-body`)
                  .find(`input:eq(8)`)
                  .val(response.data.wantDepartmentName);
                $(`#form-body`)
                  .find(`input:eq(9)`)
                  .val(response.data.wantMajorName);
                $(`#form-body`)
                  .find(`input:eq(10)`)
                  .val(response.data.examSubject);
                $(`#form-body`)
                  .find(`input:eq(11)`)
                  .val(response.data.learnWay);
                $(`#form-body`)
                  .find(`input:eq(12)`)
                  .val(response.data.researchWay);
                $(`#form-body`)
                  .find(`input:eq(13)`)
                  .val(response.data.examPointName);
                $(`#form-body`)
                  .find(`input:eq(14)`)
                  .val(response.data.examPointAddress);
              } else {
                response.message;
              }
            },
            error: function() {
              alert(`error`);
            }
          });
        });
        $(`.makesure`).click(function() {
          let _SELECT = $(`#form-body form`);
          // alert($('#form-body form').find('input:eq(2)').val())
          let id = _SELECT.find(`input:eq(0)`).val();
          let data = {
            name: _SELECT.find(`input:eq(1)`).val(),
            nameSpell: _SELECT.find(`input:eq(2)`).val(),
            examWay: _SELECT.find(`input:eq(3)`).val(),
            policy: _SELECT.find(`input:eq(4)`).val(),
            zhaoshengUnit: _SELECT.find(`input:eq(5)`).val(),
            specialPlan: _SELECT.find(`input:eq(6)`).val(),
            nation: _SELECT.find(`input:eq(7)`).val(),
            wantDepartmentName: _SELECT.find(`input:eq(8)`).val(),
            wantMajorName: _SELECT.find(`input:eq(9)`).val(),
            examSubject: _SELECT.find(`input:eq(10)`).val(),
            learnWay: _SELECT.find(`input:eq(11)`).val(),
            researchWay: _SELECT.find(`input:eq(12)`).val(),
            examPointName: _SELECT.find(`input:eq(13)`).val(),
            examPointAddress: _SELECT.find(`input:eq(14)`).val()
          };
          $.ajax({
            type: `post`,
            url: `/commonManager/getExamineeForUpdate/` + id,
            data: data,
            dataType: `application/json; charset=UTF-8`,
            success: function(response) {
              if (response.success) {
                alert(`提交成功！`);
                $(`#myModal`).modal(`hide`);
              } else {
                alert(response, message);
              }
            }
          });
        });
        $(`.unsure`).click(function() {
          let id = $(this)
            .parent()
            .parent()
            .children()
            .first()
            .html();
          let _this = $(this)
            .parent()
            .parent();
          // console.log($(this).parent().parent().children().first().html())
          $.ajax({
            type: `POST`,
            url: local + `/commonManager/uncheck/` + id,
            dataType: `application/json; charset=UTF-8`,
            success: function(data) {
              if (data.success) {
                _this.remove();
              } else {
                alert(data.message);
              }
            },
            error: function() {
              alert(`error`);
            }
          });
        });
      })
      .fail(function(data) {
        alert(data.message);
      })
      .always(function() {
        console.log(`complete`);
      });
  });

  //     /**
  //      * @Author: yanni
  //      * @Description:审核不通过
  //      * @Date: 16:28 2018/7/5
  //      * @Modified By:
  //      * @Params:
  //      */
  $(`.un-sure`).click(function() {
    $.ajax({
      url: local + `/commonManager/getNoAgreeSchoolExaminee/天津大学/1`,
      type: `post`,
      dataType: `json`,
      contentType: `application/json; charset=UTF-8`,
      timeout: 3000,
      cache: false
    })
      .done(function(data) {
        $(`#shenhebutongguo`).dataTable({
          data: data.data.list,
          aLengthMenu: [5, 10, 15, 20, 25], //更改显示记录数选项     "iDisplayLength" : 2, //默认显示的记录数
          bLengthChange: true, //是否允许用户自定义每页显示条数。
          bPaginate: true, //是否分页。
          bProcessing: true, //当datatable获取数据时候是否显示正在处理提示信息。
          sPaginationType: `full_numbers`, //分页样式
          columns: [
            { data: `id` },
            { data: `name` },
            { data: `sex` },
            { data: `examWay` },
            { data: `specialPlan` },
            { data: `wantDepartmentName` }
          ],
          language: {
            sProcessing: `处理中...`,
            sLengthMenu: `显示 _MENU_ 项结果`,
            sZeroRecords: `没有匹配结果`,
            sInfo: `显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项`,
            sInfoEmpty: `显示第 0 至 0 项结果，共 0 项`,
            sInfoFiltered: `(由 _MAX_ 项结果过滤)`,
            sInfoPostFix: ``,
            sSearch: `搜索:`,
            sUrl: ``,
            sEmptyTable: `表中数据为空`,
            sLoadingRecords: `载入中...`,
            sInfoThousands: `,`,
            oPaginate: {
              sFirst: `首页`,
              sPrevious: `上页`,
              sNext: `下页`,
              sLast: `末页`
            },
            oAria: {
              sSortAscending: `: 以升序排列此列`,
              sSortDescending: `: 以降序排列此列`
            }
          },
          columnDefs: [
            {
              targets: 7,
              render: function(data, type, row, meta) {
                let html =
                  `<a href="javascript:void(0);" style="float:left;margin-left:5px;margin-top:-15%;" class="btn btn-danger sure">通过</a>`;
                return html;
              }
            }
          ]
        });
      })
      .fail(function(data) {
        alert(data.message);
      })
      .always(function() {
        console.log(`complete`);
      });
    $(`.sure`).click(function() {
      let id = $(this)
        .parent()
        .parent()
        .children()
        .first()
        .html();
      let _this = $(this)
        .parent()
        .parent();
      // console.log($(this).parent().parent().children().first().html())
      $.ajax({
        type: `POST`,
        url: local + `/commonManager/check/` + id,
        dataType: `application/text; charset=UTF-8`,
        success: function(data) {
          if (data.success) {
            _this.remove();
          } else {
            alert(data.message);
          }
        },
        error: function() {
          alert(`error`);
        }
      });
    });
  });
});
