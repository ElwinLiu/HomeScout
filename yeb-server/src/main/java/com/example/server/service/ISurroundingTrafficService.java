package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.PageInfo;
import com.example.server.pojo.Shopping;
import com.example.server.pojo.SurroundingTraffic;
import com.example.server.pojo.Traffic;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Elwin
 * @since 2022-06-26
 */
public interface ISurroundingTrafficService extends IService<SurroundingTraffic> {
    List<SurroundingTraffic> getTraffics(String name, String community, int page, String district);

    PageInfo getPageInfo(String name, String community, int page, String district);

    void addTraffic(Traffic traffic);

    void update(Traffic traffic);

    void delete(Traffic traffic);
}
