package com.cyz.maoyan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午3:59
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultPage {
    private Long total;
    private Integer pageTotal;
    private Object list;
}
