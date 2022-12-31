package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.HouseMapper;
import com.example.server.pojo.*;
import com.example.server.service.ICommunityService;
import com.example.server.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.*;

import static java.util.Objects.isNull;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private ICommunityService communityService;
    @Override
    public List<House> search(int page, String community, String dist, String price_low,
                              String price_high, String type, String area_low,
                              String area_high, String order, boolean DESC, String dir){
        ExcludeEmptyQueryWrapper<House> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        Page<House> page1 = new Page<>(page,9);
        if (dist.equals("")) dist = null;
        if (community.equals("")) community = null;
        if (price_low.equals("")) price_low = null;
        if (price_high.equals("")) price_high = null;
        if (type.equals("")) type = null;
        if (area_low.equals("")) area_low = null;
        if (area_high.equals("")) area_high = null;
        if (order.equals("")) order = null;

        queryWrapper.like("community", community);
        System.out.println(dist);
        queryWrapper.like("district", dist);
        queryWrapper.like("dir", dir);
        queryWrapper.between("price", price_low, price_high);
        queryWrapper.like("type", type);
        queryWrapper.between("arch_area", area_low, area_high);
        if (!isNull(order)){
            if (DESC) {
                queryWrapper.orderByDesc(order);
            }
            else queryWrapper.orderByAsc(order);
        }
        return houseMapper.selectPage(page1, queryWrapper).getRecords();
    }

    @Override
    public PageInfo getPageInfo(int page, String community, String dist, String price_low,
                                String price_high, String type, String area_low,
                                String area_high, String order, boolean DESC, String dir){
        ExcludeEmptyQueryWrapper<House> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        Page<House> page1 = new Page<>(page,9);
        if (dist.equals("")) dist = null;
        if (community.equals("")) community = null;
        if (price_low.equals("")) price_low = null;
        if (price_high.equals("")) price_high = null;
        if (type.equals("")) type = null;
        if (area_low.equals("")) area_low = null;
        if (area_high.equals("")) area_high = null;
        if (order.equals("")) order = null;

        queryWrapper.like("community", community);
        System.out.println(dist);
        queryWrapper.like("district", dist);
        queryWrapper.like("dir", dir);
        queryWrapper.between("price", price_low, price_high);
        queryWrapper.eq("type", type);
        queryWrapper.between("arch_area", area_low, area_high);
        if (!isNull(order)){
            if (DESC) {
                queryWrapper.orderByDesc(order);
            }
            else queryWrapper.orderByAsc(order);
        }
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)houseMapper.selectPage(page1, queryWrapper).getSize());
        pageInfo.setTotal((int)houseMapper.selectPage(page1, queryWrapper).getTotal());
        pageInfo.setSum((int) houseMapper.selectPage(page1, queryWrapper).getPages());
        return pageInfo;
    }

    public List<House> manaSearch(int page, String community, String dist){
        ExcludeEmptyQueryWrapper<House> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        Page<House> page1 = new Page<>(page,9);
        if (dist.equals("")) dist = null;
        if (community.equals("")) community = null;

        queryWrapper.like("community", community);
        System.out.println(dist);
        queryWrapper.like("district", dist);

        return houseMapper.selectPage(page1, queryWrapper).getRecords();
    }

    public PageInfo getManaPageInfo(int page, String community, String dist){
        ExcludeEmptyQueryWrapper<House> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        Page<House> page1 = new Page<>(page,9);
        if (dist.equals("")) dist = null;
        if (community.equals("")) community = null;

        queryWrapper.like("community", community);
        System.out.println(dist);
        queryWrapper.like("district", dist);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCount((int)houseMapper.selectPage(page1, queryWrapper).getSize());
        pageInfo.setTotal((int)houseMapper.selectPage(page1, queryWrapper).getTotal());
        pageInfo.setSum((int) houseMapper.selectPage(page1, queryWrapper).getPages());
        return pageInfo;
    }

    public void updateHouse(House house) {
        UpdateWrapper<House> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                .eq("id", house.getId())
                .set("type", house.getType())
                .set("price", house.getPrice())
                .set("arch_area", house.getArchArea())
                .set("in_area", house.getInArea())
                .set("dir", house.getDir())
                .set("community", house.getCommunity())
                .set("floor", house.getFloor())
                .set("sum_floor", house.getSumFloor())
                .set("year", house.getYear())
                .set("arch_type", house.getArchType())
                .set("district", house.getDistrict());
        houseMapper.update(null, updateWrapper);
    }

    public void addHouse(House house) {
        houseMapper.insert(house);
    }

    @Override
    public List<Map<String, Integer>> getDhouseNum() {
        List<Map<String, Integer>> maps = new ArrayList<>();
        maps.add(getMap("江汉区"));
        maps.add(getMap("江岸区"));
        maps.add(getMap("汉阳区"));
        maps.add(getMap("硚口区"));
        maps.add(getMap("武昌区"));
        maps.add(getMap("青山区"));
        maps.add(getMap("洪山区"));
        maps.add(getMap("蔡甸区"));
        maps.add(getMap("江夏区"));
        maps.add(getMap("黄陂区"));
        maps.add(getMap("新洲区"));
        maps.add(getMap("东西湖区"));
        maps.add(getMap("汉南区"));
        return maps;
    }

    protected Map<String, Integer> getMap(String district) {
        int num = houseMapper.selectCount(new QueryWrapper<House>().eq("district", district));
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(district, num);
        return map;
    }

    public List<communityInfo> getChouseNum() {
        QueryWrapper<House> wrapper = new QueryWrapper<>();
        wrapper.groupBy("community");
        wrapper.select("community", "count(*) as count");
        List<communityInfo> res = new ArrayList<>();
        List<Map<String, Object>> info = houseMapper.selectMaps(wrapper);
        for (int i = 0; i < info.size(); i++){
            communityInfo temp = new communityInfo();
            temp.setCount((int)(long)info.get(i).get("count"));
            temp.setName((String)info.get(i).get("community"));
            res.add(temp);
        }
        return communityService.getChouseNum(res);
    }
}
