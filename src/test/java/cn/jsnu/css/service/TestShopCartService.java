package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.pojo.ShopCart;
import cn.jsnu.css.utils.RandomId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/5/15 9:11 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestShopCartService {

    @Autowired
    @Qualifier("ShopCartServiceImpl")
    private ShopCartService shopCartService;

    @Test
    public void testAddGoods() {
        shopCartService.addShopCart("123", RandomId.getRandomGoodId(), 6);
    }

    @Test
    public void testGetUserCart(){
        List<Goods> allGoods=shopCartService.findShopCartByUserId("0da6330bf9b9447d8f305eea29b4ae96");
        System.out.println(allGoods.size());
        for(Goods goods:allGoods){
            System.out.println(goods);
        }
    }

    @Test
    public void testAddShopCart(){
        shopCartService.addShopCart("0da6330bf9b9447d8f305eea29b4ae96","034db61a861345f9bb681b7f283dd1e1",5);
    }

    @Test
    public void testFindGoodsByUserId() {
        List<Goods> goodsList = shopCartService.findShopCartByUserId("0da6330bf9b9447d8f305eea29b4ae96");
        for (Goods goods :
                goodsList) {
            System.out.println(goods);
        }
    }

}
