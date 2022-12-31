package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.HospitalMapper;
import com.example.server.mapper.SurroundingHospitalMapper;
import com.example.server.pojo.*;
import com.example.server.service.ISurroundingHospitalService;
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
public class SurroundingHospitalServiceImpl extends ServiceImpl<SurroundingHospitalMapper, SurroundingHospital> implements ISurroundingHospitalService {
    @Autowired
    private SurroundingHospitalMapper surroundingHospitalMapper;
    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public List<SurroundingHospital> getHospitals(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingHospital> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        queryWrapper.eq("Community", community);
        return surroundingHospitalMapper.selectPage(new Page<SurroundingHospital>(page, 10), queryWrapper).getRecords();
    }

    @Override
    public PageInfo getPageInfo(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingHospital> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("Community", community);
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        Page<SurroundingHospital> surroundingHospitalPage = surroundingHospitalMapper.selectPage(new Page<SurroundingHospital>(page, 10), queryWrapper);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)surroundingHospitalPage.getSize());
        pageInfo.setTotal((int)surroundingHospitalPage.getTotal());
        pageInfo.setSum((int)surroundingHospitalPage.getPages());
        return pageInfo;
    }

    @Override
    public void addHospital(Hospital hospital) {
        hospitalMapper.insert(hospital);
    }

    @Override
    public void update(Hospital hospital) {
        UpdateWrapper<Hospital> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("name", hospital.getName())
                .set("address", hospital.getAddress())
                .set("class1", hospital.getClass1())
                .set("class2", hospital.getClass2())
                .set("class3", hospital.getClass3())
                .set("longitude", hospital.getLongitude())
                .set("latitude", hospital.getLatitude());
        hospitalMapper.update(null, updateWrapper);
    }

    @Override
    public void delete(Hospital hospital) {
        UpdateWrapper<Hospital> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", hospital.getName());
        updateWrapper.eq("district", hospital.getAddress());
        hospitalMapper.delete(updateWrapper);
    }
}
