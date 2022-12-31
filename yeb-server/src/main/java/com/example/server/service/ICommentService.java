package com.example.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.Comment;
import com.example.server.pojo.RespBean;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
public interface ICommentService extends IService<Comment> {
    public void addComment(String username, int houseId, String content) throws IOException;

    List<Comment> getComment(int houseId);

    void deleteComment(int id); //根据评论id删除评论

    List<Comment> showAll(); //返回所有评论
}
