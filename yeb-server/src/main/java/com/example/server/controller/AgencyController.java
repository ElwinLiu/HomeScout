package com.example.server.controller;


import com.example.server.pojo.houseIdParam;
import com.example.server.service.IAgencyService;
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
 * @author Elwin
 * @since 2022-07-03
 */
@Api(tags = "经纪人带看房")
@RestController
public class AgencyController {
    @Autowired
    private IAgencyService agencyService;

    @ApiOperation(value = "经纪人带看房次数+1")
    @PostMapping("/AgencyHelp")
    public int AgencyHelp(@RequestBody houseIdParam t) {
        return agencyService.addCnt(t.getHouseId());
    }

    @ApiOperation(value = "获取经纪人带看次数")
    @PostMapping("/getAgencyCnt")
    public int getCnt(@RequestBody houseIdParam t) {
        return agencyService.getInfo(t.getHouseId()).getTimes();
    }
}
