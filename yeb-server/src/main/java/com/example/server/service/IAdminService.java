package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Admin;
import com.example.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登陆之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 查询当前用户信息
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    boolean isExistsAdmin(String username);
}
