package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.entity.UserWantFilm;
import com.cyz.maoyan.service.UserWantFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午9:22
 * @Version V1.0
 */

@RestController
@RequestMapping("user-want-film")
public class UserWantFilmController {
    @Autowired
    private UserWantFilmService userWantFilmService;

    @GetMapping("find")
    public AjaxResult findUserWantFilmByUserIdAndFilmId(@RequestParam("userId") Integer userId,
                                                     @RequestParam("filmId") Integer filmId){
        UserWantFilm userWantFilm = userWantFilmService.selectUserWantFilmByUserIdAndFilmId(userId, filmId);
        if (userWantFilm == null){
            return AjaxResult.error("用户未想看该影片");
        }
        return AjaxResult.success(userWantFilm);
    }

    @PostMapping("want")
    public AjaxResult addUserWantFilm(@RequestBody UserWantFilm userWantFilm){
        int i = userWantFilmService.addUserWantFilm(userWantFilm);
        if (i == -1){
            return AjaxResult.error("添加想看失败").code(500);
        }else if (i == 0){
            return AjaxResult.error("已想看").code(500);
        }else {
            return AjaxResult.success().msg("添加想看成功");
        }
    }

    @DeleteMapping("delete")
    public AjaxResult deleteUserWantFilm(Integer userId, Integer filmId){
        int i = userWantFilmService.deleteUserWantFilm(userId, filmId);
        if (i == -1){
            return AjaxResult.error("删除想看失败").code(500);
        } else if (i == 0) {
            return AjaxResult.error("未想看该影片").code(500);
        }else {
            return AjaxResult.success().msg("删除想看成功");
        }
    }
}
