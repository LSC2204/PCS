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
 * 预约结果表
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Result对象", description="预约结果表")
public class Result extends Model<Result> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "result_id",type = IdType.AUTO)
    private Integer resultId;

    private String userId;

    private String timeResult;

    private Integer resultScore;

    private String teacherId;

    private Boolean isFirst;

    private String resultRemarks;

    private Boolean isSuccess;

    private String resultTime;

    private String userName;

    private String teacherName;

    private Boolean isOk;


    @Override
    protected Serializable pkVal() {
        return this.resultId;
    }

}
