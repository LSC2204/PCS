package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.mapper.EnpityMapper;
import com.example.mybatisplus.mapper.ReportMapper;
import com.example.mybatisplus.mapper.ResultMapper;
import com.example.mybatisplus.model.domain.Problem;
import com.example.mybatisplus.model.domain.Report;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.service.EnpityService;
import com.example.mybatisplus.service.PersonService;
import com.example.mybatisplus.service.ProblemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ResultService;
import com.example.mybatisplus.model.domain.Result;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import static javafx.scene.input.KeyCode.R;


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
@RequestMapping("/api/result")
public class ResultController {

    private final Logger logger = LoggerFactory.getLogger( ResultController.class );

    @Autowired
    private ResultService resultService;

    @Autowired
    ResultMapper resultMapper;

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    PersonService personService;

    @Autowired
    EnpityMapper enpityMapper;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getById(@RequestBody Long id)throws Exception {
        Result  result =  resultService.getById(id);
        return JsonResponse.success(result);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deleteById(@RequestBody Long id) throws Exception {
        resultService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateResult(@RequestBody Result result) throws Exception {
        resultService.updateById(result);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Result
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Result  result) throws Exception {
        resultService.save(result);
        return JsonResponse.success(null);
    }

//    @ResponseBody
//    @PostMapping(value = "/save")
//    public JsonResponse save(@RequestBody Result result){
//        boolean re=resultService.save(result);
//        return JsonResponse.success(re);
//    }

    //获取所有结果
    @ResponseBody
    @GetMapping(value = "/getall")
    public JsonResponse getall(){
        List<Result> re= resultMapper.getall();
        return JsonResponse.success(re);
    }

    //获取个人结果
    @ResponseBody
    @PostMapping(value = "/getperson")
    public JsonResponse getperson(){
        User user= SessionUtils.getCurrentUserInfo();
        List<Result> re= resultMapper.getperson(user.getName());
        return JsonResponse.success(re);
    }

    //获取老师任务
    @ResponseBody
    @PostMapping(value = "/getteacher")
    public JsonResponse getteacher(){
        User user= SessionUtils.getCurrentUserInfo();
        List<Result> re= resultMapper.getteacher(user.getName());
        return JsonResponse.success(re);
    }

    //请求驳回
    @ResponseBody
    @PostMapping(value = "/reporttoresult_failure")
    public JsonResponse reporttoresult_failure(@RequestBody Report r){
        Result result = new Result();
        Report report=new Report();
        report=reportMapper.selectById(r.getReportId());

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();
        result.setResultTime(sdf.format(date));

        result.setIsFirst(report.getIsFirst());
        result.setUserId(report.getUserId());
        result.setTeacherId(null);
        result.setResultRemarks(report.getReviewRemarks());
        result.setTimeResult(null);
        result.setResultScore(report.getScore());
        result.setUserName(report.getUserName());
        result.setTeacherName(null);
        result.setIsSuccess(false);
        result.setIsOk(false);
        reportMapper.deleteById(r.getReportId());
        boolean re=resultService.save(result);
        return JsonResponse.success(re);
    }


    //成功分配
    @ResponseBody
    @PostMapping(value = "/reporttoresult_success")
    public JsonResponse reporttoresult_success(@RequestBody Report r){

        if(r.getTime().length()<=0){
            return JsonResponse.failure("时间不能为空");
        }
        if(r.getTeacherName().length()<=0){
            return JsonResponse.failure("老师不能为空");
        }
        Result result = new Result();
        Report report=new Report();
        report=reportMapper.selectById(r.getReportId());

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();
        result.setResultTime(sdf.format(date));

        result.setIsFirst(report.getIsFirst());
        result.setUserId(report.getUserId());

        result.setResultRemarks(report.getReviewRemarks());
        result.setTimeResult(r.getTime());
        result.setResultScore(report.getScore());
        result.setUserName(report.getUserName());
        result.setTeacherName(r.getTeacherName());

        String teachername=r.getTeacherName();//获取老师id
        String teacherID= personService.getByname(teachername);
        result.setTeacherId(teacherID);

        result.setIsSuccess(true);
        result.setIsOk(false);

        //老师空闲时间减一

         enpityMapper.update_by(r.getTeacherName(),r.getTime());

        reportMapper.deleteById(r.getReportId());
        boolean re=resultService.save(result);
        return JsonResponse.success(re);
    }

//    //咨询完成
//    @ResponseBody
//    @PostMapping(value = "/done")
//    public JsonResponse done(@Param("resultId") int resultId){
//        Result result=new Result();
//        result=resultService.getById(resultId);
//        if(result.getIsOk()==true){
//            return JsonResponse.failure("请求早已完成");
//        }
//        enpityMapper.update_add(result.getTeacherName(),result.getTimeResult());
//        resultMapper.update_isok(true,resultId);
//        return JsonResponse.success("success");
//    }
}



