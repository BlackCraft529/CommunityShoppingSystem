package cn.jsnu.css.dao;

import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.pojo.ShopCart;
import java.util.List;
import java.util.Map;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/15 20:18
 */
public interface ShopCartMapper {

    /**
     * 新增一个购物车记录
     * @param shopCart 购物车
     */
    void addShopCart(ShopCart shopCart);

    /**
     * 通过用户ID和商品ID获取记录
     * @param date 数据
     * @return 购物车商品合集
     */
    Goods findShopCartByUserIdAndGoodsId(Map<String ,String> date);

    /**
     * 通过用户ID和商品ID删除记录
     * @param date 数据
     */
    void deleteByUserIdAndGoodsId(Map<String ,String> date);

    /**
     * 通过用户ID查询购物车
     * @param userId 用户ID
     * @return 购物车商品合集
     */
    List<Goods> findShopCartByUserId(String userId);

    /**
     * 通过用户ID和商品ID更新数量
     * @param shopCart 购物车类
     */
    void updateQuantityByUserIdAndGoodsId(ShopCart shopCart);
}
