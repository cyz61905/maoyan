package com.cyz.maoyan.dto;

import com.cyz.maoyan.entity.Film;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午4:32
 * @Version V1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class FilmDTO extends Film {
    private Double score;
}
