package com.example.mybatisplus.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.TestService;
import com.example.mybatisplus.model.domain.Test;


/**
 *
 *  前端控制器
 *
 *
 * @author cgl
 * @since 2022-07-21
 * @version v1.0
 */
@Controller
@RequestMapping("/api/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger( TestController.class );

    @Autowired
    private TestService testService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Test  test =  testService.getById(id);
        return JsonResponse.success(test);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        testService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateTest(Test  test) throws Exception {
        testService.updateById(test);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Test
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Test  test) throws Exception {
        testService.save(test);
        return JsonResponse.success(null);
    }
}

