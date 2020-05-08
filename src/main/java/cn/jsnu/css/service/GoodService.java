package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:52
 */
public interface GoodService {
    /**
     * 新增一个商品
     * @param goodsName 商品名
     * @param goodsSummary 商品概述
     * @param goodsCate 商品分类好
     * @param goodsPrice 商品定价
     * @param goodsSalesPrice 商品销售价
     * @param goodsRemain 商品库存
     * @param goodsImage 商品图片链接
     * @return
     */
    int addGoods(String goodsName, String goodsSummary, int goodsCate,
                 Double goodsPrice, Double goodsSalesPrice, Integer goodsRemain, String goodsImage);

    /**
     * 通过商品ID获取商品
     * @param goodsId 商品ID
     * @return 商品
     */
    Goods findGoodsById(String goodsId);
}
