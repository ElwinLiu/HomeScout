package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.PageInfo;
import com.example.server.pojo.Park;
import com.example.server.pojo.School;
import com.example.server.pojo.SurroundingSchool;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Elwin
 * @since 2022-06-26
 */
public interface ISurroundingSchoolService extends IService<SurroundingSchool> {
    List<SurroundingSchool> getSchools(String name, String community, int page, String district);

    PageInfo getPageInfo(String name, String community, int page, String district);

    void addSchool(School school);

    void update(School school);

    void delete(School school);
}
