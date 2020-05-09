package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.GoodMapper;
import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.service.GoodService;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;

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
     * @param goodsName 商品名
     * @param goodsSummary 商品概述
     * @param goodsCate 商品分类好
     * @param goodsPrice 商品定价
     * @param goodsSalesPrice 商品销售价
     * @param goodsRemain 商品库存
     * @param goodsImage 商品图片链接
     * @return 新增条数
     */
    @Override
    public int addGoods(String goodsName, String goodsSummary, int goodsCate, Double goodsPrice, Double goodsSalesPrice, Integer goodsRemain, String goodsImage) {
        String goodsId=RandomId.getRandomGoodId();
        while(findGoodsById(goodsId)!=null){
            goodsId=RandomId.getRandomGoodId();
        }
        return goodMapper.addGoods(new Goods(goodsId,goodsName,goodsSummary,goodsCate,goodsPrice,goodsSalesPrice,goodsRemain,goodsImage));
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
     * @param goodsId 商品ID
     * @param goodsName 商品名称
     * @param goodsSummary 商品概述
     * @param goodsCate 商品分类号
     * @param goodsPrice 商品定价
     * @param goodsSalesPrice 商品销售价
     * @param goodsRemain 商品库存
     * @param goodsImage 商品图片链接
     */
    @Override
    public void updateGoods(String goodsId,String goodsName,String goodsSummary,int goodsCate,double goodsPrice,double goodsSalesPrice,int goodsRemain,String goodsImage) {
        goodMapper.updateGoods(new Goods(goodsId,goodsName,goodsSummary,goodsCate,goodsPrice,goodsSalesPrice,goodsRemain,goodsImage));
    }

    /**
     * 更新商品信息
     * @param goodsId 商品ID
     * @param goodsPrice 商品价格
     */
    @Override
    public void updateGoodsPrice(String goodsId, double goodsPrice) {
        Goods goods = new Goods();
        goods.setGoodPrice(goodsPrice);
        goods.setGoodId(goodsId);
        goodMapper.updateGoodsPrice(goods);
    }


}
