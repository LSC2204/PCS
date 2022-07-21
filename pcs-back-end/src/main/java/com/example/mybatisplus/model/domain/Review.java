package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 预约审核表
 * </p>
 *
 * @author cgl
 * @since 2022-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Review对象", description="预约审核表")
public class Review extends Model<Review> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "review_id", type = IdType.AUTO)
    private Integer reviewId;

    private String userId;

    private String userName;

    private String time;

    private Boolean isFirst;

    private String teacherId;

    private String teacherName;

    private String reviewRemarks;

    private Integer reviewScore;

    private String reviewTime;

    private String resultTime;



    @Override
    protected Serializable pkVal() {
        return this.reviewId;
    }

}
