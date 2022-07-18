package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Review;
import com.example.mybatisplus.mapper.ReviewMapper;
import com.example.mybatisplus.service.ReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预约审核表 服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-07-03
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

}
