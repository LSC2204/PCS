package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.mapper.PersonMapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.model.domain.*;
import com.example.mybatisplus.model.dto.UserPerson;
import com.example.mybatisplus.service.*;
//import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author cgl
 * @since 2022-06-26
 * @version v1.0
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger( UserController.class );

    @Autowired
    private UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonService personService;

    @Autowired
    EnpityService enpityService;

    @Autowired
    ReportService reportService;

    @Autowired
    ResultService resultService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    EvaluationService evaluationService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getById(@RequestBody Long id)throws Exception {
        User  user =  userService.getById(id);
        return JsonResponse.success(user);
    }

    /**
    * 描述：根据Id删除
    *
    */
//    @RequestMapping(value = "/delete_user", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResponse deleteById(@Param("userId") int userId) throws Exception {
//        User user=userService.getById(userId);
//        Person person=personService.getperson(user.getName());
//        Enpity enpity=enpityService.getbynaem(user.getName());
//        Evaluation evaluation =evaluationService.getByname(user.getName());
//        Report report=
//        if(enpity.getTeacherId().length()>0){
//            enpityService.removeById(enpity.getEnpityId());//删除教师空闲时间表，如果有
//        }
//        personService.removeById(person.getPersonId());//删除person内容
//        userService.removeById(userId);//删除user内容
//        return JsonResponse.success(null);
//    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateUser(@RequestBody User  user) throws Exception {
        userService.updateById(user);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建User
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(User  user) throws Exception {
        userService.save(user);
        return JsonResponse.success(null);
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public JsonResponse login(@RequestBody User user){
        User loginUser=userService.login(user);
        if (loginUser!=null){
            SessionUtils.saveCurrentUserInfo(loginUser);
        }
        return JsonResponse.success(loginUser);
    }


    //获取当前用户session
    @ResponseBody
    @GetMapping(value = "getcur")
    public JsonResponse getcur(){
        User cur=SessionUtils.getCurrentUserInfo();
        return JsonResponse.success(cur);
    }

    //获取当前用户个人信息
    @ResponseBody
    @GetMapping(value = "getcurPerson")
    public JsonResponse getcurPerson(){
        User cur=SessionUtils.getCurrentUserInfo();
        Person person=personMapper.selectByuserId(cur.getName());
        return JsonResponse.success(person);
    }

    @ResponseBody
    @GetMapping(value = "deletecur")
    public JsonResponse deletecur(){
        User cur=SessionUtils.getCurrentUserInfo();
        if(cur!=null){
            SessionUtils.deteleteUser();
        }
        User cur1=SessionUtils.getCurrentUserInfo();
        return JsonResponse.success(cur1);
    }

    //获得老师所有
    @ResponseBody
    @GetMapping(value = "/getteacher")
    public JsonResponse getteacher(){

        List<User> loginUser=userMapper.getteacher();
        List<String> emt=new ArrayList<>();
        for(User u:loginUser){
            emt.add(u.getName());
        }
        List<Person> teacher= personMapper.getteacher(emt);

        return JsonResponse.success(teacher);
    }


    //获得老师所有名字
    @ResponseBody
    @GetMapping(value = "/getteacher_name")
    public JsonResponse getteacher_name(){

        List<User> loginUser=userMapper.getteacher();
        List<String> emt=new ArrayList<>();
        for(User u:loginUser){
            emt.add(u.getName());
        }
        List<Person> teacher= personMapper.getteacher(emt);
        List<String> e=new ArrayList<>();
        for(Person u:teacher){
            e.add(u.getPersonName());
        }
        return JsonResponse.success(e);
    }

    //获得初访老师所有
    @ResponseBody
    @GetMapping(value = "/getfirst")
    public JsonResponse getteacher_all(){

        List<User> loginUser=userMapper.getfirst();
        List<String> emt=new ArrayList<>();
        for(User u:loginUser){
            emt.add(u.getName());
        }
        List<Person> teacher= personMapper.getteacher(emt);
        return JsonResponse.success(teacher);
    }



    //获取所有普通用户
    @ResponseBody
    @GetMapping(value = "/getuser")
    public JsonResponse getuser(){

        List<User> loginUser=userMapper.getuser();
        List<String> emt=new ArrayList<>();
        for(User u:loginUser){
            emt.add(u.getName());
        }
        List<Person> user= personMapper.getuser(emt);
        List<String> e=new ArrayList<>();
//        for(Person u:user){
//            e.add(u.getPersonName());
//        }
        return JsonResponse.success(user);
    }

//    @ResponseBody
//    @GetMapping(value = "/getuser")
//    public JsonResponse gettuser(){
//
//        User loginUser=userMapper.getuser();
//        return JsonResponse.success(loginUser);
//    }


    @ResponseBody
    @PostMapping(value = "/update_person")
    public JsonResponse update_person(@Param("userId") String userId,@Param("password") String password,@Param("address") String address,@Param("phoneNumber") String phoneNumber,@Param("email") String email){
       User user=userService.getById(userId);
       Person person=personService.getperson(user.getName());
       if(password!=null){
           if(password.length()>0)
               user.setPassword(password);
       }
       if(password.length()>0){
           user.setPassword(password);
       }
        if(email.length()>0){
            user.setEmail(email);
        }

       if(address.length()>0){
           person.setAddress(address);
       }
       if (phoneNumber.length()>0){
           person.setPhoneNumber(phoneNumber);
       }
       userService.updateById(user);
       personService.updateById(person);
       return JsonResponse.success("success");
    }


    //需要传UserPerson类型信息 必须全部完整
    @ResponseBody
    @PostMapping(value = "/add_person")
    public JsonResponse add_person(@RequestBody UserPerson userPerson){
        if(userPerson.getName().length()>0&&userPerson.getAddress().length()>0&&userPerson.getBirthday().length()>0&&userPerson.getPassword().length()>0&&userPerson.getEmail().length()>0
        &&userPerson.getPersonName().length()>0&&userPerson.getPhoneNumber().length()>0&&userPerson.getSex().length()>0){
            User user=new User();
            Person person=new Person();

            int one=userMapper.getOne(userPerson.getName());
            if(one==1){
                return JsonResponse.failure("用户名已存在");
            }

            user.setEmail(userPerson.getEmail());
            user.setPassword(userPerson.getPassword());
            user.setName(userPerson.getName());
            user.setUserType(userPerson.getUserType());

            person.setPhoneNumber(userPerson.getPhoneNumber());
            person.setAddress(userPerson.getAddress());
            person.setIsfirst(true);
            person.setSex(userPerson.getSex());
            person.setName(userPerson.getName());
            person.setPersonName(userPerson.getPersonName());
            person.setBirthday(userPerson.getBirthday());
            userService.save(user);
            personService.save(person);
            return JsonResponse.success("添加成功");
        }
        return JsonResponse.failure("用户信息必须添加完整");
    }



}

