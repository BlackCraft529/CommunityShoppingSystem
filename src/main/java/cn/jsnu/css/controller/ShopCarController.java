package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.ShopCartService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/5/12 6:36 下午
 */
@Controller
@RequestMapping("/cart")
public class ShopCarController {

    @Autowired
    @Qualifier("ShopCartServiceImpl")
    private ShopCartService shopCartService;


    @RequestMapping("/shopCar")
    public String shopCart(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Goods> goods = shopCartService.findShopCartByUserId(user.getUserId());
        model.addAttribute("goods", goods);
        return "shopCar";
    }

    /**
     * 添加商品至购物车
     * @param goodsId 商品ID
     * @param quantity 数量
     * @param session session对象
     * @return 添加成功
     */
    @RequestMapping("/addToShopCart")
    public @ResponseBody String addGoods(String goodsId, Integer quantity, HttpSession session) {
        User user = (User) session.getAttribute("user");
        JSONObject json = new JSONObject();
        if (user != null) {
            System.out.println("goodsId" + goodsId + "成功加入购物车," + quantity + "件!");
            shopCartService.addShopCart(user.getUserId(), goodsId, quantity);
            json.put("status", true);
        } else {
            json.put("status", false);
            json.put("reason", "notLogin");
        }
        return json.toString();
    }

    /**
     * 删除购物车中商品
     * @param goodsId 商品ID
     * @return 删除成功
     */
    @RequestMapping("/deleteGoods")
    public @ResponseBody String deleteGoods(String goodsId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println("goodsId" + goodsId + "\t成功删除购物车中商品,");
        shopCartService.deleteByUserIdAndGoodsId(user.getUserId(), goodsId);
        JSONObject json = new JSONObject();
        json.put("status", true);
        return json.toString();
    }

    /**
     * 修改购物车中商品数量
     * @param goodsId 商品ID
     * @param quantity 商品数量
     * @return 修改成功
     */
    @RequestMapping("/updateGoodsQuantity")
    public @ResponseBody String increaseGoods(String goodsId, Integer quantity, HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println("goodsId" + goodsId + "成功增加购物车中商品数量," + quantity + "件!");
        shopCartService.updateQuantityByUserIdAndGoodsId(user.getUserId(), goodsId, quantity);
        JSONObject json = new JSONObject();
        json.put("status", true);
        return json.toString();
    }


}
