package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.model.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 个人信息表 Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-06-29
 */
@Repository
public interface PersonMapper extends BaseMapper<Person> {

    List<Person> getall();

    List<Person> getteacher(@Param("loginUser") List<String> loginUser);

    List<Person> getuser(@Param("user") List<String> emt);

    Person selectByuserId(@Param("item") String item);


    ;
}
