package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Agency;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Elwin
 * @since 2022-07-03
 */
public interface IAgencyService extends IService<Agency> {
    int addCnt(int houseId);

    Agency getInfo(int houseId);
}
