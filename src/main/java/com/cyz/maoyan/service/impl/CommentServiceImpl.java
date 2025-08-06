package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.dto.CommentDTO;
import com.cyz.maoyan.entity.Comment;
import com.cyz.maoyan.entity.User;
import com.cyz.maoyan.mapper.CommentMapper;
import com.cyz.maoyan.mapper.UserMapper;
import com.cyz.maoyan.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:43
 * @Version V1.0
 */

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<CommentDTO> getCommentListByFilmId(Integer pageNum, Integer pageSize, Integer filmId) {
        PageHelper.startPage(pageNum, pageSize);
        List<CommentDTO> list = commentMapper.getCommentListByFilmId(filmId);
        Set<Integer> userIds = list.stream().map(CommentDTO::getUserId).collect(Collectors.toSet());
        Map<Integer, User> userMap = userMapper.selectUserList(userIds).stream().collect(Collectors.toMap(User::getId, user -> user));
        for (CommentDTO commentDTO : list) {
            commentDTO.setUser(userMap.get(commentDTO.getUserId()));
        }
        PageInfo<CommentDTO> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void addComment(Comment comment) {
        comment.setDel(0);
        comment.setCreateTime(new Date());
        commentMapper.addComment(comment);
    }
}
