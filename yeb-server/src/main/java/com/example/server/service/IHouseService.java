package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
public interface IHouseService extends IService<House> {
    List<House> search(int page, String community, String dist, String price_low,
                       String price_high, String type, String area_low,
                       String area_high, String order, boolean DESC, String dir);

    PageInfo getPageInfo(int page, String community, String dist, String price_low,
                         String price_high, String type, String area_low,
                         String area_high, String order, boolean DESC, String dir);

    List<House> manaSearch(int page, String community, String dist);

    PageInfo getManaPageInfo(int page, String community, String dist);

    void updateHouse(House house);

    void addHouse(House house);

    List<Map<String, Integer>> getDhouseNum();

    List<communityInfo> getChouseNum();
}
