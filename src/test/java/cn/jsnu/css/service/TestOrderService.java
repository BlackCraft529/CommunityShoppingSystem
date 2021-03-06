package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.utils.MD5Util;
import cn.jsnu.css.vo.Order;
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
    @Qualifier("OrderServiceImpl")
    private OrderService orderService;

    @Test
    public void testAddOrder() {
        /*String json="{\"goodsInfo\":{\"034db61a861345f9bb681b7f283dd1e1\":7,\"09099d7e183349669e3596462bd8846d\":5,\"c8caa8d0ee694f48a84b91e5d7e02a10\":4},\"addressId\":\"1\"}\n";*/
        String json = "{\"goodsInfo\":{\"034db61a861345f9bb681b7f283dd1e1\":1},\"addressId\":\"7l6pW8STkTkX64700uvYR7uEW044m9Gh\"}";
        String userId = "0da6330bf9b9447d8f305eea29b4ae96";
        orderService.addOrder(json, userId);
    }

    @Test
    public void testFindAllOrders() {
        List<Order> orderList=orderService.findOrdersByUserId("0da6330bf9b9447d8f305eea29b4ae96");
        for(Order order:orderList){
            System.out.println(order+"\n\n\n");
        }
    }

    @Test
    public void testFindAllOrdersByStatusAndId() {
        List<Order> orderList=orderService.findOrdersByUserIdAndStatus("0da6330bf9b9447d8f305eea29b4ae96",1);
        for(Order order:orderList){
            System.out.println("OrderId="+order.getOrderId()+"  MarkId="+order.getMarkId()+"  GoodsList:");
            for(Goods goods:order.getGoodsList()){
                System.out.print(goods.getGoodsId()+" // ");
            }
            System.out.print("\n\n");
        }
    }

    @Test
    public void testFindOrdersByUserId(){
        String userId="762e98daddcd4aa080e8348a5139be82";
        for(Order order:orderService.findOrdersByUserId(userId)){
            for(Goods goods:order.getGoodsList()) {
                System.out.println(goods.getQuantity());
            }
        }
    }

    @Test
    public void testFindByVagueString(){
        //臻品 520玫瑰花束 DIY花材包 39.9元起 小束花礼 云南礼物 【相遇】粉玫瑰混搭花材（玫瑰+康乃馨+叶上黄金）
        System.out.println(orderService.findOrderByVagueString("3h9D29HJPj46","990921391fef49669d4b6235b730a840"));
    }

    @Test
    public void getMD5Password(){
        System.out.println(MD5Util.getSaltMD5("15152063727"));
    }

}