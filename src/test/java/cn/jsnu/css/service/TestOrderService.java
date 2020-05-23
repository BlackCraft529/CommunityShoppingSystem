package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.utils.JsonUtils;
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

    @Test
    public void testAddShopCart(){
        shopCartService.addShopCart("0da6330bf9b9447d8f305eea29b4ae96","034db61a861345f9bb681b7f283dd1e1",5);
    }

    @Test
    public void testAddOrder(){
        String json="{\"goodsInfo\":{\"034db61a861345f9bb681b7f283dd1e1\":7,\"09099d7e183349669e3596462bd8846d\":5,\"c8caa8d0ee694f48a84b91e5d7e02a10\":4},\"addressId\":\"1\"}\n";
        JsonUtils.parseJSONWithJSONObject(json);
    }
}
