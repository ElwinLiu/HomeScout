package com.example.server.pojo;

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
@ApiModel(value="Community对象", description="")
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "小区名", required = true)
    private String name;
    @ApiModelProperty(value = "行政区", required = true)
    private String district;
    @ApiModelProperty(value = "类型", required = true)
    private String type;
    @ApiModelProperty(value = "销售状态")
    private Boolean state;
    @ApiModelProperty(value = "容积率", required = true)
    private Float plot; //容积率
    @ApiModelProperty(value = "绿化率", required = true)
    private Float green;
    @ApiModelProperty(value = "价格", required = true)
    private Float price;
    @ApiModelProperty(value = "经度", required = true)
    private Float longitude;
    @ApiModelProperty(value = "纬度", required = true)
    private Float latitude;


}
