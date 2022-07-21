package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.*;
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
 * @since 2022-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Board对象", description="")

public class Board extends Model<Board> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "board_id", type = IdType.AUTO)
    private Long boardId;

    private String title;

    private String content;

    private String time;

    private String image;

    @TableLogic
    @TableField("is_deleted")
    private Boolean deleted;
    @Override
    protected Serializable pkVal() {
        return this.boardId;
    }

}
