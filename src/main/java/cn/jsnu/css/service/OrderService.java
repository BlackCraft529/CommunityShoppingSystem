package cn.jsnu.css.service;

import cn.jsnu.css.vo.Order;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:54
 */
public interface OrderService {
    /**
     * 新建一个订单
     *
     * @param orderJson 订单Json字符串
     * @param userId 用户ID
     */
    void addOrder(String orderJson ,String userId);

    /**
     * 根据订单ID删除订单信息
     *
     * @param orderId 订单ID
     */
    void deleteOrderById(String orderId);

    /**
     * 更新订单状态
     *
     * @param orderId 订单ID
     * @param status 订单状态
     */
    void updateOrderStatus(String orderId,int status);

    /**
     * 查找所有订单
     *
     * @return 订单合集
     * @deprecated
     */
    List<cn.jsnu.css.pojo.Order> findAllOrder();

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
     * 根据用户ID和订单状态查询订单
     *
     * @param userId 用户ID
     * @param status 订单状态
     * @return 订单合集
     */
    List<Order> findOrdersByUserIdAndStatus(String userId,int status);

    /**
     * 模糊查询订单 通过订单号、商品名、商品编号 查询订单信息
     *
     * @param vagueString 字符串 -订单号、商品名(模糊)、商品编号
     * @param userId 用户ID
     * @return 订单信息合集
     */
    List<Order> findOrderByVagueString(String vagueString,String userId);
}
