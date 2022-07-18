package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Note;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-07-04
 */
@Repository
public interface NoteMapper extends BaseMapper<Note> {

    List<Note> getby_teacher(@Param("item") String name);

    List<Note> getall();
}
