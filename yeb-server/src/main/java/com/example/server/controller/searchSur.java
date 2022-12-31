package com.example.server.controller;

import com.example.server.pojo.*;
import com.example.server.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "周边信息")
@RestController
public class searchSur {
    @Autowired
    private ISurroundingParkService surroundingParkService;
    @Autowired
    private ISurroundingSchoolService surroundingSchoolService;
    @Autowired
    private ISurroundingHospitalService surroundingHospitalService;
    @Autowired
    private ISurroundingShoppingService surroundingShoppingService;
    @Autowired
    private ISurroundingTrafficService surroundingTrafficService;
/*    @Autowired
    private IParkService parkService;
    @Autowired
    private ISchoolService schoolService;
    @Autowired
    private IHospitalService hospitalService;
    @Autowired
    private IShoppingService shoppingService;
    @Autowired
    private ITrafficService trafficService;*/

    @ApiOperation(value = "查询小区周边公园")
    @PostMapping("/getParks")
    List<SurroundingPark> getParks(@RequestBody SurPage surPage) {
        return surroundingParkService.getParks(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询小区周边学校")
    @PostMapping("/getSchools")
    List<SurroundingSchool> getSchools(@RequestBody SurPage surPage) {
        return surroundingSchoolService.getSchools(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询小区周边医院")
    @PostMapping("/getHospitals")
    List<SurroundingHospital> getHospitals(@RequestBody SurPage surPage) {
        return surroundingHospitalService.getHospitals(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询小区周边商圈")
    @PostMapping("/getShoppings")
    List<SurroundingShopping> getShoppings(@RequestBody SurPage surPage) {
        return surroundingShoppingService.getShoppings(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询小区周边交通")
    @PostMapping("/getTraffics")
    List<SurroundingTraffic> getTraffics(@RequestBody SurPage surPage) {
        return surroundingTrafficService.getTraffics(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询公园分页信息")
    @PostMapping("/getParkPageInfo")
    PageInfo getParkPageInfo(@RequestBody SurPage surPage) {
        return surroundingParkService.getPageInfo(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询学校分页信息")
    @PostMapping("/getSchoolPageInfo")
    PageInfo getSchoolPageInfo(@RequestBody SurPage surPage) {
        return surroundingSchoolService.getPageInfo(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询医院分页信息")
    @PostMapping("/getHospitalPageInfo")
    PageInfo getHospitalPageInfo(@RequestBody SurPage surPage) {
        return surroundingHospitalService.getPageInfo(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询商圈分页信息")
    @PostMapping("/getShoppingPageInfo")
    PageInfo getShoppingPageInfo(@RequestBody SurPage surPage) {
        return surroundingShoppingService.getPageInfo(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "查询交通分页信息")
    @PostMapping("/getTrafficPageInfo")
    PageInfo getTrafficPageInfo(@RequestBody SurPage surPage) {
        return surroundingTrafficService.getPageInfo(surPage.getName(), surPage.getCommunity(), surPage.getPage(), surPage.getDistrict());
    }

    @ApiOperation(value = "插入公园信息")
    @PostMapping("/addPark")
    void addPark(@RequestBody Park park) {
        surroundingParkService.addPark(park);
    }

    @ApiOperation(value = "插入学校信息")
    @PostMapping("/addSchool")
    void addPark(@RequestBody School school) {
        surroundingSchoolService.addSchool(school);
    }

    @ApiOperation(value = "插入医院信息")
    @PostMapping("/addHospital")
    void addPark(@RequestBody Hospital hospital) {
        surroundingHospitalService.addHospital(hospital);
    }

    @ApiOperation(value = "插入商圈信息")
    @PostMapping("/addShopping")
    void addPark(@RequestBody Shopping shopping) {
        surroundingShoppingService.addShopping(shopping);
    }

    @ApiOperation(value = "插入交通信息")
    @PostMapping("/addTraffic")
    void addPark(@RequestBody Traffic traffic) {
        surroundingTrafficService.addTraffic(traffic);
    }

    @ApiOperation(value = "删除医院信息")
    @PostMapping("/deleteHospital")
    void deleteHospital(@RequestBody Hospital hospital) {
        surroundingHospitalService.delete(hospital);
    }

    @ApiOperation(value = "更新医院信息")
    @PostMapping("/updateHospital")
    void updatePark(@RequestBody Hospital hospital) {
        surroundingHospitalService.update(hospital);
    }

    @ApiOperation(value = "更新学校信息")
    @PostMapping("/updateSchool")
    void updatePark(@RequestBody School school) {
        surroundingSchoolService.update(school);
    }

    @ApiOperation(value = "更新公园信息")
    @PostMapping("/updatePark")
    void updatePark(@RequestBody Park park) {
        surroundingParkService.update(park);
    }

    @ApiOperation(value = "更新商圈信息")
    @PostMapping("/updateShopping")
    void updatePark(@RequestBody Shopping shopping) {
        surroundingShoppingService.update(shopping);
    }

    @ApiOperation(value = "更新交通信息")
    @PostMapping("/updateTraffic")
    void updatePark(@RequestBody Traffic traffic) {
        surroundingTrafficService.update(traffic);
    }

    @ApiOperation(value = "删除公园信息")
    @PostMapping("/deletePark")
    void deletePark(@RequestBody Park park) {
        surroundingParkService.delete(park);
    }

    @ApiOperation(value = "删除学校信息")
    @PostMapping("/deleteSchool")
    void deleteSchool(@RequestBody School school) {
        surroundingSchoolService.delete(school);
    }

    @ApiOperation(value = "删除商圈信息")
    @PostMapping("/deleteShopping")
    void deleteShopping(@RequestBody Shopping shopping) {
        surroundingShoppingService.delete(shopping);
    }

    @ApiOperation(value = "删除交通信息")
    @PostMapping("/deleteTraffic")
    void deleteTraffic(@RequestBody Traffic traffic) {
        surroundingTrafficService.delete(traffic);
    }
}
