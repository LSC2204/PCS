package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Review;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 预约审核表 Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-07-03
 */
@Repository
public interface ReviewMapper extends BaseMapper<Review> {

    List<Review> getall();

    List<Review> get_by_teacher(@Param("item") String item);

    List<Review> get_by_result(@Param("item") String resultTime);
}
