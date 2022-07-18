package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.mapper.PersonMapper;
import com.example.mybatisplus.mapper.ReportMapper;
import com.example.mybatisplus.mapper.ResultMapper;
import com.example.mybatisplus.model.domain.*;
import com.example.mybatisplus.service.PersonService;
import com.example.mybatisplus.service.ResultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ReportService;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/api/report")
public class ReportController {

    private final Logger logger = LoggerFactory.getLogger( ReportController.class );

    @Autowired
    private ReportService reportService;

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonService personService;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById()throws Exception {
        User user=SessionUtils.getCurrentUserInfo();
        if(user==null){
            return JsonResponse.failure("failure");
        }
        List<Report>  report =  reportService.getByName(user.getName());
        return JsonResponse.success(report);
    }


    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deleteById(@RequestBody Report id) throws Exception {
        reportService.removeById(id.getReportId());

        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateReport(@RequestBody Report  report) throws Exception {
        reportService.updateById(report);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Report
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Report  report) throws Exception {
        reportService.save(report);
        return JsonResponse.success(null);
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public JsonResponse save(@RequestBody Report report){
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();
        report.setReportTime(sdf.format(date));
        User user= SessionUtils.getCurrentUserInfo();
        if(user==null){
            return JsonResponse.failure("failure");
        }
        report.setUserId(user.getName());
        Person person= personService.getperson(user.getName());
        if(person==null){
            return JsonResponse.failure("failure");
        }
        String teachername=report.getTeacherName();
        if(teachername.length()>0){
            String teacherID= personService.getByname(teachername);
            report.setTeacherId(teacherID);
        }
        report.setIsFirst(person.getIsfirst());
        report.setUserName(person.getPersonName());
        boolean report1= reportService.save(report);
        return JsonResponse.success(report1);
    }

    @ResponseBody
    @GetMapping(value = "/getall")
    public JsonResponse getall(){
        List<Report> re= reportMapper.getall();
        return JsonResponse.success(re);
    }
}

