package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
public interface ICommunityService extends IService<Community> {
    List<communityInfo> getChouseNum(List<communityInfo> info);

    position getPos(String name);

    List<Community> getComInfo(String district, String name, int page);

    PageInfo getComPageInfo(String district, int page);

    void deleteCom(Community community);

    void updateCom(Community community);

    Community getComByPos(position pos);

    void addCommunity(Community community);
}
