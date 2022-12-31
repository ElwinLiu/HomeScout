package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Hospital;
import com.example.server.pojo.PageInfo;
import com.example.server.pojo.Park;
import com.example.server.pojo.SurroundingHospital;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author Elwin
 * @since 2022-06-26
 */
public interface ISurroundingHospitalService extends IService<SurroundingHospital> {
    List<SurroundingHospital> getHospitals(String name, String community, int page, String district);

    PageInfo getPageInfo(String name, String community, int page, String district);

    void addHospital(Hospital hospital);

    void update(Hospital hospital);

    void delete(Hospital hospital);
}
