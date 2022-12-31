package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.mapper.AdminMapper;

import com.example.server.pojo.Admin;
import com.example.server.pojo.RespBean;
import com.example.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录成功返回登录信息
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        System.out.println("准备登录！");
         //验证一下验证码是否正确
         //在Session中拿到验证码
        String captcha = (String)request.getSession().getAttribute("captcha");
        // 验证码暂时关闭
        if (StringUtils.isEmpty(captcha) || !captcha.equals(code)) {
            // 在登录认证前先对比验证是否一样 (验证码为空， 或者与生成的不一样的话)
            return RespBean.error("验证码输入错误,请重新输入！");
        }

        // 登录
        Admin admin = getAdminByUserName(username);
        boolean exists = isExistsAdmin(username);
        if (!exists || !password.equals(admin.getPassword()) )
        {
            return RespBean.error("用户名或者密码不正确");
        }
        if (password.length() == 0) {
            return RespBean.error("请输入密码");
        }

        return RespBean.success("登录成功", admin.getRoles());
    }

    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", username));
    }
    @Override
    public boolean isExistsAdmin(String username){
        return adminMapper.selectCount(new QueryWrapper<Admin>().eq("username", username)) > 0;
    }

}
