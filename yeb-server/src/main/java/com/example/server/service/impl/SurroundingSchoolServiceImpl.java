package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.SchoolMapper;
import com.example.server.mapper.SurroundingParkMapper;
import com.example.server.mapper.SurroundingSchoolMapper;
import com.example.server.pojo.*;
import com.example.server.service.ISurroundingSchoolService;
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
public class SurroundingSchoolServiceImpl extends ServiceImpl<SurroundingSchoolMapper, SurroundingSchool> implements ISurroundingSchoolService {
    @Autowired
    private SurroundingSchoolMapper surroundingSchoolMapper;
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<SurroundingSchool> getSchools(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingSchool> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        queryWrapper.eq("Community", community);
        return surroundingSchoolMapper.selectPage(new Page<>(page, 10), queryWrapper).getRecords();
    }

    @Override
    public PageInfo getPageInfo(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingSchool> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("Community", community);
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        Page<SurroundingSchool> surroundingSchool = surroundingSchoolMapper.selectPage(new Page<>(page, 10), queryWrapper);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)surroundingSchool.getSize());
        pageInfo.setTotal((int)surroundingSchool.getTotal());
        pageInfo.setSum((int)surroundingSchool.getPages());
        return pageInfo;
    }

    @Override
    public void addSchool(School school) {
        schoolMapper.insert(school);
    }

    @Override
    public void update(School school) {
        UpdateWrapper<School> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("name", school.getName())
                .set("address", school.getAddress())
                .set("class1", school.getClass1())
                .set("class2", school.getClass2())
                .set("class3", school.getClass3())
                .set("longitude", school.getLongitude())
                .set("latitude", school.getLatitude());
        schoolMapper.update(null, updateWrapper);
    }

    @Override
    public void delete(School school) {
        UpdateWrapper<School> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", school.getName());
        updateWrapper.eq("district", school.getAddress());
        schoolMapper.delete(updateWrapper);
    }
}
