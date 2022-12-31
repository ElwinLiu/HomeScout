package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.SurroundingShoppingMapper;
import com.example.server.mapper.SurroundingTrafficMapper;
import com.example.server.mapper.TrafficMapper;
import com.example.server.pojo.*;
import com.example.server.service.ISurroundingTrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author Elwin
 * @since 2022-06-26
 */
@Service
public class SurroundingTrafficServiceImpl extends ServiceImpl<SurroundingTrafficMapper, SurroundingTraffic> implements ISurroundingTrafficService {
    @Autowired
    private SurroundingTrafficMapper surroundingTrafficMapper;
    @Autowired
    private TrafficMapper trafficMapper;

    @Override
    public List<SurroundingTraffic> getTraffics(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingTraffic> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        queryWrapper.eq("Community", community);
        return surroundingTrafficMapper.selectPage(new Page<SurroundingTraffic>(page, 10), queryWrapper).getRecords();
    }

    @Override
    public PageInfo getPageInfo(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingTraffic> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("Community", community);
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        Page<SurroundingTraffic> surroundingTraffic = surroundingTrafficMapper.selectPage(new Page<>(page, 10), queryWrapper);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)surroundingTraffic.getSize());
        pageInfo.setTotal((int)surroundingTraffic.getTotal());
        pageInfo.setSum((int)surroundingTraffic.getPages());
        return pageInfo;
    }

    @Override
    public void addTraffic(Traffic traffic) {
        trafficMapper.insert(traffic);
    }

    @Override
    public void update(Traffic traffic) {
        UpdateWrapper<Traffic> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("name", traffic.getName())
                .set("address", traffic.getAddress())
                .set("class1", traffic.getClass1())
                .set("class2", traffic.getClass2())
                .set("class3", traffic.getClass3())
                .set("longitude", traffic.getLongitude())
                .set("latitude", traffic.getLatitude());
        trafficMapper.update(null, updateWrapper);
    }

    @Override
    public void delete(Traffic traffic) {
        UpdateWrapper<Traffic> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", traffic.getName());
        updateWrapper.eq("district", traffic.getAddress());
        trafficMapper.delete(updateWrapper);
    }
}
