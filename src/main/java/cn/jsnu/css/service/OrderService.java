package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Order;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:54
 */
public interface OrderService {
    /**
     * 新建一个订单
     * @param order 订单
     */
    void addOrder(String order);

    /**
     * 根据订单ID删除订单信息
     * @param orderId 订单ID
     */
    void deleteOrderById(String orderId);

    /**
     * 更新一个订单
     * @param order 订单
     */
    void updateOrder(Order order);

    /**
     * 更新订单状态
     * @param orderId 订单ID
     * @param status 订单状态
     */
    void updateOrderStatus(String orderId,int status);

    /**
     * 查找所有订单
     * @return 订单合集
     */
    List<Order> findAllOrder();

    /**
     * 根据订单ID查询订单
     * @param orderId 订单ID
     * @return 订单
     */
    Order findOrderById(String orderId);
    /**
     * 根据用户ID查找订单信息
     * @param userId 客户ID
     * @return 订单合集
     */
    List<Order> findOrdersByUserId(String userId);

    /**
     * 根据用户ID和订单状态查询订单
     * @param userId 用户ID
     * @param status 订单状态
     * @return 订单合集
     */
    List<Order> findOrdersByUserIdAndStatus(String userId,int status);
}
