package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.OrderMapper;
import cn.jsnu.css.pojo.Order;
import cn.jsnu.css.service.OrderService;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:55
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public void setOrderMapper(OrderMapper orderMapper){this.orderMapper=orderMapper;}

    /**
     * 新建一个订单
     * @param order 订单
     */
    @Override
    public void addOrder(String order) {
       /* String orderId= RandomId.getRandomOrderId();
        while(findOrderById(orderId)!=null){
            orderId= RandomId.getRandomOrderId();
        }
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        //生成 mark_id
        orderMapper.addOrder(order);*/
    }

    /**
     * 根据订单ID删除订单信息
     * @param orderId 订单ID
     */
    @Override
    public void deleteOrderById(String orderId) {
        orderMapper.deleteOrderById(orderId);
    }

    /**
     * 更新一个订单
     * @param order 订单
     */
    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    /**
     * 更新订单状态
     * @param orderId 订单ID
     * @param status  订单状态
     */
    @Override
    public void updateOrderStatus(String orderId, int status) {
        Order order=new Order();
        order.setOrderId(orderId);
        order.setStatus(status);
        orderMapper.updateOrderStatus(order);
    }

    /**
     * 查找所有订单
     * @return 订单合集
     * @deprecated
     */
    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    /**
     * 根据订单ID查询订单
     * @param orderId 订单ID
     * @return 订单
     */
    @Override
    public Order findOrderById(String orderId) {
        return orderMapper.findOrderById(orderId);
    }

    /**
     * 根据用户ID查找订单信息
     *
     * @param userId 客户ID
     * @return 订单合集
     */
    @Override
    public List<Order> findOrdersByUserId(String userId) {
        return orderMapper.findOrdersByUserId(userId);
    }

    /**
     * 根据用户ID和订单状态查询订单
     *
     * @param userId 用户ID
     * @param status 订单状态
     * @return 订单合集
     */
    @Override
    public List<Order> findOrdersByUserIdAndStatus(String userId, int status) {
        Map<String ,String> date=new HashMap<>();
        date.put("userId",userId);
        date.put("status",status+"");
        return orderMapper.findOrdersByUserIdAndStatus(date);
    }

}
