package cn.jsnu.css.dao;

import cn.jsnu.css.pojo.Goods;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:52
 */
public interface GoodMapper {
    /**
     * 添加商品
     * @param goods 商品
     * @return 添加条数
     */
    int addGoods(Goods goods);

    /**
     * 通过商品ID获取商品
     * @param goodsId 商品ID
     * @return 商品
     */
    Goods findGoodsById(String goodsId);

    /**
     * 删除商品信息
     * @param goodsId 商品ID
     */
    void deleteGoodsById(String goodsId);

    /**
     * 更新商品信息
     * @param goods 商品
     */
    void updateGoods(Goods goods);

    /**
     * 更新商品价格
     * @param goods 商品
     */
    void updateGoodsPrice(Goods goods);

}
