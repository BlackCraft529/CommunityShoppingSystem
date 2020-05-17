package cn.jsnu.css.service;

import cn.jsnu.css.utils.RandomId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
