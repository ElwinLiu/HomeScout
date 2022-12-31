package com.example.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SurPage对象", description = "")    // api文档注解
public class SurPage {
    @ApiModelProperty(value= "页面")
    private int page;
    @ApiModelProperty(value = "小区")
    private String community;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "行政区")
    private String district;
}
