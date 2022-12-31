package com.example.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "HouseSearch对象", description = "")    // api文档注解
public class HouseSearchParam {
    @ApiModelProperty(value = "页面", required = true)
    private int page;
    @ApiModelProperty(value = "小区")
    private String community;
    @ApiModelProperty(value = "行政区")
    private String district;
    @ApiModelProperty(value = "最低价格")
    private String price_low;
    @ApiModelProperty(value = "最高价格")
    private String price_high;
    @ApiModelProperty(value = "户型")
    private String type;
    @ApiModelProperty(value = "最小面积")
    private String area_low;
    @ApiModelProperty(value = "最大面积")
    private String area_high;
    @ApiModelProperty(value = "按什么排序")
    private String order;
    @ApiModelProperty(value = "降序")
    private boolean DESC;
    @ApiModelProperty(value = "房屋朝向")
    private String dir;
}
