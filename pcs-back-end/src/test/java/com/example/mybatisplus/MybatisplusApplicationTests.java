package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.mapper.BoardMapper;
import com.example.mybatisplus.mapper.ReportMapper;
import com.example.mybatisplus.model.domain.Board;
import com.example.mybatisplus.model.domain.Report;
import com.example.mybatisplus.model.domain.Result;
import com.example.mybatisplus.service.ReportService;
import com.example.mybatisplus.service.ResultService;
import com.example.mybatisplus.web.controller.BoardController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

//    @Autowired
//    private AdminService adminService;
//    @Test
//    void contextLoads() {
//        Admin byId = adminService.getById(1);
//        System.out.println(byId);
//    }

    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private ResultService res;

    @Test
    void hh(){
        QueryWrapper<Result> wrapper = new QueryWrapper<>();
        wrapper.eq("result_id","19");
        System.out.println(res.getOne(wrapper));
    }

//    @Test
//    void hh2(){
//        Board
//    }



    @Test
    public void h(){
//        List<Dept> l=deptMapper.get55();
//
//        System.out.println("第一题");
//        List<Dept> list1= deptMapper.get1();
//        System.out.println(list1);
//        for(int i=0;i<list1.size();i++){
//
//            System.out.println(list1.get(i).getDname());
//        }
//        System.out.println("第二题");
//        List<Emp> list2= empMapper.get2();
//        for(int i=0;i<list2.size();i++){
//            System.out.println(list2.get(i).getEname());
//        }
//        System.out.println("第3题");
//        List<Emp> list3= empMapper.get3();
//        System.out.println(list3);
//        for(Emp emp:list3){
//            System.out.println(emp.getEname()+"   "+emp.getJob());
//        }
//        System.out.println("第四题");
//        List<Emp> list4= empMapper.get4();
//        for(Emp emp:list4){
//            System.out.println(emp.getEname());
//        }
//        System.out.println("第五题");
//        List<Emp> list5= empMapper.get5();
//        for(Emp emp:list5){
//            System.out.println(emp.getDept().getDname()+"\t"+emp.getEmpno()+"\t"+emp.getEname()+"\t"+emp.getJob()+"\t"+emp.getComm()+"\t"+emp.getDeptno()+"\t"+emp.getHiredate()
//                    +"\t"+emp.getMgr()+"\t"+emp.getSal()+"\t");
//
////            String str=emp.getDept().getDname()+"\t"+emp.getEmpno()+"\t"+emp.getEname()+"\t"+emp.getJob()+"\t"+emp.getComm()+"\t"+emp.getDeptno()+"\t"+emp.getHiredate()+"\t"+emp.getMgr()+"\t"+emp.getSal()+"\t";
////            str.format("%-8s");
////            System.out.println(str);
//        }
//        System.out.println("第六题");
//        List<Emp> list6= empMapper.get6();
//        for(Emp emp:list6){
//            System.out.println(emp.getEname()+"  "+emp.getJob());
//        }
//        System.out.println("第七题");
//        List<Emp> list7= empMapper.get7();
//        for(Emp emp:list7){
//            System.out.println(emp.getJob());
//        }
//        System.out.println("第八题");
//        List<Emp> list8= empMapper.get8();
//        for(Emp emp:list8){
//            System.out.println(emp.getEname());
//        }
//        System.out.println("第九题");
//        List<Emp> list9= empMapper.get9();
//        for(Emp emp:list9){
//            System.out.println(emp.getEname()+"  "+emp.getSal()+"   "+emp.getComm());
//        }


    }

}
