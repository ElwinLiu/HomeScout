package com.example.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.TrafficMapper;
import com.example.server.pojo.Traffic;
import com.example.server.service.ITrafficService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Service
public class TrafficServiceImpl extends ServiceImpl<TrafficMapper, Traffic> implements ITrafficService {

}
