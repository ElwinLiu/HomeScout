package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.District;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
public interface IDistrictService extends IService<District> {
    float getAvg(String district);
}
