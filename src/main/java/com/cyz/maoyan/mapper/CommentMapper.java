package com.cyz.maoyan.mapper;

import com.cyz.maoyan.dto.CommentDTO;
import com.cyz.maoyan.entity.Comment;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:28
 * @Version V1.0
 */

public interface CommentMapper {
    List<CommentDTO> getCommentListByFilmId(Integer filmId);

    void addComment(Comment comment);
}
