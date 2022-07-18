package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.Person;
import com.example.mybatisplus.mapper.PersonMapper;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人信息表 服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-06-29
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    @Override
    public Person getperson(String name) {
        QueryWrapper<Person> wrapper=new QueryWrapper<>();
        wrapper.eq("name",name);
        Person one = super.getOne(wrapper);
        return one;
    }

    @Override
    public String getByname(String teachername) {

        QueryWrapper<Person> wrapper=new QueryWrapper<>();
        wrapper.eq("person_name",teachername);
        Person one = super.getOne(wrapper);
        return one.getName();
    }

    @Override
    public Person getByPerson(String userName) {
        QueryWrapper<Person> wrapper=new QueryWrapper<>();
        wrapper.eq("person_name",userName);
        Person one = super.getOne(wrapper);
        return one;
    }
}
