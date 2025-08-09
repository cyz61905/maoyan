package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.dto.OrderDTO;
import com.cyz.maoyan.entity.CinemaFilmSession;
import com.cyz.maoyan.entity.Order;
import com.cyz.maoyan.mapper.CinemaFilmSessionMapper;
import com.cyz.maoyan.mapper.CinemaMapper;
import com.cyz.maoyan.mapper.FilmMapper;
import com.cyz.maoyan.mapper.OrderMapper;
import com.cyz.maoyan.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午9:04
 * @Version V1.0
 */

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CinemaFilmSessionMapper cinemaFilmSessionMapper;
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private FilmMapper filmMapper;

    @Override
    @Transactional
    public OrderDTO addOrder(Order order) {
        Integer price = cinemaFilmSessionMapper.getPriceById(order.getSessionId());
        System.out.println("price = " + price);
        order.setPrice(price * order.getSeatList().split(",").length);
        order.setCreateTime(new Date());
        order.setState("0");
        order.setOrderNum(UUID.randomUUID().toString().replace("-", ""));
        order.setDel(0);
        try {
            orderMapper.addOrder(order);
            CinemaFilmSession cinemaFilmSession = cinemaFilmSessionMapper.selectCinemaFilmSessionById(order.getSessionId());
            String oldSeat = cinemaFilmSession.getSeat();
            ObjectMapper objectMapper = new ObjectMapper();
            int[][] seatArray = objectMapper.readValue(oldSeat, int[][].class);
            String[] seatList = order.getSeatList().split(",");
            for (String seat : seatList) {
                String[] split = seat.split("-");
                if (seatArray[Integer.parseInt(split[0])][Integer.parseInt(split[1])] == 1) {
                    throw new RuntimeException("该座位已售出");
                } else if (seatArray[Integer.parseInt(split[0])][Integer.parseInt(split[1])] == -1) {
                    throw new RuntimeException("座位非法");
                } else {
                    seatArray[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
                }
            }
            cinemaFilmSession.setSeat(objectMapper.writeValueAsString(seatArray));
            cinemaFilmSessionMapper.updateCinemaFilmSessionSeat(cinemaFilmSession);
            return orderMapper.selectOrderById(order.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public int cancelOrder(Integer id){
        int sessionId = orderMapper.getSessionIdByOrderId(id);
        CinemaFilmSession cinemaFilmSession = cinemaFilmSessionMapper.selectCinemaFilmSessionById(sessionId);
        String oldSeat = cinemaFilmSession.getSeat();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            int[][] seatArray = objectMapper.readValue(oldSeat, int[][].class);
            String[] seatList = orderMapper.selectOrderById(id).getSeatList().split(",");
            for (String seat : seatList) {
                String[] split = seat.split("-");
                seatArray[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 0;
            }
            cinemaFilmSession.setSeat(objectMapper.writeValueAsString(seatArray));
            cinemaFilmSessionMapper.updateCinemaFilmSessionSeat(cinemaFilmSession);
            orderMapper.cancelOrder(id);
            return 1;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteOrder(Integer id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public int payOrder(String orderId) {
        return orderMapper.payOrder(orderId);
    }

    @Override
    @Transactional
    public List<Map<String, Object>> selectOrderListByUserId(Integer userId) {
        List<Order> orders = orderMapper.selectOrderListByUserId(userId);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Order order : orders) {
            Map<String, Object> map = new HashMap<>();
            Integer sessionId = order.getSessionId();
            map.put("cinema", cinemaMapper.selectCinemaById(cinemaFilmSessionMapper.getCinemaIdBySessionId(sessionId)));
            map.put("cinemaSession",cinemaFilmSessionMapper.selectCinemaFilmSessionById(sessionId));
            map.put("film", filmMapper.selectFilmById(order.getFilmId()));
            map.put("order", order);
            list.add(map);
        }
        return list;
    }

    @Override
    public OrderDTO selectOrderById(Integer id) {
        return orderMapper.selectOrderById(id);
    }
}
