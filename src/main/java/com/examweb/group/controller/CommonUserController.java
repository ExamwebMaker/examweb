package com.examweb.group.controller;

import com.examweb.group.dto.Result;
import com.examweb.group.entity.Account;
import com.examweb.group.entity.Examinee;
import com.examweb.group.entity.School;
import com.examweb.group.service.AccountService;
import com.examweb.group.service.ExamineeService;
import com.examweb.group.service.SchoolService;
import com.examweb.group.service.TimeInfoService;
import com.examweb.group.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/2
 */
@RestController
@RequestMapping(value = "/commomuser")
public class CommonUserController {

    private AccountService accountService;
    private ExamineeService examineeService;
    private TimeInfoService timeInfoService;
    private SchoolService schoolService;

    @Autowired
    protected CommonUserController(AccountService accountService,ExamineeService examineeService,TimeInfoService timeInfoService,SchoolService SchoolService){
        this.accountService=accountService;
        this.examineeService=examineeService;
        this.timeInfoService=timeInfoService;
        this.schoolService=SchoolService;
    }

    ///**
    // * @Description: 普通用户主页
    // * @Json:
    // * @Date: 2018/7/3
    // * @Return:
    // */
    //@GetMapping("/")
    //public String index(){
    //    return "/templates/student/index";
    //}

