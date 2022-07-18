package com.example.mybatisplus.mapper;

import com.example.mybatisplus.model.domain.Board;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cgl
 * @since 2022-07-17
 */
@Repository
public interface BoardMapper extends BaseMapper<Board> {

    List<Board> getall();

}
