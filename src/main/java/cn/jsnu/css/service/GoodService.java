package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:52
 */
public interface GoodService {
    /**
     * 新增一个商品
     *
     * @param goods 商品
     * @return 影响条数
     */
    int addGoods(Goods goods);

    /**
     * 通过商品ID获取商品
     *
     * @param goodsId 商品ID
     * @return 商品
     */
    Goods findGoodsById(String goodsId);

    /**
     * 根据商品ID删除商品
     *
     * @param goodsId 商品ID
     */
    void deleteGoodsById(String goodsId);

    /**
     * 更新商品信息
     *
     * @param goods 商品
     */
    void updateGoods(Goods goods);

    /**
     * 更新商品价格
     *
     * @param goodsId 商品ID
     * @param goodsPrice 商品价格
     */
    void updateGoodsPrice(String goodsId,double goodsPrice);

    /**
     * 更新商品售价
     *
     * @param goodsId 商品ID
     * @param goodsSalesPrice 商品售价
     */
    void updateGoodsSalesPrice(String goodsId,double goodsSalesPrice);

    /**
     * 更新商品剩余数量
     *
     * @param goodsId 商品
     * @param goodsRemain 商品库存
     */
    void updateGoodsRemain(String goodsId,int goodsRemain);

    /**
     * 更新商品图片链接
     *
     * @param goodsId 商品ID
     * @param goodsImage 商品图片
     */
    void updateGoodsImage(String goodsId,String goodsImage);

    /**
     * 查找所有商品
     *
     * @return 商品集合
     */
    List<Goods> findAllGoods();

    /**
     * 根据分类寻找商品
     *
     * @param goodsCate 商品分类
     * @return 分类商品集合
     */
    List<Goods> findGoodsByCategory(String goodsCate);

    /**
     * 根据商品名查找- 模糊查询
     *
     * @param goodsName 商品名
     * @return 商品集合
     */
    List<Goods> findGoodsByName(String goodsName);

    /**
     * 查找最新的商品
     *
     * @param count 查找条数
     * @return 商品合集
     */
    List<Goods> findNewestGoods(int count);

    /**
     * 查找销量最多的商品
     *
     * @param count 查找条数
     * @return 商品合集
     */
    List<Goods> findHotGoods(int count);
}
