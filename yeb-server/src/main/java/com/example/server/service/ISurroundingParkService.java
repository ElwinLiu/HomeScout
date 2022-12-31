package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Hospital;
import com.example.server.pojo.PageInfo;
import com.example.server.pojo.Park;
import com.example.server.pojo.SurroundingPark;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Elwin
 * @since 2022-06-26
 */
public interface ISurroundingParkService extends IService<SurroundingPark> {
    List<SurroundingPark> getParks(String name, String community, int page, String district);

    PageInfo getPageInfo(String name, String community, int page, String district);

    void addPark(Park park);

    void update(Park park);

    void delete(Park park);
}
