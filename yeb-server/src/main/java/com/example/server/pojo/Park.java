package com.example.server.pojo;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value="Park对象", description="")
public class Park implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String class1;

    private String class2;

    private String class3;

    private String address;

    private Float longitude;

    private Float latitude;


}
