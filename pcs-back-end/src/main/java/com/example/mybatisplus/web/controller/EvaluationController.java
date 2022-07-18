package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.mapper.EvaluationMapper;
import com.example.mybatisplus.mapper.ResultMapper;
import com.example.mybatisplus.model.domain.Report;
import com.example.mybatisplus.model.domain.Result;
import com.example.mybatisplus.model.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.EvaluationService;
import com.example.mybatisplus.model.domain.Evaluation;

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
@RequestMapping("/api/evaluation")
public class EvaluationController {

    private final Logger logger = LoggerFactory.getLogger( EvaluationController.class );

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    EvaluationMapper evaluationMapper;

    @Autowired
    ResultMapper resultMapper;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getById(@RequestBody Evaluation evaluation1)throws Exception {
        Evaluation  evaluation =  evaluationService.getById(evaluation1.getEvaluationId());
        return JsonResponse.success(evaluation);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deleteById(@RequestBody Evaluation evaluation1) throws Exception {
        evaluationService.removeById(evaluation1.getEvaluationId());
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateEvaluation(@RequestBody Evaluation  evaluation) throws Exception {
        evaluationService.updateById(evaluation);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Evaluation
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Evaluation  evaluation) throws Exception {
        evaluationService.save(evaluation);
        return JsonResponse.success(null);
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public JsonResponse save(@Param("resultId") int resultId,@Param("score") int score,@Param("fellings") String fellings){

        Evaluation evaluation = new Evaluation();
        Result result=new Result();

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();
        evaluation.setEvaluationTime(sdf.format(date));

        result=resultMapper.selectById(resultId);

        evaluation.setFellings(fellings);
        evaluation.setScore(score);
        evaluation.setTime(result.getTimeResult());
        evaluation.setTeacherName(result.getTeacherName());
        evaluation.setResultTime(result.getResultTime());
        evaluation.setUserId(result.getUserId());

        boolean eva1= evaluationService.save(evaluation);
        return JsonResponse.success(eva1);
    }

    @ResponseBody
    @GetMapping(value = "/getall_to_person")
    public JsonResponse getall(){
        List<Evaluation> re= evaluationMapper.getall();
        return JsonResponse.success(re);
    }

    @ResponseBody
    @GetMapping(value = "/getperson")
    public JsonResponse getall_person(){
        User user= SessionUtils.getCurrentUserInfo();
        List<Evaluation> re= evaluationMapper.getall_person(user.getName());
        return JsonResponse.success(re);
    }

    //教师查看自己的评价
    @ResponseBody
    @GetMapping(value = "/getteacher")
    public JsonResponse getall_teacher(){
        User user= SessionUtils.getCurrentUserInfo();
        List<Evaluation> re= evaluationMapper.getall_teacher(user.getName());
        return JsonResponse.success(re);
    }


    //根据教师名看评价
    @ResponseBody
    @PostMapping(value = "/getbyteacher")
    public JsonResponse getby_teacher(@Param("teacher_name") String teacher_name){
        List<Evaluation> re= evaluationMapper.getall_teacher(teacher_name);
        return JsonResponse.success(re);
    }

    //获得可请假时间
    @ResponseBody
    @GetMapping(value = "/get_note_time")
    public JsonResponse get_note_time(){
        User user= SessionUtils.getCurrentUserInfo();
        List<Evaluation> re= evaluationMapper.getall_teacher(user.getName());
        return JsonResponse.success(re);
    }
}

