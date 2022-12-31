package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author Elwin
 * @since 2022-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("surrounding_park")
@ApiModel(value="SurroundingPark对象", description="VIEW")
public class SurroundingPark implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Community;

    private String district;

    private String name;

    private String class1;

    private String class2;

    private String class3;

    private Float latitude;

    private Float longitude;

    private Double distance;


}
