package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Report;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 报告表 Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Repository
public interface ReportMapper extends BaseMapper<Report> {

    List<Report> getall();
}
