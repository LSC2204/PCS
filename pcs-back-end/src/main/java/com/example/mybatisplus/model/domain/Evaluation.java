package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评价表
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Evaluation对象", description="评价表")
public class Evaluation extends Model<Evaluation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "evaluation_id",type = IdType.AUTO)
    private Integer evaluationId;

    private String userId;

    private String teacherName;

    private String time;

    private String fellings;

    private Integer score;

    private String evaluationTime;

    private String resultTime;


    @Override
    protected Serializable pkVal() {
        return this.evaluationId;
    }

}
