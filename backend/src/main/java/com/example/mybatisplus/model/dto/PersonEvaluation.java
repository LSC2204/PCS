package com.example.mybatisplus.model.dto;

import lombok.Data;

@Data
public class PersonEvaluation {
    private String ID;//用户账号

    private String Name;

    private String t_name;

    private String time;

    private String score;

    private String feeling;

    private String eval_time;

    private String res_time;
}
