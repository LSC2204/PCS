package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.mapper.PersonMapper;
import com.example.mybatisplus.model.domain.Enpity;
import com.example.mybatisplus.model.domain.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.PersonService;
import com.example.mybatisplus.model.domain.Person;

import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author cgl
 * @since 2022-06-29
 * @version v1.0
 */
@Controller
@RequestMapping("/api/person")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger( PersonController.class );

    @Autowired
    private PersonService personService;

    @Autowired
    PersonMapper personMapper;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getById(@RequestBody Person id)throws Exception {
        Person  person =  personService.getById(id.getPersonId());
        return JsonResponse.success(person);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deleteById(@RequestBody Person id) throws Exception {
        personService.removeById(id.getPersonId());
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/up", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updatePerson(@RequestBody Person  person) throws Exception {
        personService.updateById(person);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Person
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Person  person) throws Exception {
        personService.save(person);
        return JsonResponse.success(null);
    }

    @ResponseBody
    @PostMapping(value = "/save")
    public JsonResponse save(@RequestBody Person person){
        boolean re=personService.save(person);
        return JsonResponse.success(re);
    }

    @ResponseBody
    @GetMapping(value = "/getall")
    public JsonResponse getall(){
        List<Person> re= personMapper.getall();
        return JsonResponse.success(re);
    }

}

