package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.dto.CommentDTO;
import com.cyz.maoyan.dto.ResultPage;
import com.cyz.maoyan.entity.Comment;
import com.cyz.maoyan.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午9:02
 * @Version V1.0
 */

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping("list")
    public AjaxResult getCommentListByFilmId(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                             @RequestParam(value = "pageSize",defaultValue = "1") Integer pageSize,
                                             Integer filmId){
        PageInfo<CommentDTO> pageInfo = commentService.getCommentListByFilmId(pageNum, pageSize, filmId);
        return AjaxResult.success(new ResultPage(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList()));
    }

    @PostMapping("add")
    public AjaxResult addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return AjaxResult.success();
    }
}
