package com.example.server.controller;


import com.example.server.pojo.*;
import com.example.server.service.ICommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Api(tags = "小区信息接口")
@RestController
public class CommunityController {
    @Autowired
    private ICommunityService communityService;

    @ApiOperation(value = "返回小区经纬度坐标")
    @PostMapping("/getPosition")
    public position getPos(@RequestBody CommunityName community) {
        return communityService.getPos(community.getName());
    }

    @ApiOperation(value = "根据 行政区/小区名 和页面数返回小区信息")
    @PostMapping("/getComInfo")
    public List<Community> getComInfo(@RequestBody CommunityDist communityDist) {
        return communityService.getComInfo(communityDist.getDistrict(), communityDist.getName(), communityDist.getPage());
    }

    @ApiOperation(value = "返回页面信息")
    @PostMapping("/getComPageInfo")
    public PageInfo getPageInfo(@RequestBody CommunityDist communityDist) {
        return communityService.getComPageInfo(communityDist.getDistrict(), communityDist.getPage());
    }

    @ApiOperation(value = "删除小区")
    @PostMapping("/deleteCom")
    public void deleteCom(@RequestBody Community community) {
        communityService.deleteCom(community);
    }

    @ApiOperation(value = "更新小区")
    @PostMapping("/updateCom")
    public void updateCom(@RequestBody Community community) {
        communityService.updateCom(community);
    }

    @ApiOperation(value = "根据经纬度查询小区")
    @PostMapping("/getComByPos")
    public Community getComByPos(@RequestBody position pos) {
        return communityService.getComByPos(pos);
    }

    @ApiOperation(value = "添加小区")
    @PostMapping("/addCommunity")
    public void addCommunity(@RequestBody Community community) {
        communityService.addCommunity(community);
    }
}
