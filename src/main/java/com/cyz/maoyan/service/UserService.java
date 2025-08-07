package com.cyz.maoyan.service;

import com.cyz.maoyan.entity.User;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/7 下午3:07
 * @Version V1.0
 */

public interface UserService {
    User login(String username, String password);
    int addUser(String username, String password);
    User selectUserById(Integer id);
    int updateUser(User user);
}
