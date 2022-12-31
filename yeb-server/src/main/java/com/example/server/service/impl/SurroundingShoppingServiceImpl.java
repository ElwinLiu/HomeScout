package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.ShoppingMapper;
import com.example.server.mapper.SurroundingSchoolMapper;
import com.example.server.mapper.SurroundingShoppingMapper;
import com.example.server.pojo.*;
import com.example.server.service.ISurroundingShoppingService;
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
public class SurroundingShoppingServiceImpl extends ServiceImpl<SurroundingShoppingMapper, SurroundingShopping> implements ISurroundingShoppingService {
    @Autowired
    private SurroundingShoppingMapper surroundingShoppingMapper;
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public List<SurroundingShopping> getShoppings(String name, String community, int page, String district) {
        ExcludeEmptyQueryWrapper<SurroundingShopping> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        queryWrapper.eq("Community", community);
        return surroundingShoppingMapper.selectPage(new Page<SurroundingShopping>(page, 10), queryWrapper).getRecords();
    }

    @Override
    public PageInfo getPageInfo(String name, String community, int page, String district){
        ExcludeEmptyQueryWrapper<SurroundingShopping> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("Community", community);
        if (name.equals("")) name = null;
        if (district.equals("")) district = null;
        queryWrapper.like("district", district);
        queryWrapper.like("name", name);
        Page<SurroundingShopping> surroundingShopping = surroundingShoppingMapper.selectPage(new Page<>(page, 10), queryWrapper);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)surroundingShopping.getSize());
        pageInfo.setTotal((int)surroundingShopping.getTotal());
        pageInfo.setSum((int)surroundingShopping.getPages());
        return pageInfo;
    }

    @Override
    public void addShopping(Shopping shopping) {
        shoppingMapper.insert(shopping);
    }

    @Override
    public void update(Shopping shopping) {
        UpdateWrapper<Shopping> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("name", shopping.getName())
                .set("address", shopping.getAddress())
                .set("class1", shopping.getClass1())
                .set("class2", shopping.getClass2())
                .set("class3", shopping.getClass3())
                .set("longitude", shopping.getLongitude())
                .set("latitude", shopping.getLatitude());
        shoppingMapper.update(null, updateWrapper);
    }

    @Override
    public void delete(Shopping shopping) {
        UpdateWrapper<Shopping> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", shopping.getName());
        updateWrapper.eq("district", shopping.getAddress());
        shoppingMapper.delete(updateWrapper);
    }
}
