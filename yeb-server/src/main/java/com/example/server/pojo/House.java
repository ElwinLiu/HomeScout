package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Elwin
 * @since 2022-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="House对象", description="")
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "户型", required = true)
    private String type;

    @ApiModelProperty(value = "均价")
    private Float price;

    @ApiModelProperty(value = "建筑面积")
    @TableField("arch_area")
    private Float archArea;

    @ApiModelProperty(value = "套内面积", required = true)
    @TableField("in_area")
    private Float inArea;

    @ApiModelProperty(value = "房屋朝向")
    private String dir;

    @ApiModelProperty(value = "小区", required = true)
    private String community;

    @ApiModelProperty(value = "所在楼层")
    private Integer floor;

    @ApiModelProperty(value = "总楼层数")
    @TableField("sum_floor")
    private Integer sumFloor;

    @ApiModelProperty(value = "建造时间")
    private Integer year;

    @ApiModelProperty(value = "建筑类型")
    @TableField("arch_type")
    private String archType;

    @ApiModelProperty(value = "行政区", required = true)
    private String district;
}
