package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.model.domain.Enpity;
import com.example.mybatisplus.mapper.EnpityMapper;
import com.example.mybatisplus.model.domain.Person;
import com.example.mybatisplus.service.EnpityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 空闲时间表 服务实现类
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Service
public class EnpityServiceImpl extends ServiceImpl<EnpityMapper, Enpity> implements EnpityService {
    @Override
    public Enpity getByall(String teacher) {
        QueryWrapper<Enpity> wrapper=new QueryWrapper<>();
        wrapper.eq("teacher_id",teacher);
        Enpity one = super.getOne(wrapper);
        if(one.getSunM()<=0&&one.getSunA()<=0&&one.getSatM()<=0&&one.getSatA()<=0&&one.getFriM()<=0&&one.getFriA()<=0&&one.getThuM()<=0&&one.getThuA()<=0
        &&one.getWedM()<=0&&one.getWedA()<=0&&one.getTueM()<=0&&one.getTueA()<=0&&one.getMonA()<=0&&one.getMonM()<=0){
            return null;
        }
        return one;
    }

    @Override
    public Integer getBytime(String teacher, String time) {
        QueryWrapper<Enpity> wrapper=new QueryWrapper<>();
        wrapper.eq("teacher_id",teacher);
        Enpity one = super.getOne(wrapper);
        if(time.equals("mon_m")){
            if(one.getMonM()<=0){
                return null;
            }
            return one.getMonM();
        }else if(time.equals("mon_a")){
            if(one.getMonA()<=0){
                return null;
            }
            return one.getMonA();
        }else if(time.equals("tue_a")){
            if(one.getTueA()<=0){
                return null;
            }
            return one.getTueA();
        }else if(time.equals("tue_m")){
            if(one.getTueM()<=0){
                return null;
            }
            return one.getTueM();
        }else if(time.equals("wed_a")){
            if(one.getWedA()<=0){
                return null;
            }
            return one.getWedA();
        }else if(time.equals("wed_m")){
            if(one.getWedM()<=0){
                return null;
            }
            return one.getWedM();
        }else if(time.equals("thu_a")){
            if(one.getThuA()<=0){
                return null;
            }
            return one.getThuA();
        }else if(time.equals("thu_m")){
            if(one.getThuM()<=0){
                return null;
            }
            return one.getThuM();
        }else if(time.equals("fri_a")){
            if(one.getFriA()<=0){
                return null;
            }
            return one.getFriA();
        }else if(time.equals("fri_m")){
            if(one.getFriM()<=0){
                return null;
            }
            return one.getFriM();
        }else if(time.equals("sat_a")){
            if(one.getSatA()<=0){
                return null;
            }
            return one.getSatA();
        }else if(time.equals("sat_m")){
            if(one.getSatM()<=0){
                return null;
            }
            return one.getSatM();
        }else if(time.equals("sun_a")){
            if(one.getSunA()<=0){
                return null;
            }
            return one.getSunA();
        }else{
            if(one.getSunM()<=0){
                return null;
            }
            return one.getSunM();
        }
    }

    @Override
    public List<Enpity> getBy_only_time(String time) {
        QueryWrapper<Enpity> wrapper=new QueryWrapper<>();
        if(time.equals("mon_m")){
            wrapper.gt("mon_m",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("mon_a")){
            wrapper.gt("mon_a",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("tue_a")){
            wrapper.gt("tue_a",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("tue_m")){
            wrapper.gt("tue_m",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("wed_a")){
            wrapper.gt("wed_a",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("wed_m")){
            wrapper.gt("wed_m",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("thu_a")){
            wrapper.gt("thu_a",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("thu_m")){
            wrapper.gt("thu_m",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("fri_a")){
            wrapper.gt("fri_a",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("fri_m")){
            wrapper.gt("fri_m",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("sat_a")){
            wrapper.gt("sat_a",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("sat_m")){
            wrapper.gt("sat_m",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else if(time.equals("sun_a")){
            wrapper.gt("sun_a",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }else{
            wrapper.gt("sun_m",0);
            List<Enpity> all=super.list(wrapper);
            return all;
        }
    }

    @Override
    public Enpity getbynaem(String name) {
        QueryWrapper<Enpity> wrapper=new QueryWrapper<>();
        wrapper.eq("teacher_id",name);
        Enpity one=super.getOne(wrapper);
        return one;
    }
}
