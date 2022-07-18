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
 *
 * </p>
 *
 * @author cgl
 * @since 2022-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Note对象", description="")
public class Note extends Model<Note> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "note_id", type = IdType.AUTO)
    private Integer noteId;

    private String teacherId;

    private String teacherName;

    private String noteTime;

            @ApiModelProperty(value = "为0代表未审核，1是通过，2是驳回")
    private Integer isSuccess;

            @ApiModelProperty(value = "为0代表未未进行销假，1是销假成功")
    private Integer isFinish;

    private String noteReason;

    private  String createTime;


    @Override
    protected Serializable pkVal() {
        return this.noteId;
    }

}
