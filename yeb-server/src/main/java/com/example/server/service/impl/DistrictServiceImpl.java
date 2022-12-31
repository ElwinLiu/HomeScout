package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.DistrictMapper;
import com.example.server.mapper.HouseMapper;
import com.example.server.pojo.District;
import com.example.server.pojo.House;
import com.example.server.pojo.communityInfo;
import com.example.server.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class DistrictServiceImpl extends ServiceImpl<DistrictMapper, District> implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public float getAvg(String district) {
        QueryWrapper<House> wrapper = new QueryWrapper<>();
        wrapper.eq("district",district);
        wrapper.select("avg(price) as avg");
        List<Map<String, Object>> info = houseMapper.selectMaps(wrapper);
        return (float)(double)info.get(0).get("avg");
    }
}
