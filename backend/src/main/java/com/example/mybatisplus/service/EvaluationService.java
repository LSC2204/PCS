package com.example.mybatisplus.service;

import com.example.mybatisplus.model.domain.Evaluation;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评价表 服务类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
public interface EvaluationService extends IService<Evaluation> {

    Evaluation getByname(String name);
}
