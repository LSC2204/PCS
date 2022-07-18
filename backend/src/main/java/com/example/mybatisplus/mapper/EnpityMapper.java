package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Enpity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 空闲时间表 Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Repository
public interface EnpityMapper extends BaseMapper<Enpity> {

    List<Enpity> getall();

    List<Enpity> getall_have();

    List<Enpity> getenpity(@Param("item") List<String> item,@Param("item1") List<String> item1);


    List<Enpity> getbytime(@Param("item") String item);

    Enpity getbyteacher(@Param("item") String teacher);

    void update_by(@Param("item1") String teacherName, @Param("item2") String time);

    void update_add(@Param("item1") String teacherName, @Param("item2") String timeResult);

    List<Enpity> getbytime_no(@Param("item") String item);


    List<Enpity> getowner(@Param("item") String name);

    void update_agree(@Param("item1") String teacherId, @Param("item2") String noteTime);

    void update_end(@Param("item1") String teacherId, @Param("item2") String noteTime);
}
