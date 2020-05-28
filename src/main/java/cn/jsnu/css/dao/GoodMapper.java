package cn.jsnu.css.dao;

import cn.jsnu.css.pojo.Goods;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:52
 */
public interface GoodMapper {
    /**
     * 添加商品
     *
     * @param goods 商品
     * @return 添加条数
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
     * 删除商品信息
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
     * @param goods 商品
     */
    void updateGoodsPrice(Goods goods);

    /**
     * 更新商品售价
     *
     * @param goods 商品
     */
    void updateGoodsSalesPrice(Goods goods);

    /**
     * 更新商品剩余数量
     *
     * @param goods 商品
     */
    void updateGoodsRemain(Goods goods);

    /**
     * 更新商品图片链接
     *
     * @param goods 商品
     */
    void updateGoodsImage(Goods goods);

    /**
     * 查找所有商品信息
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
