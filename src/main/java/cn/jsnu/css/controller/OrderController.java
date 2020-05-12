package cn.jsnu.css.controller;

import cn.jsnu.css.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李广帅
 * @date 2020/5/5 21:00
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    @Qualifier("OrderServiceImpl")
    private OrderService orderService;

    @RequestMapping("/settlement")
    public String settlement() {
        return "settlementPage";
    }
}
