$(document).ready(function() {
  function chekallowed() {
    if ($(`#allowed`).is(`:checked`) == false) {
      alert(`请保证自己的信息属实!`);
    }
  }

  local = ``;

  $(`#genkaoshenghao`).click(function() {
    chekallowed();
    $.ajax({
      url: local + `/commonUser/addExam`,
      type: `post`,
      dataType: `json`,
      data: JSON.stringify({
        id: `ident`,
        account_id: $(`#accountid`).val(),
        zhaoshengUnit: $(`#zhaoshengdanwei1`).val(),
        examWay: $(`#kaoshifangshi`).val(),
        specialPlan: $(`#zhuanxiangjihua`).val(),
        name: $(`#studentname`).val(),
        nameSpell: $(`#studentnamepinyin`).val(),
        nowSolier: $(`#xianyijunren`).val(),
        nation: $(`#kaoshengminzu`).val(),
        sex: $(`input[name=sex]:checked`).val(),
        marriage: $(`input[name=marriage]:checked`).val(),
        policy: $(`#zhengzhimianmao`).val(),
        connectAddress: $(`#tongxundizhi`).val(),
        connectPostalcode: $(`#youzhengbianma`).val(),
        certificateStyle: $(`#zhengjianleixing`).val(),
        certificateNumber: $(`#zhengjianhaoma`).val(),
        nativePlace:
          $(`#kaoshengjiguan1`).val() +
          $(`#kaoshengjiguan2`).val() +
          $(`#kaoshengjiguan3`).val(),
        hukouPlace:
          $(`#hukou1`).val() + $(`#hukou2`).val() + $(`#hukou3`).val(),
        hukouDetail: $(`#hukouxiangxixinxi`).val(),
        birthPlace:
          $(`#chushengdi1`).val() +
          $(`#chushengdi2`).val() +
          $(`#chushengdi3`).val(),
        nowStudyOrWorkUnit: $(`#xianzaixuexi`).val(),
        filePlace: $(`#dangansuozaidi`).val(),
        fileUnitName: $(`#danganmingzi`).val(),
        fileUnitAddress: $(`#dangandizhi`).val(),
        fileUnitPostalcode: $(`#danganyoubian`).val(),
        rewardAndPunishment: $(`#jianglichufen`).val(),
        wantDepartmentName: $(`#baokaoyuanxiao`).val(),
        wantMajorName: $(`#baokaozhuanye`).val(),
        researchWay: $(`#yanjiufangxiang`).val(),
        learnWay: $(`#xuexifangshi`).val(),
        examSubject: $(`#kaoshikemu`).val(),
        examPointAddress: $(`#baokaodianchengshi`).val(),
        examPointName: $(`#baokaodianmingcheng`).val()
      }),
      contentType: `application/json; charset=UTF-8`,
      timeout: 1000,
      cache: false
    })
      .done(function(data) {
        alert(data.message);
        window.location.href = `/stdpay`;
      })
      .fail(function(data) {
        alert(data.message);
      })
      .always(function() {
        console.log(`complete`);
      });
  });

  /**
   * @author YangZhengqian
   * @date 2018/6/22
   * @Description: 进入公告
   */
  $(`#addNewEnroll`).click(function() {
    $(this).hide();
    $(`#showenroll`).hide();

    $(`#announcement`).show(`slow`);
  });
  $(`#showenroll`).click(function() {
    $.ajax({
      url: local + `/commonUser/lookExam/` + $.cookie(`accountid`),
      type: `post`,
      dataType: `json`,

      contentType: `application/json; charset=UTF-8`,
      timeout: 1000,
      cache: false
    })
      .done(function(data) {
        $(`#stdname`).val(data.data.name);
        $(`#stdexamway`).val(data.data.examWay);
        $(`#specialplan`).val(data.data.specialPlan);
        $(`#sex`).val(data.data.sex);
        $(`#fieldplace`).val(data.data.filePlace);
        $(`#certifiatesy`).val(data.data.certificateStyle);
        $(`#certificatenum`).val(data.data.certificateNumber);
        $(`#wantdepartment`).val(data.data.wantDepartmentName);
        $(`#wantmajor`).val(data.data.wantMajorName);
        $(`#exampoint`).val(data.data.examPointName);
      })
      .fail(function() {
        console.log(`error`);
      })
      .always(function() {
        console.log(`complete`);
      });
  });
  /**
   * @author YangZhengqian
   * @date 2018/6/22
   * @Description: 考试承诺书
   */
  $(`#showcommitment`).click(function(event) {
    $(`#announcement`).hide();
    $(`#commitment`).show(`slow`, function() {
      // $.ajax({
      //     url: 'http://sc3r8b.natappfree.cc/commonUser/clickAddExam',
      //     type: 'post',
      //     dataType: 'json',
      //     contentType: 'application/json; charset=UTF-8',
      //     timeout: 1000,
      //     cache: false
      // })
      //     .done(function (data) {
      //
      //         $("#accountid").val(data.data.id)
      //         $("#kaoshengminzu").val(data.data.name)
      //         $("#zhengjianleixing").val(data.data.certificateStyle)
      //         $("#zhengjianhaoma").val(data.data.certificateNumber)
      //     })
      //     .fail(function (data) {
      //         console.log("error");
      //     })
      //     .always(function () {
      //         console.log("complete");
      //     });
    });

    $(`#accountid`).val($.cookie(`accountid`));
    $(`#studentname`).val($.cookie(`name`));
    $(`#zhengjianleixing`).val($.cookie(`certificateStyle`));
    $(`#zhengjianhaoma`).val($.cookie(`certificateNumber`));
    /* Act on the event */
  });
  $(`#uptoannouncement`).click(function() {
    $(`#announcement`).show(`slow`, function() {});
    $(`#commitment`).hide(`slow`);
  });
  /**
   * @Author: yanni
   * @Description:
   * @Date: 09:39 2018/6/22
   * @Modified By:
   * @Params:
   */
  $(`#showprovince`).click(function(event) {
    $(`#commitment`).hide(`slow`, function() {});
    $(`#province`).show(`slow`, function() {});
    /* Act on the event */
  });
  $(`#uptocommitment`).click(function(event) {
    $(`#commitment`).show(`slow`, function() {});
    $(`#province`).hide(`slow`, function() {});
    /* Act on the event */
  });
  $(`#uptobaokaodanwei`).click(function() {
    $(`#baokaodian`).hide(`slow`);
    $(`#baokaodanwei`).show(`slow`);
  });
  /**
   * @Author: yanni
   * @Description:填写个人信息
   * @Date: 10:29 2018/6/22
   * @Modified By:
   * @Params:
   */
  $(`#showpersoninfo1`).click(function() {
    $(`#province`).hide(`slow`);
    $(`#personinfo1`).show(`slow`);
  });
  $(`#uptoprovince`).click(function() {
    $(`#province`).show(`slow`);
    $(`#personinfo1`).hide(`slow`);
  });
  /**
   * @Author: yanni
   * @Description:填写个人信息2
   * @Date: 11:09 2018/6/22
   * @Modified By:
   * @Params:
   */
  $(`#showpersoninfo2`).click(function() {
    $(`#personinfo1`).hide(`slow`);
    $(`#personinfo2`).show(`slow`);
  });
  $(`#uptopersoninfo1`).click(function() {
    $(`#personinfo1`).show(`slow`);
    $(`#personinfo2`).hide(`slow`);
  });
  $(`#uptopersoninfo2`).click(function() {
    $(`#baokaodanwei`).hide(`slow`);
    $(`#personinfo2`).show(`slow`);
  });
  $(`#showbaokaodanwei`).click(function() {
    $(`#personinfo2`).hide(`slow`);
    $(`#baokaodanwei`).show(`slow`);
  });

  $(`#showbaokaodian`).click(function() {
    $(`#baokaodanwei`).hide(`slow`);
    $(`#baokaodian`).show(`slow`);
  });

  $(`#showyanzhengma`).click(function() {
    $(`#baokaodian`).hide(`slow`);
    $(`#yanzhengma`).show(`slow`);
  });

  $(`#uptobaokaodian`).click(function() {
    $(`#yanzhengma`).hide();
    $(`#baokaodian`).show();
  });
  $(`#zhaoshengdanwei1`).change(function() {
    $.ajax({
      url:
        local +
        `/commonUser/getSchoolNameByProvince/` +
        $(`#zhaoshengdanwei1`).val(),
      type: `post`,
      dataType: `json`,
      contentType: `application/json; charset=UTF-8`,
      timeout: 1000,
      cache: false
    })
      .done(function(data) {
        $(`#zhaoshengdanwei2`).empty();
        for (let i = 0; i < data.data.length; i++) {
          $(`#zhaoshengdanwei2`).append(
            `<option value='` + data.data[i] + `'>` + data.data[i] + `</option>`
          );
        }
      })
      .fail(function() {
        console.log(`error`);
      })
      .always(function() {
        console.log(`complete`);
      });
  });
});
