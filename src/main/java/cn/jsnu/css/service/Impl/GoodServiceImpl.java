package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.GoodMapper;
import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.service.GoodService;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:52
 */
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;
    public void setGoodMapper(GoodMapper goodMapper){this.goodMapper=goodMapper;}

    /**
     * 新增一个商品
     * @param goods 商品
     * @return 影响条数
     */
    @Override
    public int addGoods(Goods goods) {
        String goodsId=RandomId.getRandomGoodId();
        while(findGoodsById(goodsId)!=null){
            goodsId=RandomId.getRandomGoodId();
        }
        goods.setGoodsId(goodsId);
        return goodMapper.addGoods(goods);
    }

    /**
     * 通过商品ID获取商品
     * @param goodsId 商品ID
     * @return 商品
     */
    @Override
    public Goods findGoodsById(String goodsId) {
        return goodMapper.findGoodsById(goodsId);
    }

    /**
     * 根据商品ID删除商品
     * @param goodsId 商品ID
     */
    @Override
    public void deleteGoodsById(String goodsId) {
        goodMapper.deleteGoodsById(goodsId);
    }

    /**
     * 更新商品信息
     * @param goods 商品
     */
    @Override
    public void updateGoods(Goods goods) {
        goodMapper.updateGoods(goods);
    }

    /**
     * 更新商品信息
     * @param goodsId 商品ID
     * @param goodsPrice 商品价格
     */
    @Override
    public void updateGoodsPrice(String goodsId, double goodsPrice) {
        Goods goods = new Goods();
        goods.setGoodsPrice(goodsPrice);
        goods.setGoodsId(goodsId);
        goodMapper.updateGoodsPrice(goods);
    }

    /**
     * 更新商品售价
     * @param goodsId 商品ID
     * @param goodsSalesPrice 商品售价
     */
    @Override
    public void updateGoodsSalesPrice(String goodsId, double goodsSalesPrice) {
        Goods goods=new Goods();
        goods.setGoodsId(goodsId);
        goods.setGoodsSalesPrice(goodsSalesPrice);
        goodMapper.updateGoodsSalesPrice(goods);
    }

    /**
     * 更新商品库存
     * @param goodsId 商品
     * @param goodsRemain 商品库存
     */
    @Override
    public void updateGoodsRemain(String goodsId, int goodsRemain) {
        Goods goods=new Goods();
        goods.setGoodsId(goodsId);
        goods.setGoodsRemain(goodsRemain);
        goodMapper.updateGoodsRemain(goods);
    }

    /**
     * 更新商品图片链接
     * @param goodsId 商品ID
     * @param goodsImage 商品图片
     */
    @Override
    public void updateGoodsImage(String goodsId, String goodsImage) {
        Goods goods=new Goods();
        goods.setGoodsId(goodsId);
        goods.setGoodsImage(goodsImage);
        goodMapper.updateGoodsImage(goods);
    }

    /**
     * 查找所有商品
     * @return 商品集合
     */
    @Override
    public List<Goods> findAllGoods() {
        return goodMapper.findAllGoods();
    }
    /**
     * 根据分类寻找商品
     * @param goodsCate 商品分类
     * @return 分类商品集合
     */
    @Override
    public List<Goods> findGoodsByCategory(String goodsCate) {
        return goodMapper.findGoodsByCategory(goodsCate);
    }

    /**
     * 根据商品名查找- 模糊查询
     * @param goodsName 商品名
     * @return 商品集合
     */
    @Override
    public List<Goods> findGoodsByName(String goodsName) {
        return goodMapper.findGoodsByName("%"+goodsName+"%");
    }


}
