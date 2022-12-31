package com.example.server.controller;


import com.example.server.pojo.DistParam;
import com.example.server.service.IDistrictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Api(tags = "行政区管理与查询")
@RestController
public class DistrictController {
    @Autowired
    private IDistrictService districtService;

    @ApiOperation(value = "获取行政区房源均价")
    @PostMapping("/distAvgPrice")
    float distAvgPrice(@RequestBody DistParam distParam) {
        return districtService.getAvg(distParam.getDistrict());
    }
}
