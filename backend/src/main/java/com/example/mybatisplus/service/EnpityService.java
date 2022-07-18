package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Enpity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.model.domain.Evaluation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 空闲时间表 服务类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Repository
public interface EnpityService extends IService<Enpity> {


    Enpity getByall(String teacher);

    Integer getBytime(String teacher, String time);

    List<Enpity> getBy_only_time(String time);

    Enpity getbynaem(String name);


    ;

}
