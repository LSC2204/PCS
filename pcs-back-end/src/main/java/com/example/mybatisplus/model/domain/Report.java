package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * 报告表
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Report对象", description="报告表")
public class Report extends Model<Report> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "report_id",type = IdType.AUTO)
    private Integer reportId;

    private String userId;

    private String teacherId;

    private String time;

    private Boolean isFirst;

    private String reviewRemarks;

    private int score;

    private String reportTime;

    private String userName;

    private String teacherName;



    @TableLogic
    @TableField("is_deleted")
    private Boolean deleted;

    @Override
    protected Serializable pkVal() {
        return this.reportId;
    }

}
