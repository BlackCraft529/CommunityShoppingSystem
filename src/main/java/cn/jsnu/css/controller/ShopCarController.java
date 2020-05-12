package cn.jsnu.css.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李广帅
 * @date 2020/5/12 6:36 下午
 */
@Controller
@RequestMapping("/cart")
public class ShopCarController {


    @RequestMapping("/shopCar")
    public String shopCart() {
        return "shopCar";
    }
}
