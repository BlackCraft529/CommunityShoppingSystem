package cn.jsnu.css.service;

import cn.jsnu.css.pojo.ShopCart;
import java.util.List;
/**
 * @author 魏荣轩-18090248
 * @date 2020/5/15 20:25
 */
public interface ShopCartService {

    /**
     * 新增一个购物车记录
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param quantity 数量
     */
    void addShopCart(String userId,String goodsId,int quantity);

    /**
     * 根据用户ID和商品ID获取记录
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @return 购物车记录
     */
    ShopCart findShopCartByUserIdAndGoodsId(String userId,String goodsId);

    /**
     * 通过用户ID和商品ID删除记录
     * @param userId 用户ID
     * @param goodsId 商品ID
     */
    void deleteByUserIdAndGoodsId(String userId,String goodsId);

    /**
     * 通过用户ID查询购物车
     * @param userId 用户ID
     * @return 购物车记录
     */
    List<ShopCart> findShopCartByUserId(String userId);

    /**
     * 更新数量
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param quantity 数量
     */
    void updateQuantityByUserIdAndGoodsId(String userId,String goodsId,int quantity);
}
