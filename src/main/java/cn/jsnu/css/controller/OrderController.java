package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.Address;
import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.AddressService;
import cn.jsnu.css.service.GoodService;
import cn.jsnu.css.service.OrderService;
import cn.jsnu.css.vo.Order;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Autowired
    @Qualifier("GoodServiceImpl")
    private GoodService goodService;

    @Autowired
    @Qualifier("AddressServiceImpl")
    private AddressService addressService;


    @RequestMapping("/orderList")
    public String orderList(Integer status, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        List<Order> orderList;
        if (status != null) {
            orderList = orderService.findOrdersByUserIdAndStatus(userId, status);
        } else {
            orderList = orderService.findOrdersByUserId(userId);
        }
        model.addAttribute("orderList", orderList);
        return "orderList";
    }

    @RequestMapping("/settlement")
    @ResponseBody
    public String settlement(@RequestBody Map<String, Integer> selectedGoodsList, HttpServletRequest request, HttpSession session, Model model) {
        List<Goods> goods = new ArrayList<>();
        JSONObject json = new JSONObject();
        try {
            for (String key : selectedGoodsList.keySet()) {
                Goods goods1 = goodService.findGoodsById(key);
                goods1.setQuantity(selectedGoodsList.get(key));
                goods.add(goods1);
            }
            json.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            json.put("success", false);
        }
        session.setAttribute("goodsList", goods);
        return json.toString();
    }

    @RequestMapping("/settlementPage")
    public String settlementPage(Model model, HttpSession session) {
        List<Goods> goodsList = (List<Goods>) session.getAttribute("goodsList");
        if (goodsList == null) {
            return "/index";
        }
        Double money = 0.0;
        for (Goods goods : goodsList) {
            money += goods.getGoodsSalesPrice() * goods.getQuantity();
        }
        User user = (User) session.getAttribute("user");
        List<Address> addressList = addressService.findAddressByUserId(user.getUserId());
        model.addAttribute("money", money);
        model.addAttribute("goodsList", goodsList);
        model.addAttribute("addressList", addressList);
        return "settlementPage";
    }

    @RequestMapping("/addOrder")
    @ResponseBody
    public String addOrder(HttpSession session, HttpServletRequest request, @RequestBody String param) {
        System.out.println(param);
        JSONObject jsonObject = new JSONObject();
        try {
            User user = (User) session.getAttribute("user");
            orderService.addOrder(param, user.getUserId());
            jsonObject.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("success", false);
        }
        return jsonObject.toString();
    }
}
