package cn.jsnu.css.controller;

import cn.jsnu.css.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author wrx-18090248
 * @date 2020/5/5 21:00
 */
public class OrderController {
    @Autowired
    @Qualifier("OrderServiceImpl")
    private OrderService orderService;
}