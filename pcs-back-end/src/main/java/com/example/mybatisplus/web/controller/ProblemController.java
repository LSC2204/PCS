package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.model.domain.Report;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.ProblemService;
import com.example.mybatisplus.model.domain.Problem;


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
@RequestMapping("/api/problem")
public class ProblemController {

    private final Logger logger = LoggerFactory.getLogger( ProblemController.class );

    @Autowired
    private ProblemService problemService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getById(@RequestBody Problem id)throws Exception {
        Problem  problem =  problemService.getById(id.getProId());
        return JsonResponse.success(problem);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deleteById(@RequestBody Problem id) throws Exception {
        problemService.removeById(id.getProId());
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateProblem(@RequestBody Problem  problem) throws Exception {
        problemService.updateById(problem);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Problem
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Problem  problem) throws Exception {
        problemService.save(problem);
        return JsonResponse.success(null);
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public JsonResponse save(@RequestBody Problem problem){
        boolean problem1= problemService.save(problem);
        return JsonResponse.success(problem1);
    }

}

