package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.Query.ExcludeEmptyQueryWrapper;
import com.example.server.mapper.CommentMapper;
import com.example.server.pojo.Comment;

import com.example.server.pojo.House;
import com.example.server.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public void addComment(String username, int houseId, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setHouseId(houseId);
        comment.setUsername(username);

        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        comment.setTime(sdf.format(date));
        // 创建用户对象
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> getComment(int houseId){
        ExcludeEmptyQueryWrapper<Comment> queryWrapper = new ExcludeEmptyQueryWrapper<>();
        queryWrapper.eq("houseId", houseId);
        return commentMapper.selectList(queryWrapper);
    }

    @Override
    public void deleteComment(int id){
        UpdateWrapper<Comment> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id);
        commentMapper.delete(updateWrapper);
    }

    @Override
    public List<Comment> showAll(){
        return commentMapper.selectList(new ExcludeEmptyQueryWrapper<>());
    }
}
