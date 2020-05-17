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
 * @author 魏荣轩-18090248
 * @date 2020/5/16 22:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestOrderService {

    @Autowired
    @Qualifier("ShopCartServiceImpl")
    private ShopCartService shopCartService;

    @Test
    public void testGetUserCart(){
        List<Goods> allGoods=shopCartService.findShopCartByUserId("0da6330bf9b9447d8f305eea29b4ae96");
        System.out.println(allGoods.size());
        for(Goods goods:allGoods){
            System.out.println(goods);
        }
    }
}
