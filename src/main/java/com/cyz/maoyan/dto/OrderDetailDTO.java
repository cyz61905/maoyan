package com.cyz.maoyan.dto;

import com.cyz.maoyan.entity.Cinema;
import com.cyz.maoyan.entity.CinemaFilmSession;
import com.cyz.maoyan.entity.Film;
import com.cyz.maoyan.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午10:39
 * @Version V1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO extends Order {
    private Film film;
    private CinemaFilmSession cinemaSession;
    private Cinema cinema;
}
