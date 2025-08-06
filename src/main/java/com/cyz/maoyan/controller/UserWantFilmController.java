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
        userWantFilmService.addUserWantFilm(userWantFilm);
        return AjaxResult.success();
    }

    @DeleteMapping("delete")
    public AjaxResult deleteUserWantFilm(Integer userId, Integer filmId){
        userWantFilmService.deleteUserWantFilm(userId, filmId);
        return AjaxResult.success();
    }
}
