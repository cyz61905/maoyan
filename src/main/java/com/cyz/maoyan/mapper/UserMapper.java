package com.cyz.maoyan.mapper;

import com.cyz.maoyan.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:44
 * @Version V1.0
 */

public interface UserMapper {
    User selectUserById(Integer id);
    List<User> selectUserList(Collection<Integer> ids);
    User login(String username, String password);
    int addUser(String username, String password);
    User selectUserByUsername(String username);
    int updateUser(User user);
}
