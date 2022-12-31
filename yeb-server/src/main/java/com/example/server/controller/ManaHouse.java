package com.example.server.controller;

import com.example.server.pojo.House;
import com.example.server.pojo.HouseSearchParam;
import com.example.server.service.IHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "管理员修改房源信息")
@RestController
public class ManaHouse {
    @Autowired
    private IHouseService houseService;
    @ApiOperation(value = "更新房源字段信息")
    @PostMapping("/updateHouse")
    public void search(@RequestBody House house) {
        houseService.updateHouse(house);
    }
}
