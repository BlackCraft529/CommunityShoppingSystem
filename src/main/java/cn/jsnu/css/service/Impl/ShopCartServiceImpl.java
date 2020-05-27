package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.ShopCartMapper;
import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.pojo.ShopCart;
import cn.jsnu.css.service.GoodService;
import cn.jsnu.css.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/15 20:25
 */
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private ShopCartMapper shopCartMapper;
    /**
     * 新增一个购物车记录
     * @param userId   用户ID
     * @param goodsId  商品ID
     * @param quantity 数量
     */
    @Override
    public void addShopCart(String userId, String goodsId, int quantity) {
        Map<String,String> date=new HashMap<>(2);
        date.put("userId",userId);
        date.put("goodsId",goodsId);
        if(shopCartMapper.findShopCartByUserIdAndGoodsId(date)!=null){
            int count=shopCartMapper.findShopCartByUserIdAndGoodsId(date).getQuantity()+quantity;
            shopCartMapper.updateQuantityByUserIdAndGoodsId(new ShopCart(userId,goodsId,count));
            return;
        }
        shopCartMapper.addShopCart(new ShopCart(userId,goodsId,quantity));
    }

    /**
     * 根据用户ID和商品ID获取记录
     * @param userId  用户ID
     * @param goodsId 商品ID
     * @return 购物车记录
     * @deprecated
     */
    @Override
    public ShopCart findShopCartByUserIdAndGoodsId(String userId, String goodsId) {
        Map<String , String> date=new HashMap<>(2);
        date.put("userId",userId);
        date.put("goodsId",goodsId);
        return shopCartMapper.findShopCartByUserIdAndGoodsId(date);
    }

    /**
     * 通过用户ID和商品ID删除记录
     * @param userId  用户ID
     * @param goodsId 商品ID
     */
    @Override
    public void deleteByUserIdAndGoodsId(String userId, String goodsId) {
        Map<String , String> date=new HashMap<>(2);
        date.put("userId",userId);
        date.put("goodsId",goodsId);
        shopCartMapper.deleteByUserIdAndGoodsId(date);
    }

    /**
     * 通过用户ID查询购物车
     * @param userId 用户ID
     * @return 购物车记录
     */
    @Override
    public List<Goods> findShopCartByUserId(String userId) {
        return shopCartMapper.findShopCartByUserId(userId);
    }

    /**
     * 更新数量
     * @param userId   用户ID
     * @param goodsId  商品ID
     * @param quantity 数量
     */
    @Override
    public void updateQuantityByUserIdAndGoodsId(String userId, String goodsId, int quantity) {
        shopCartMapper.updateQuantityByUserIdAndGoodsId(new ShopCart(userId,goodsId,quantity));
    }


}
