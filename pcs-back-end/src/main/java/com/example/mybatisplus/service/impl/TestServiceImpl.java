package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Test;
import com.example.mybatisplus.mapper.TestMapper;
import com.example.mybatisplus.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-07-21
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
