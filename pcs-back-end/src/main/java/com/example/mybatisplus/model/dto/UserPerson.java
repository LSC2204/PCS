package com.example.mybatisplus.model.dto;

import lombok.Data;

@Data
public class UserPerson {
    private String name;//用户账号

    private String password;//密码

    private String email;//邮箱

    private String userType;//用户类型

    private String personName;//真实名字

    private String birthday;

    private String sex;

    private String phoneNumber;

    private String address;

    private Boolean isfirst;
}
