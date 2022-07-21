package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Result;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 预约结果表 Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Repository
public interface ResultMapper extends BaseMapper<Result> {

    List<Result> getall();

    void update_isok(@Param("item1") boolean b,@Param("item2") int id);

    List<Result> getperson(@Param("item") String id);

    List<Result> getteacher(@Param("item") String teacehr_id);

    Result getone(@Param("id") Integer id);

}
