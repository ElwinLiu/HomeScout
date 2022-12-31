package com.example.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="管理员查询小区参数对象", description="")
public class CommunityDist {

    @ApiModelProperty(value = "行政区", required = true)
    private String district;

    @ApiModelProperty(value = "页面", required = true)
    private int page;

    @ApiModelProperty(value = "小区名称", required = true)
    private String name;
}
