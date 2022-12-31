package com.example.server.controller;


import com.example.server.pojo.Comment;
import com.example.server.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ElwinLiu
 * @since 2022-06-18
 */
@Api(tags = "评论管理系统")
@RestController
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @ApiOperation(value = "添加评论")
    @PostMapping("/addComment")
    public void addComment(@RequestParam Map<String, Object> comment) throws IOException {
        System.out.println(comment.get("houseId"));
        int id = Integer.parseInt((String)comment.get("houseId"));
        commentService.addComment((String)comment.get("username"),
                id, (String)comment.get("content"));
    }

    @ApiOperation(value = "根据房源id查找用户评论")
    @PostMapping("/getComment")
    public List<Comment> getComment(int houseId){
        return commentService.getComment(houseId);
    }

    @ApiOperation(value = "根据评论id删除评论")
    @PostMapping("/deleteComment")
    public void deleteComment(int id) {
        commentService.deleteComment(id);
    }

    @ApiOperation(value = "显示所有评论")
    @GetMapping("/showAllComments")
    public List<Comment> showAll() {
        return commentService.showAll();
    }
}
