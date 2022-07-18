package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.Person;
import com.example.mybatisplus.model.domain.Report;
import com.example.mybatisplus.mapper.ReportMapper;
import com.example.mybatisplus.service.ReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

/**
 * <p>
 * 报告表 服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {


    @Override
    public List<Report> getByName(String name) {
        QueryWrapper<Report> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id",name);
        List<Report> all=super.list(wrapper);
        System.out.println(all);
        return all;
    }
}
