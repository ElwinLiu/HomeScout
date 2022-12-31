package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.CommunityMapper;
import com.example.server.pojo.*;
import com.example.server.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements ICommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public List<communityInfo> getChouseNum(List<communityInfo> info) {
        for (int i = 0; i < info.size(); i++) {
            Community temp = communityMapper.selectOne(new QueryWrapper<Community>().eq("name", info.get(i).getName()));
            info.get(i).setLng(temp.getLongitude());
            info.get(i).setLat(temp.getLatitude());
        }
        return info;
    }

    @Override
    public position getPos(String name) {
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        wrapper.select("longitude", "latitude");
        List<Map<String, Object>> info = communityMapper.selectMaps(wrapper);
        position pos = new position();
        if (info.size() == 0) {
            pos.setLongitude(-1);
            pos.setLatitude(-1);
            return pos;
        }
        pos.setLatitude((float)info.get(0).get("latitude"));
        pos.setLongitude((float)info.get(0).get("longitude"));
        return pos;
    }

    @Override
    public List<Community> getComInfo(String district, String name, int page) {
        ExcludeEmptyQueryWrapper<Community> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        Page<Community> page1 = new Page<>(page,10);
        System.out.println(district);
        if (district.equals("")) district = null;
        if (name.equals("")) name = null;

        queryWrapper.eq("district", district);
        queryWrapper.like("name", name);

        return communityMapper.selectPage(page1, queryWrapper).getRecords();
    }

    @Override
    public PageInfo getComPageInfo(String district, int page) {
        ExcludeEmptyQueryWrapper<Community> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        Page<Community> page1 = new Page<>(page,10);
        if (district.equals("")) district = null;

        queryWrapper.like("district", district);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)communityMapper.selectPage(page1, queryWrapper).getSize());
        pageInfo.setTotal((int)communityMapper.selectPage(page1, queryWrapper).getTotal());
        pageInfo.setSum((int) communityMapper.selectPage(page1, queryWrapper).getPages());
        return pageInfo;
    }

    @Override
    public void deleteCom(Community community) {
        UpdateWrapper<Community> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", community.getName());
        updateWrapper.eq("district", community.getDistrict());
        communityMapper.delete(updateWrapper);
    }

    @Override
    public void updateCom(Community community) {
        UpdateWrapper<Community> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("name", community.getName())
                .set("district", community.getDistrict())
                .set("type", community.getType())
                .set("state", 0)
                .set("plot", community.getPlot())
                .set("green", community.getGreen())
                .set("price", community.getPrice())
                .set("longitude", community.getLongitude())
                .set("latitude", community.getLatitude());
        communityMapper.update(null, updateWrapper);
    }

    @Override
    public Community getComByPos(position pos) {
        System.out.println(pos.getLatitude());
        System.out.println(pos.getLongitude());
        ExcludeEmptyQueryWrapper<Community> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.like("longitude", pos.getLongitude());
        queryWrapper.like("latitude", pos.getLatitude());

        return communityMapper.selectOne(queryWrapper);
    }

    @Override
    public void addCommunity(Community community) {
        communityMapper.insert(community);
    }
}
