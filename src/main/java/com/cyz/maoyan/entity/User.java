package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:29
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String password;
    private String username;
    private String nickName;
    private String sex;
    private Date birthday;
    private String livingState;
    private String industry;
    private String interest;
    private String signature;
    private String avatar;
    private Integer del;
}
