package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;
import java.util.Date;
import java.util.List;

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
     * @param goodsSales 商品销量
     * @param goodsCreateTime 创建时间
     * @return 影响条数
     */
    int addGoods(String goodsName, String goodsSummary, String goodsCate,
                 Double goodsPrice, Double goodsSalesPrice, Integer goodsRemain, String goodsImage, int goodsSales, Date goodsCreateTime);

    /**
     * 通过商品ID获取商品
     * @param goodsId 商品ID
     * @return 商品
     */
    Goods findGoodsById(String goodsId);

    /**
     * 根据商品ID删除商品
     * @param goodsId 商品ID
     */
    void deleteGoodsById(String goodsId);

    /**
     * 更新商品信息
     * @param goodsId 商品ID
     * @param goodsName 商品名称
     * @param goodsSummary 商品概述
     * @param goodsCate 商品分类号
     * @param goodsPrice 商品定价
     * @param goodsSalesPrice 商品销售价
     * @param goodsRemain 商品库存
     * @param goodsImage 商品图片链接
     * @param goodsSales 商品销量
     * @param goodsCreateTime 商品创建时间
     */
    void updateGoods(String goodsId,String goodsName,String goodsSummary,
                     String goodsCate,double goodsPrice,double goodsSalesPrice,int goodsRemain,String goodsImage,int goodsSales,Date goodsCreateTime);

    /**
     * 更新商品价格
     * @param goodsId 商品ID
     * @param goodsPrice 商品价格
     */
    void updateGoodsPrice(String goodsId,double goodsPrice);

    /**
     * 更新商品售价
     * @param goodsId 商品ID
     * @param goodsSalesPrice 商品售价
     */
    void updateGoodsSalesPrice(String goodsId,double goodsSalesPrice);

    /**
     * 更新商品剩余数量
     * @param goodsId 商品
     * @param goodsRemain 商品库存
     */
    void updateGoodsRemain(String goodsId,int goodsRemain);

    /**
     * 更新商品图片链接
     * @param goodsId 商品ID
     * @param goodsImage 商品图片
     */
    void updateGoodsImage(String goodsId,String goodsImage);

    /**
     * 查找所有商品
     * @return 商品集合
     */
    List<Goods> findAllGoods();

    /**
     * 根据分类寻找商品
     * @param goodsCate 商品分类
     * @return 分类商品集合
     */
    List<Goods> findGoodsByCategory(String goodsCate);

    /**
     * 根据商品名查找- 模糊查询
     * @param goodsName 商品名
     * @return 商品集合
     */
    List<Goods> findGoodsByName(String goodsName);
}
