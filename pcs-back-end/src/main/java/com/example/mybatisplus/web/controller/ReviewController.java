package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.mapper.EnpityMapper;
import com.example.mybatisplus.mapper.EvaluationMapper;
import com.example.mybatisplus.mapper.ResultMapper;
import com.example.mybatisplus.mapper.ReviewMapper;
import com.example.mybatisplus.model.domain.*;
import com.example.mybatisplus.service.PersonService;
import com.example.mybatisplus.service.ResultService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ReviewService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author cgl
 * @since 2022-07-03
 * @version v1.0
 */
@Controller
@RequestMapping("/api/review")
public class ReviewController {

    private final Logger logger = LoggerFactory.getLogger( ReviewController.class );

    @Autowired
    private ReviewService reviewService;

    @Autowired
    EvaluationMapper evaluationMapper;

    @Autowired
    ResultMapper resultMapper;

    @Autowired
    ReviewMapper reviewMapper;

    @Autowired
    ResultService resultService;

    @Autowired
    PersonService personService;

    @Autowired
    EnpityMapper enpityMapper;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Review  review =  reviewService.getById(id);
        return JsonResponse.success(review);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        reviewService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateReview(Review  review) throws Exception {
        reviewService.updateById(review);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Review
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Review  review) throws Exception {
        reviewService.save(review);
        return JsonResponse.success(null);
    }

    @ResponseBody
    @GetMapping(value = "/getall")
    public JsonResponse getall(){
        List<Review> re= reviewMapper.getall();
        return JsonResponse.success(re);
    }

    @ResponseBody
    @GetMapping(value = "/get_by_teacher")
    public JsonResponse get_by_teacher(){
        User user= SessionUtils.getCurrentUserInfo();
        List<Review> re= reviewMapper.get_by_teacher(user.getName());
        return JsonResponse.success(re);
    }

    @ResponseBody
    @PostMapping(value = "/get_by_result")
    public JsonResponse get_by_result(@Param("resultId") int resultId){
        Result result=resultService.getById(resultId);
        List<Review> re= reviewMapper.get_by_result(result.getResultTime());
        return JsonResponse.success(re);
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public JsonResponse save(@Param("resultId") int resultId,@Param("reviewMarks") String reviewMarks,@Param("reviewScore") int reviewScore){
        Result result=resultService.getById(resultId);
        User user=SessionUtils.getCurrentUserInfo();

        if(result.getIsOk()){
            return JsonResponse.failure("咨询师已完成此咨询");
        }

        Review review=new Review();
        if(user.getUserType().equals("4")){
            Person person=personService.getByPerson(result.getUserName());
            if(reviewScore<80){//如果分数小于80，代表需要咨询师
                person.setIsfirst(false);
                personService.updateById(person);

                SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                Date date = new Date();
                review.setReviewTime(sdf.format(date));
                review.setIsFirst(true);
                review.setResultTime(result.getResultTime());
                review.setReviewRemarks(reviewMarks);
                review.setReviewScore(reviewScore);
                review.setTime(result.getTimeResult());
                review.setTeacherId(result.getTeacherId());
                review.setTeacherName(result.getTeacherName());
                review.setUserId(result.getUserId());
                review.setUserName(result.getUserName());
                result.setIsOk(true);
                resultService.updateById(result);

                enpityMapper.update_add(result.getTeacherName(),result.getTimeResult());

                reviewService.save(review);
                return JsonResponse.success("提交成功且需要治疗");
            }else{
                person.setIsfirst(true);
                personService.updateById(person);

                SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                Date date = new Date();
                review.setReviewTime(sdf.format(date));
                review.setIsFirst(false);
                review.setResultTime(result.getResultTime());
                review.setReviewRemarks(reviewMarks);
                review.setReviewScore(reviewScore);
                review.setTime(result.getTimeResult());
                review.setTeacherId(result.getTeacherId());
                review.setTeacherName(result.getTeacherName());
                review.setUserId(result.getUserId());
                review.setUserName(result.getUserName());
                result.setIsOk(true);
                resultService.updateById(result);

                enpityMapper.update_add(result.getTeacherName(),result.getTimeResult());

                reviewService.save(review);
                return JsonResponse.success("提交成功且不需要治疗");
            }
        }
        else {
            Person person=personService.getByPerson(result.getUserName());
            if(reviewScore<80){
                person.setIsfirst(true);
                personService.updateById(person);

                SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                Date date = new Date();
                review.setReviewTime(sdf.format(date));
                review.setIsFirst(true);
                review.setResultTime(result.getResultTime());
                review.setReviewRemarks(reviewMarks);
                review.setReviewScore(reviewScore);
                review.setTime(result.getTimeResult());
                review.setTeacherId(result.getTeacherId());
                review.setTeacherName(result.getTeacherName());
                review.setUserId(result.getUserId());
                review.setUserName(result.getUserName());

                result.setIsOk(true);
                resultService.updateById(result);

                enpityMapper.update_add(result.getTeacherName(),result.getTimeResult());

                reviewService.save(review);
                return JsonResponse.success("提交成功,且需要继续治疗");
            }
            else{
                person.setIsfirst(false);
                personService.updateById(person);

                SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
                sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
                Date date = new Date();
                review.setReviewTime(sdf.format(date));
                review.setIsFirst(false);
                review.setResultTime(result.getResultTime());
                review.setReviewRemarks(reviewMarks);
                review.setReviewScore(reviewScore);
                review.setTime(result.getTimeResult());
                review.setTeacherId(result.getTeacherId());
                review.setTeacherName(result.getTeacherName());
                review.setUserId(result.getUserId());
                review.setUserName(result.getUserName());
                result.setIsOk(true);
                resultService.updateById(result);

                enpityMapper.update_add(result.getTeacherName(),result.getTimeResult());

                reviewService.save(review);
                return JsonResponse.success("提交成功，且不需要继续治疗");
            }

        }

    }



}