    /**
     * @Description: 普通用户注册
     * @Json: {
    "certificateNumber": "string",
    "certificateStyle": "0",
    "email": "string",
    "id": "string",
    "name": "string",
    "password": "string",
    "phone": "string"
    }
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/rigesterCommomUser")
    @CrossOrigin
    public Result rigesterCommomUser(HttpServletRequest request,@RequestBody @Valid Account account, BindingResult bindingResult){
        //System.out.print(account.getCertificateNumber());

        if (bindingResult.hasErrors()){
            return ResultUtil.fail(bindingResult.getAllErrors().toString());
        }
        //判断用户名是否已存在
        try {
            Account accountGet;
            accountGet=accountService.getAccountByName(account.getName());
            if (accountGet!=null){
                return ResultUtil.fail("账号名已经存在");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        account.setId(UUID.randomUUID().toString().replaceAll("-",""));
        account.setAccountStyle("0");
        account.setUpdateTime(new Date(System.currentTimeMillis()));
        account.setCreateTime(new Date(System.currentTimeMillis()));
        account.setIsDelete("0");
        //System.out.print(account.toString());
        try {
            if (accountService.insert(account)){

                return ResultUtil.OK(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.insertError();
    }

    /**
     * @Description: 用户点击新增报名信息
     * @Json:
     * @Date: 2018/7/4
     * @Return:
     */
    @PostMapping("/clickAddExam")
    @CrossOrigin
    public Result clickAddExam(HttpSession session){
        Account account=(Account) session.getAttribute("account");
        String name=account.getName();
        String password=account.getPassword();
        String phone=account.getPhone();
        String certificateStyle =account.getCertificateStyle();
        String certificateNumber=account.getCertificateNumber();
        String id=account.getId();
        if (name==null||name.trim().isEmpty()){
            return ResultUtil.fail("输入用户名不能为空");
        }
        if (password==null||password.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        if (phone==null||phone.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        if (certificateStyle==null||certificateStyle.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        if (certificateNumber==null||certificateNumber.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        if (id==null||id.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }
        return ResultUtil.OK(account);
    }
    
   /**
    * @Description: 用户提交报名信息
    * @Json:
    * @Date: 2018/7/4
    * @Return:
    */
   @PostMapping("/addExam")
       @CrossOrigin
        public Result addExam(@RequestBody @Valid Examinee examinee, BindingResult bindingResult){
           if (bindingResult.hasErrors()){
               return ResultUtil.fail(bindingResult.getAllErrors().toString());
           }
           String accountId;
           accountId=examinee.getAccount_id();
           Examinee examineeChange;
           examineeChange=examineeService.getExamineeByAccountId(accountId);
           if(examineeChange==null){
               try {
                   //System.out.print(examinee.toString());
                   examinee.setId(UUID.randomUUID().toString().replaceAll("-",""));
                   ///examinee.setAccount_id();
                   examinee.setUpdateTime(new Date(System.currentTimeMillis()));
                   examinee.setCreateTime(new Date(System.currentTimeMillis()));
                   examinee.setIsDelete("0");
                   examinee.setIsCheck("1");
                   System.out.print(examinee.toString());
                   examineeService.insert(examinee);
                   return ResultUtil.OK();
               }catch (Exception e){
                   e.printStackTrace();
                   return ResultUtil.fail("新增失败");
               }
           }else if (examineeChange!=null) {
               try {
                   examineeChange.setIsDelete("1");
                   examineeService.updateById(examineeChange);
                   System.out.print(examinee.toString());
                   examinee.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                   examinee.setUpdateTime(new Date(System.currentTimeMillis()));
                   examinee.setCreateTime(new Date(System.currentTimeMillis()));
                   examinee.setIsDelete("0");
                   examinee.setIsCheck("1");
                   System.out.print(examinee.toString());
                   examineeService.insert(examinee);
                   return ResultUtil.OK();
               } catch (Exception e) {
                   e.printStackTrace();
                   return ResultUtil.fail("新增失败");
               }
           }
           return ResultUtil.fail("新增失败");
       }

   /**
    * @Description: 用户查看报名信息
    * @Json:
    * @Date: 2018/7/6
    * @Return:
    */
   @PostMapping("/lookExam/{id}")
   @CrossOrigin
   public Result lookExam(@PathVariable("id")String id){
       //此id为account的id
       try {
           Examinee examinee=new Examinee();
           examinee=examineeService.getExamineeByAccountId(id);
           return ResultUtil.OK(examinee);
       }catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.selectError();
   }

    /**
     * @Description: 用于普通用户登录的接口
     * @Json: {
    "name": "string",
    "password": "string"
    }
     * @Date: 2018/7/3
     * @Return:
     */
    @PostMapping("/login")
    @CrossOrigin
    public Result login(@RequestBody Account account, HttpSession session) {
        String name=account.getName();
        String password=account.getPassword();
        if (name==null||name.trim().isEmpty()){
            return ResultUtil.fail("输入用户名不能为空");
        }
        if (password==null||password.trim().isEmpty()){
            return ResultUtil.fail("输入密码不能为空");
        }

        String key = null;
        for( int i=1;i<=5;i++){
            String s=Integer.toString(i);
            //获取当前系统状态
            //System.out.println(s);
            String content=timeInfoService.getContentById(s);
            //System.out.println(content);
            String workContent=content.substring(0,19);
            //System.out.println(workContent);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=new Date(System.currentTimeMillis());
            String nowTime=sdf.format(date);
            //System.out.println(nowTime);
            if (workContent.compareTo(nowTime)<0){
                key=s;
                System.out.println("key的值为："+key);
            }
        }
        //System.out.println(key);

        try {
            if (accountService.checkAccoutIsExist(name,password)==0){
                Account accountGet=accountService.getAccountByNameAndPassword(name,password);
                //System.out.print(accountGet.toString());
                session.setAttribute("account",accountGet);
                //session.setAttribute("accountId",accountGet.getId());
                //session.setAttribute("name",accountGet.getName());
                //session.setAttribute("certificateStyle",accountGet.getCertificateStyle());
                //session.setAttribute("crtificateNumber",accountGet.getCertificateNumber());
                //System.out.print(accountGet.getAccountStyle());
                Map<String,Object> map=new HashMap<>();
                map.put("account",accountGet);
                map.put("key",key);
                return ResultUtil.OK(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtil.fail("登入失败");
    }


    /**
    * @Description: 普通用户对自己账号进行修改
    * @Json:
    * @Date: 2018/7/4
    * @Return:
    */
   @PostMapping("/updateAccount")
   @CrossOrigin
    public Result updateAccount(@RequestBody @Valid Account account,BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           return ResultUtil.fail(bindingResult.getAllErrors().toString());
       }
       try {
           if (accountService.updateById(account)){
            return ResultUtil.OK();
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.updateError();
   }

   /**
    * @Description: 普通用户进行search
    * @Json:
    * @Date: 2018/7/6
    * @Return:
    */
   @PostMapping("/search/{subjectId}/{learnWay}")
    @CrossOrigin
    public Result search(@PathVariable("subjectId")String subjectId,@PathVariable("learnWay")String learnWay){
       List<String> list=schoolService.search(learnWay,subjectId);
       //System.out.println();
       List<School> schoolList=new ArrayList<>();
       School school=new School();
       try {
           for(String schoolName:list){
               school=schoolService.getSchoolByName(schoolName);
               schoolList.add(school);
           }
           return ResultUtil.OK(schoolList);
       }catch (Exception e){
           e.printStackTrace();
       }
       return ResultUtil.selectError();
   }
}
