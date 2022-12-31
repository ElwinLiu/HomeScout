package com.example.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private String role;

    /**
     * 成功返回结果
     *
     * @param message
     */
    public static RespBean success(String message, String role){
        return new RespBean(200, message, role);
    }

    /**
     * 失败返回结果
     *
     * @param message
     */
    public static RespBean error(String message) {
        return new RespBean(500, message, "XXX");
    }
}
