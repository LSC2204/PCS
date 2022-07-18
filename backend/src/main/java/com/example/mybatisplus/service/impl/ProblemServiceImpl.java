package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Problem;
import com.example.mybatisplus.mapper.ProblemMapper;
import com.example.mybatisplus.service.ProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements ProblemService {

}
