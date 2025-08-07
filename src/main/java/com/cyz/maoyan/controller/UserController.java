package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.entity.User;
import com.cyz.maoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/7 下午3:10
 * @Version V1.0
 */


@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public AjaxResult login(String username, String password) {
//        String username = map.get("username");
//        String password = map.get("password");
        User user = userService.login(username, password);
        return user == null ? AjaxResult.error("用户名或密码错误") : AjaxResult.success(user);

    }

    @PostMapping("register")
    public AjaxResult register(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String alignPassword = map.get("alignPassword");
        if (Objects.equals(alignPassword, password)) {
            int i = userService.addUser(username, password);
            if (i == 1) return AjaxResult.success().msg("注册成功");
            else if (i == 0) {
                return AjaxResult.error("用户已存在");
            } else {
                return AjaxResult.error("注册失败");
            }
        } else {
            return AjaxResult.error("密码不一致");
        }
    }

    @GetMapping("{id}")
    public AjaxResult selectUserById(@PathVariable Integer id) {
        User user = userService.selectUserById(id);
        return user == null ? AjaxResult.error("用户不存在") : AjaxResult.success(user);
    }

    @PutMapping("update")
    public AjaxResult updateUser(@RequestBody User user) {
        int i = userService.updateUser(user);
        return i == 1 ? AjaxResult.success().msg("更新成功") : AjaxResult.error("更新失败");
    }
}
