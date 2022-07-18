package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.mapper.EnpityMapper;
import com.example.mybatisplus.mapper.ReportMapper;
import com.example.mybatisplus.model.domain.Evaluation;
import com.example.mybatisplus.model.domain.Report;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.model.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.EnpityService;
import com.example.mybatisplus.model.domain.Enpity;

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
@RequestMapping("/api/enpity")
public class EnpityController {

    private final Logger logger = LoggerFactory.getLogger( EnpityController.class );

    @Autowired
    private EnpityService enpityService;

    @Autowired
    EnpityMapper enpityMapper;

    @Autowired
    ReportMapper reportMapper;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getById(@RequestBody Enpity id)throws Exception {
        Enpity  enpity =  enpityService.getById(id.getEnpityId());
        return JsonResponse.success(enpity);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deleteById(@RequestBody Enpity id) throws Exception {
        enpityService.removeById(id.getEnpityId());
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateEnpity(@RequestBody Enpity  enpity) throws Exception {
        enpityService.updateById(enpity);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Enpity
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Enpity  enpity) throws Exception {
        enpityService.save(enpity);
        return JsonResponse.success(null);
    }

    //保存空闲时间表
    @ResponseBody
    @PostMapping(value = "/save")
    public JsonResponse save(@RequestBody Enpity enpity){
        boolean enpity1= enpityService.save(enpity);
        return JsonResponse.success(enpity1);
    }

    //获取当前老师空闲时间
    @ResponseBody
    @GetMapping(value = "/getcur")
    public JsonResponse getcur(){
        User user= SessionUtils.getCurrentUserInfo();
        List<Enpity> re= enpityMapper.getowner(user.getName());
        return JsonResponse.success(re);
    }

     //获取所有老师空闲时间
    @ResponseBody
    @GetMapping(value = "/getall")
    public JsonResponse getall(){
        List<Enpity> re= enpityMapper.getall();
        return JsonResponse.success(re);
    }

    //动态查询
    @ResponseBody
    @PostMapping(value = "/getenpity")
    public JsonResponse getenpity(@RequestBody UserInfoDTO userInfoDTO){
        List<Enpity> re= enpityMapper.getenpity(userInfoDTO.getTime(),userInfoDTO.getTeacher());
        return JsonResponse.success(re);
    }

    //通过时间查老师
    @ResponseBody
    @PostMapping(value = "/get_by_time")
    public JsonResponse get_by_time(@Param("time") String time,@Param("isFirst") Boolean isFirst){
        if(time.length()<=0){
            return JsonResponse.failure("请输入正确的时间");
        }
        if(isFirst){//如果初访过了，返回咨询师名字
            List<Enpity> re= enpityMapper.getbytime(time);
            return JsonResponse.success(re);
        }else{
            List<Enpity> re= enpityMapper.getbytime_no(time);
            List<String> re1=new ArrayList<>();
            for(Enpity e:re)
            {
                re1.add(e.getTeacherName());
            }
            return JsonResponse.success(re1);
        }

    }

    //通过老师查时间，没初访过的不允许
    @ResponseBody
    @PostMapping(value = "/get_by_teacher")
    public JsonResponse get_by_teacher(@Param("teacher") String teacher){
        if(teacher.length()<=0){
            return JsonResponse.failure("请输入正确的老师");
        }
        Enpity re= enpityMapper.getbyteacher(teacher);
        if(re==null){
            return JsonResponse.failure("请输入正确的老师");
        }
        List<String> time=new ArrayList<>();
        if(re.getMonM()>0){
            time.add("mon_m");
        }
        if(re.getMonA()>0){
            time.add("mon_a");
        }
        if(re.getTueA()>0){
            time.add("tue_a");
        }
        if(re.getTueM()>0){
            time.add("tue_m");
        }
        if(re.getWedA()>0){
            time.add("wed_a");
        }
        if(re.getWedM()>0){
            time.add("wed_m");
        }
        if(re.getThuA()>0){
            time.add("thu_a");
        }
        if(re.getThuM()>0){
            time.add("thu_m");
        }
        if(re.getFriA()>0){
            time.add("fri_a");
        }
        if(re.getFriM()>0){
            time.add("fri_m");
        }
        if(re.getSatA()>0){
            time.add("sat_a");
        }
        if(re.getSatM()>0){
            time.add("sat_m");
        }
        if(re.getSunA()>0){
            time.add("sun_a");
        }
        if(re.getSunM()>0){
            time.add("sun_m");
        }
        return JsonResponse.success(time);
    }



    @ResponseBody
    @PostMapping (value = "/getenpity_teacher")
    public JsonResponse getenpity_teacher(@RequestBody Report report){
        Report report1=reportMapper.selectById(report.getReportId());
        String teacher=report1.getTeacherId();
        String time=report1.getTime();
        System.out.println(teacher+"&&"+time);
        if(teacher.length()>0){
            Enpity emt=enpityService.getByall(teacher);
            if(emt==null){
                return  JsonResponse.failure("failure");
            }
            if(time.length()==0){
                return JsonResponse.success(emt);
            }else{
                Integer emt1=enpityService.getBytime(teacher,time);
                if(emt1==null){
                    return  JsonResponse.failure("failure");
                }
                return JsonResponse.success(emt1);
            }
        }else{
            if(time.length()==0){
                List<Enpity> emt=enpityMapper.getall_have();
                if(emt.isEmpty()){
                    return  JsonResponse.failure("failure");
                }
                return JsonResponse.success(emt);
            }else{
                List<Enpity>  emt1=enpityService.getBy_only_time(time);
                if(emt1.isEmpty()){
                    return  JsonResponse.failure("failure");
                }
                return JsonResponse.success(emt1);
            }
        }
    }
}

