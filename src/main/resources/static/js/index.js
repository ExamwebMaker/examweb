$(document).ready(function () {

    show_time();
    $("#tologinbtn").click(function () {
        var flag=$.cookie("islogin")
        if (flag=='no'||flag==null) {

            location.assign('/stdlogin')
        }else if(flag=='yes'){

            location.assign("/stdcenter")
        }
    })

})

function show_time() {
    window.setTimeout("show_time()", 1000);
    BirthDay = new Date("2018-12-24");//改成你的计时日期
    today = new Date();
    timeold = (BirthDay.getTime() - today.getTime());
    sectimeold = timeold / 1000
    secondsold = Math.floor(sectimeold);
    msPerDay = 24 * 60 * 60 * 1000
    e_daysold = timeold / msPerDay
    daysold = Math.floor(e_daysold);
    e_hrsold = (e_daysold - daysold) * 24;
    hrsold = Math.floor(e_hrsold);
    e_minsold = (e_hrsold - hrsold) * 60;
    minsold = Math.floor((e_hrsold - hrsold) * 60);
    seconds = Math.floor((e_minsold - minsold) * 60);
    daojishi.innerHTML = daysold + "天" + hrsold + "小时" + minsold + "分" + seconds + "秒";
}

