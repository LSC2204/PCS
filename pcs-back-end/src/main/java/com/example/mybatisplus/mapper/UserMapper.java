package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> getteacher();

    List<User> getfirst();

    List<User> getuser();


    Integer getOne(@Param("item") String name);
}
