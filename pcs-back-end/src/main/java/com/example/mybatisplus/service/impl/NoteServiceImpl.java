package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.model.domain.Note;
import com.example.mybatisplus.mapper.NoteMapper;
import com.example.mybatisplus.service.NoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-07-04
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

}
