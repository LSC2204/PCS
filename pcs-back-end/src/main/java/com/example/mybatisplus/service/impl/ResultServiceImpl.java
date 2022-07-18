package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Result;
import com.example.mybatisplus.mapper.ResultMapper;
import com.example.mybatisplus.service.ResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预约结果表 服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result> implements ResultService {

}
