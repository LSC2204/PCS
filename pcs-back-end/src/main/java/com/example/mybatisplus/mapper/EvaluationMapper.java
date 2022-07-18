package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 评价表 Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Repository
public interface EvaluationMapper extends BaseMapper<Evaluation> {

    List<Evaluation> getall();

    List<Evaluation> getall_person(@Param("item") String item);

    List<Evaluation> getall_teacher(@Param("item") String item);


}
