package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Report;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 报告表 服务类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
public interface ReportService extends IService<Report> {

    List<Report> getByName(String name);
}
