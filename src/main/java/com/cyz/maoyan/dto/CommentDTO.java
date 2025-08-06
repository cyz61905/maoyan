package com.cyz.maoyan.dto;

import com.cyz.maoyan.entity.Comment;
import com.cyz.maoyan.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:28
 * @Version V1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO extends Comment {
    User user;
}
