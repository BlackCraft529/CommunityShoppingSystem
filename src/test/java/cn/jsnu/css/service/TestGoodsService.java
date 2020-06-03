package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/5/10 7:52 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestGoodsService {

    @Autowired
    @Qualifier("GoodServiceImpl")
    private GoodService goodService;

    @Test
    public void testFindGoodsById() {
        System.out.println(goodService.findGoodsById("13c84b9842ec4d7a8f000eef0901fa63"));
    }

    @Test
    public void findGoodsByCategory() {
        List<Goods> goodsList = goodService.findGoodsByCategory("dbeed826550f4d3d82ea9bb27478c381");
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void findGoodsByName() {
        List<Goods> goodsList = goodService.findGoodsByName("电脑");
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void testNewestGoodsList(){
        List<Goods> newestGoods=goodService.findNewestGoods(10);
        int i=1;
        for(Goods goods:newestGoods){
            System.out.println(i+++"  "+goods.getGoodsId()+"  "+goods.getGoodsCreateTime());
        }
    }

    @Test
    public void testHotGoodsList(){
        List<Goods> hotGoods=goodService.findHotGoods(10);
        int i=1;
        for(Goods goods:hotGoods){
            System.out.println(i+++"  "+goods.getGoodsId()+"  "+goods.getGoodsSales());
        }
    }
}
