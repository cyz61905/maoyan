package com.cyz.maoyan.service;

import com.cyz.maoyan.dto.CommentDTO;
import com.cyz.maoyan.entity.Comment;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:42
 * @Version V1.0
 */

public interface CommentService {
    PageInfo<CommentDTO> getCommentListByFilmId(Integer pageNum, Integer pageSize, Integer filmId);

    void addComment(Comment comment);
}
