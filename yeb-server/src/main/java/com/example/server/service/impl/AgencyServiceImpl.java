package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.AgencyMapper;
import com.example.server.pojo.Agency;
import com.example.server.pojo.House;
import com.example.server.service.IAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Elwin
 * @since 2022-07-03
 */
@Service
public class AgencyServiceImpl extends ServiceImpl<AgencyMapper, Agency> implements IAgencyService {
    @Autowired
    private AgencyMapper agencyMapper;
    @Override
    public int addCnt(int houseId) {
        UpdateWrapper<Agency> updateWrapper = new UpdateWrapper<>();
        int times = getInfo(houseId).getTimes();
        times++;
        updateWrapper
                .eq("houseId", houseId)
                .set("times", times);
        agencyMapper.update(null, updateWrapper);
        return times;
    }

    @Override
    public Agency getInfo(int houseId) {
        ExcludeEmptyQueryWrapper<Agency> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("houseId", houseId);
        queryWrapper.select("times");
        return agencyMapper.selectOne(queryWrapper);
    }
}
