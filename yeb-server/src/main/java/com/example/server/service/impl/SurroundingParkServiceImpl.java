package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.HospitalMapper;
import com.example.server.mapper.ParkMapper;
import com.example.server.mapper.SurroundingParkMapper;
import com.example.server.pojo.*;
import com.example.server.service.ISurroundingParkService;
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
public class SurroundingParkServiceImpl extends ServiceImpl<SurroundingParkMapper, SurroundingPark> implements ISurroundingParkService {
    @Autowired
    private SurroundingParkMapper surroundingParkMapper;
    @Autowired
    private ParkMapper parkMapper;

    @Override
    public List<SurroundingPark> getParks(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingPark> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        queryWrapper.eq("Community", community);
        return surroundingParkMapper.selectPage(new Page<SurroundingPark>(page, 10), queryWrapper).getRecords();
    }

    @Override
    public PageInfo getPageInfo(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingPark> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("Community", community);
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        Page<SurroundingPark> SurroundingPark = surroundingParkMapper.selectPage(new Page<>(page, 10), queryWrapper);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)SurroundingPark.getSize());
        pageInfo.setTotal((int)SurroundingPark.getTotal());
        pageInfo.setSum((int)SurroundingPark.getPages());
        return pageInfo;
    }

    @Override
    public void addPark(Park park) {
        parkMapper.insert(park);
    }

    @Override
    public void update(Park park) {
        UpdateWrapper<Park> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("name", park.getName())
                .set("address", park.getAddress())
                .set("class1", park.getClass1())
                .set("class2", park.getClass2())
                .set("class3", park.getClass3())
                .set("longitude", park.getLongitude())
                .set("latitude", park.getLatitude());
        parkMapper.update(null, updateWrapper);
    }

    @Override
    public void delete(Park park) {
        UpdateWrapper<Park> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", park.getName());
        updateWrapper.eq("district", park.getAddress());
        parkMapper.delete(updateWrapper);
    }
}
