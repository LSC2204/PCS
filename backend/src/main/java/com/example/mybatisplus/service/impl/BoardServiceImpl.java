package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Board;
import com.example.mybatisplus.mapper.BoardMapper;
import com.example.mybatisplus.service.BoardService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-07-17
 */
@Service
public class BoardServiceImpl extends ServiceImpl<BoardMapper, Board> implements BoardService {

}
