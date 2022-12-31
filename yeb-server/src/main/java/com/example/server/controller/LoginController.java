package com.example.server.controller;

import com.example.server.pojo.RespBean;
import com.example.server.pojo.Admin;
import com.example.server.pojo.AdminLoginParam;
import com.example.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * 登录
 */


@Api(tags = "登录类接口管理")
@RestController
public class LoginController {

    @Autowired
    HttpServletRequest request; //通过注解获取一个request

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录后返回登录结果")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        System.out.println(adminLoginParam.getUsername() + "," + adminLoginParam.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute("username", adminLoginParam.getUsername());
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(),adminLoginParam.getCode(), request);
    }

    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo() {
        String username = (String) request.getSession().getAttribute("username");
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        System.out.println(username);
        return admin;
    }

    @ApiOperation(value = "用户退出登录")
    @PostMapping("/logout")
    private RespBean logout(){
        return RespBean.success("注销成功!", "");
    }
}
