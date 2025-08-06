package com.cyz.maoyan.dto;

import com.cyz.maoyan.entity.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Map;

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
    private List<Atlas> atlasList;
    private Integer commentCount;
    private Map<String, List<FilmCast>> filmCastList;
    private List<Trailer> trailerList;
    private List<Type> typeList;
}
