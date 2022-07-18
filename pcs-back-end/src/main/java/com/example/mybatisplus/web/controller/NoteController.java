package com.example.mybatisplus.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.mybatisplus.common.utls.SessionUtils;
import com.example.mybatisplus.mapper.EnpityMapper;
import com.example.mybatisplus.mapper.NoteMapper;
import com.example.mybatisplus.mapper.PersonMapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.model.domain.Enpity;
import com.example.mybatisplus.model.domain.Person;
import com.example.mybatisplus.model.domain.User;
import com.example.mybatisplus.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus.common.JsonResponse;
import com.example.mybatisplus.model.domain.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author cgl
 * @since 2022-07-04
 * @version v1.0
 */
@Controller
@RequestMapping("/api/note")
public class NoteController {

    private final Logger logger = LoggerFactory.getLogger( NoteController.class );

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private EnpityMapper enpityMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    PersonService personService;

    @Autowired
    EnpityService enpityService;

    @Autowired
    ReportService reportService;

    @Autowired
    ResultService resultService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    EvaluationService evaluationService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Note  note =  noteService.getById(id);
        return JsonResponse.success(note);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        noteService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateNote(Note  note) throws Exception {
        noteService.updateById(note);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Note
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Note  note) throws Exception {
        noteService.save(note);
        return JsonResponse.success(null);
    }

    //添加假条
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse add(@RequestBody Note  n) throws Exception {
        if(n.getNoteTime().length()<=0){
            return JsonResponse.failure("请选择请假时间");
        }
        Note note=new Note();
        User user= SessionUtils.getCurrentUserInfo();
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();
        note.setCreateTime(sdf.format(date));
        Person person=personService.getperson(user.getName());
        note.setIsFinish(0);
        note.setIsSuccess(0);
        note.setNoteTime(n.getNoteTime());
        note.setNoteReason(n.getNoteReason());
        note.setTeacherId(user.getName());
        note.setTeacherName(person.getPersonName());
        noteService.save(note);
        return JsonResponse.success(null);
    }

    //查看自己所有请假信息
    @RequestMapping(value = "/getowner", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getowner() throws Exception {

        User user= SessionUtils.getCurrentUserInfo();
        List<Note> note=noteMapper.getby_teacher(user.getName());
        return JsonResponse.success(note);
    }

    //查看所有请假信息
    @RequestMapping(value = "/getall", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getall() throws Exception {

        User user= SessionUtils.getCurrentUserInfo();
        List<Note> note=noteMapper.getall();
        return JsonResponse.success(note);
    }

    //同意请假
    @RequestMapping(value = "/agree", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse agree(@Param("noteId") int noteId) throws Exception {

        Note note=noteService.getById(noteId);
        note.setIsSuccess(1);
        noteService.updateById(note);
        enpityMapper.update_agree(note.getTeacherId(),note.getNoteTime());
        return JsonResponse.success("通过");
    }

    //驳回请假
    @RequestMapping(value = "/overrule", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse overrule(@Param("noteId") int noteId) throws Exception {

        Note note=noteService.getById(noteId);
        note.setIsSuccess(2);
        noteService.updateById(note);
        return JsonResponse.failure("驳回");
    }

    //销假
    @RequestMapping(value = "/end", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse end(@Param("noteId") int noteId) throws Exception {

        Note note=noteService.getById(noteId);
        enpityMapper.update_end(note.getTeacherId(),note.getNoteTime());
        note.setIsFinish(1);
        noteService.updateById(note);
        return JsonResponse.failure("销假成功");
    }
}

