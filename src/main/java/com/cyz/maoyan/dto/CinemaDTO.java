package com.cyz.maoyan.dto;

import com.cyz.maoyan.entity.Cinema;
import lombok.*;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午4:20
 * @Version V1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDTO extends Cinema {
    private List<FilmDTO> filmList;
    private Integer lowPrice;
}
