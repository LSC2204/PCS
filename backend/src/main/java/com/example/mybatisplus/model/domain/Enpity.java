package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 空闲时间表
 * </p>
 *
 * @author cgl
 * @since 2022-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Enpity对象", description="空闲时间表")
public class Enpity extends Model<Enpity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "enpity_id",type = IdType.AUTO)
    private Integer enpityId;

    private String teacherId;

    private String teacherName;

    private Integer teacherType;

    private Integer monM;

    private Integer monA;

    private Integer tueM;

    private Integer tueA;

    private Integer wedM;

    private Integer wedA;

    private Integer thuM;

    private Integer thuA;

    private Integer friM;

    private Integer friA;

    private Integer satM;

    private Integer satA;

    private Integer sunM;

    private Integer sunA;


    @Override
    protected Serializable pkVal() {
        return this.enpityId;
    }

}
