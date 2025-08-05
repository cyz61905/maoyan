package com.cyz.maoyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 上午11:53
 * @Version V1.0
 */

@SpringBootApplication
@MapperScan("com.cyz.maoyan.mapper")
public class MaoYanApplication {
    public static void main(String[] args) {
        SpringApplication.run(MaoYanApplication.class, args);
    }
}
