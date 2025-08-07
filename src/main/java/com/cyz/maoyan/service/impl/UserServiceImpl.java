package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.entity.User;
import com.cyz.maoyan.mapper.UserMapper;
import com.cyz.maoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/7 下午3:08
 * @Version V1.0
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public int addUser(String username, String password) {
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            try {
                return userMapper.addUser(username, password);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            return 0;
        }
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateUser(User user) {
        try {
            return userMapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
