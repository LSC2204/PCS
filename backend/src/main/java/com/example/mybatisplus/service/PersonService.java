package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Person;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 个人信息表 服务类
 * </p>
 *
 * @author cgl
 * @since 2022-06-29
 */
public interface PersonService extends IService<Person> {

     Person getperson(String name);

     String getByname(String teachername);

     Person getByPerson(String userName);
}

