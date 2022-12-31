package com.example.server.controller;

import com.example.server.pojo.*;
import com.example.server.service.IHouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Api(tags = "用户使用————房源类接口管理")
@RestController
public class SearchController {
    @Autowired
    private IHouseService houseService;
    @ApiOperation(value = "按条件查询房源")
    @PostMapping("/search")
    public List<House> search(@RequestBody HouseSearchParam houseSearchParam) {
        return houseService.search(houseSearchParam.getPage(), houseSearchParam.getCommunity(),
                houseSearchParam.getDistrict(), houseSearchParam.getPrice_low(),
                houseSearchParam.getPrice_high(), houseSearchParam.getType(),
                houseSearchParam.getArea_low(), houseSearchParam.getArea_high(),
                houseSearchParam.getOrder(), houseSearchParam.isDESC(),
                houseSearchParam.getDir());
    }

    @ApiOperation(value = "管理员查询房源")
    @PostMapping("/ManaSearch")
    public List<House> ManaSearch(@RequestBody manaSearchParam param){
        return houseService.manaSearch(param.getPage(), param.getCommunity(), param.getDistrict());
    }

    @ApiOperation(value = "返回管理页面信息")
    @PostMapping("/ManaPageInfo")
    public PageInfo getManaSearch(@RequestBody manaSearchParam param){
        return houseService.getManaPageInfo(param.getPage(), param.getCommunity(), param.getDistrict());
    }

    @ApiOperation(value = "返回页面信息")
    @PostMapping("/pageInfo")
    public PageInfo getPageInfo(@RequestBody HouseSearchParam houseSearchParam){
        return houseService.getPageInfo(houseSearchParam.getPage(), houseSearchParam.getCommunity(),
                houseSearchParam.getDistrict(), houseSearchParam.getPrice_low(),
                houseSearchParam.getPrice_high(), houseSearchParam.getType(),
                houseSearchParam.getArea_low(), houseSearchParam.getArea_high(),
                houseSearchParam.getOrder(), houseSearchParam.isDESC(),
                houseSearchParam.getDir());
    }

    @ApiOperation(value = "用户发布房源")
    @PostMapping("/Sell")
    public void sellHouse(@RequestBody House house){
        houseService.addHouse(house);
    }

    @ApiOperation(value = "查找行政区拥有的房源数")
    @GetMapping("/districtHouseNum")
    List<Map<String, Integer>> getDhouseNum() {
        return houseService.getDhouseNum();
    }

    @ApiOperation(value = "查找小区拥有的房源数")
    @GetMapping("/communitytHouseNum")
    List<communityInfo> getChouseNum() {
        return houseService.getChouseNum();
    }
}
