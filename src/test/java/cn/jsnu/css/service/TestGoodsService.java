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

    public void testAddGoods() {

    }


    @Test
    public void testFindGoodsById() {
        System.out.println(goodService.findGoodsById("f08d9059e95849f6b685e974c75f53eb"));
    }


    void deleteGoodsById() {}


    void updateGoods() {}


    void updateGoodsPrice() {}


    void updateGoodsSalesPrice() {}


    void updateGoodsRemain() {

    }


    void updateGoodsImage() {

    }



    void findAllGoods() {}


    void findGoodsByCategory(String goodsCate) {}


    void findGoodsByName(String goodsName) {}
}
