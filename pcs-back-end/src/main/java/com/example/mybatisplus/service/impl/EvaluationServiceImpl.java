package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.Enpity;
import com.example.mybatisplus.model.domain.Evaluation;
import com.example.mybatisplus.mapper.EvaluationMapper;
import com.example.mybatisplus.service.EvaluationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评价表 服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation> implements EvaluationService {

    @Override
    public Evaluation getByname(String name) {
        QueryWrapper<Evaluation> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id",name);
        Evaluation one=super.getOne(wrapper);
        return one;
    }
}
