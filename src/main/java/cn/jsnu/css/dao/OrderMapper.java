package cn.jsnu.css.dao;

import cn.jsnu.css.pojo.Order;
import java.util.List;
import java.util.Map;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:55
 */
public interface OrderMapper {
    /**
     * 新建一个订单
     *
     * @param order 订单
     */
    void addOrder(Order order);

    /**
     * 根据订单ID删除订单信息
     *
     * @param orderId 订单ID
     */
    void deleteOrderById(String orderId);

    /**
     * 更新一个订单
     *
     * @param order 订单
     */
    void updateOrder(Order order);

    /**
     * 更新订单状态
     *
     * @param order 订单
     */
    void updateOrderStatus(Order order);

    /**
     * 查找所有订单
     *
     * @return 订单合集
     */
    List<Order> findAllOrder();

    /**
     * 根据订单ID查询订单
     *
     * @param orderId 订单ID
     * @return 订单
     */
    Order findOrderById(String orderId);

    /**
     * 根据用户ID查找订单信息
     *
     * @param userId 客户ID
     * @return 订单合集
     */
    List<Order> findOrdersByUserId(String userId);

    /**
     * 根据⽤户ID和订单状态查找订单信息
     *
     * @param date 用户ID和订单状态
     * @return 订单合集
     */
    List<Order> findOrdersByUserIdAndStatus(Map<String,String> date);

    /**
     * 查询MarkId是否存在于数据库
     *
     * @param markId 标识符ID
     * @return 订单集合
     */
    List<Order> findOrdersByMarkId(String markId);

    /**
     * 根据用户ID查找所有MarkId
     *
     * @param userId 用户ID
     * @return 标识符ID合集
     */
    List<String> findAllMarkIdByUserId(String userId);

    /**
     * 根据用户ID和状态查找所有MarkId
     *
     * @param order 订单类
     * @return 标识符ID合集
     */
    List<String> findAllMarkIdByUserIdAndStatus(cn.jsnu.css.pojo.Order order);

    /**
     * 根据商品ID和用户ID查询订单信息
     *
     * @param data 数据
     * @return 订单合集
     */
    List<Order> findOrdersByGoodsIdAndUserId(Map<String,String> data);
}
