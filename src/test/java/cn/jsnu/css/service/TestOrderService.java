package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Goods;
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
        String json = "{\"goodsInfo\":{\"c8caa8d0ee694f48a84b91e5d7e02a10\":4},\"addressId\":\"1\"}";
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
    public void testUpdateStatus(){
        orderService.updateOrderStatus("M4W307iA7NuH",2);
    }
}
