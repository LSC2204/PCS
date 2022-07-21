package com.example.mybatisplus.web.controller;

import com.example.mybatisplus.mapper.BoardMapper;
import com.example.mybatisplus.model.domain.Person;
import com.example.mybatisplus.model.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.service.BoardService;
import com.example.mybatisplus.model.domain.Board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author cgl
 * @since 2022-07-17
 * @version v1.0
 */
@Controller
@RequestMapping("/api/board")
public class BoardController {

    private final Logger logger = LoggerFactory.getLogger( BoardController.class );

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardMapper boardMapper;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Board  board =  boardService.getById(id);
        return JsonResponse.success(board);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse deleteById(@Param("id") int id) throws Exception {
        boardService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateBoard(@RequestBody Board  board) throws Exception {
        System.out.println(board);
        boardService.updateById(board);
        return JsonResponse.success(null);
    }

//    @ResponseBody
//    @PostMapping(value = "/update")
//    public JsonResponse update(@Param("title") String title,@Param("content") String content,@Param("time") String time,@Param("image") String image,@Param("boardId") int boardId){
////        User user=userService.getById(userId);
//        System.out.println(boardId);
//        Board board = boardService.getById(boardId);
//
//        boardService.updateById(board);
//        return JsonResponse.success("success");
//    }

    /**
    * 描述:创建Board
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Board  board) throws Exception {
        System.out.println(board.getBoardId());
        System.out.println(board.getContent());
        boardService.save(board);
        return JsonResponse.success(null);
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public JsonResponse save(@RequestBody Board  board) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();
        board.setTime(sdf.format(date));
        boardService.save(board);
        return JsonResponse.success("ok");
    }

    @GetMapping(value = "/getall")
    @ResponseBody
    public JsonResponse getall() throws Exception {
        List<Board> boards=new ArrayList<>();
        boards=boardMapper.selectList(null);
        return JsonResponse.success(boards);
    }
}

