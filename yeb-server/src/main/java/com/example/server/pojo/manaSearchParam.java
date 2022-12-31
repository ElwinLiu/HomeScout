package com.example.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 管理员搜索参数
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "manaSearchParam对象", description = "")    // api文档注解
public class manaSearchParam {
    @ApiModelProperty(value= "页面")
    private int page;
    @ApiModelProperty(value = "行政区")
    private String district;
    @ApiModelProperty(value = "小区")
    private String community;
}
