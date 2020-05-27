package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.AddressMapper;
import cn.jsnu.css.dao.GoodMapper;
import cn.jsnu.css.dao.OrderMapper;
import cn.jsnu.css.dao.ShopCartMapper;
import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.vo.Order;
import cn.jsnu.css.service.OrderService;
import cn.jsnu.css.utils.JsonUtils;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:55
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShopCartMapper shopCartMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 新建一个订单
     * @param orderInfo 订单Json字符串
     * @param userId 用户ID
     */
    @Override
    public void addOrder(String orderInfo,String userId) {
        String markId=RandomId.getRandomMarkId();
        while(orderMapper.findOrdersByMarkId(markId).size()>0){
            markId=RandomId.getRandomMarkId();
        }
        String orderId= RandomId.getRandomOrderId();
        Map<String,Integer> goodsInfo=JsonUtils.getGoodsInfoFromJson(orderInfo);
        for(String key: goodsInfo.keySet()){
            while(findOrderById(orderId)!=null){
                orderId= RandomId.getRandomOrderId();
            }
            int goodsCount=goodsInfo.get(key);
            Goods goods=goodMapper.findGoodsById(key);
            double settlementAmount=goods.getGoodsPrice()*goodsCount;
            double paymentAmount=goods.getGoodsSalesPrice()*goodsCount;
            cn.jsnu.css.pojo.Order order= new cn.jsnu.css.pojo.Order();
            order.setOrderId(orderId);
            order.setGoodsId(key);
            order.setUserId(userId);
            order.setQuantity(goodsCount);
            order.setSettlementAmount(settlementAmount);
            order.setPaymentAmount(paymentAmount);
            order.setCreateTime(new Date());
            order.setStatus(1);
            order.setMarkId(markId);
            order.setAddressId(JsonUtils.getAddressIdFromJson(orderInfo));
            orderMapper.addOrder(order);
            Map<String ,String> shopCartData=new HashMap<>(2);
            shopCartData.put("userId",userId);
            shopCartData.put("goodsId",key);
            shopCartMapper.deleteByUserIdAndGoodsId(shopCartData);
        }
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
     * 更新订单状态
     * @param orderId 订单ID
     * @param status  订单状态
     */
    @Override
    public void updateOrderStatus(String orderId, int status) {
        String markId=orderMapper.findOrderById(orderId).getMarkId();
        List<cn.jsnu.css.pojo.Order> orderList=orderMapper.findOrdersByMarkId(markId);
        for(cn.jsnu.css.pojo.Order order:orderList) {
            order.setStatus(status);
            orderMapper.updateOrderStatus(order);
        }

    }

    /**
     * 查找所有订单
     * @return 订单合集
     * @deprecated
     */
    @Override
    public List<cn.jsnu.css.pojo.Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    /**
     * 根据订单ID查询订单
     * @param orderId 订单ID
     * @return 订单
     */
    @Override
    public Order findOrderById(String orderId) {
        if(orderMapper.findOrderById(orderId)==null){
            return null;
        }
        cn.jsnu.css.pojo.Order order = orderMapper.findOrderById(orderId);
        Order orderVo=new Order(order);
        List<Goods> goods=shopCartMapper.findShopCartByUserId(order.getUserId());
        orderVo.setGoodsList(goods);
        orderVo.setAddress(addressMapper.findAddressByAddressId(order.getAddressId()));
        return orderVo;
    }

    /**
     * 根据用户ID查找订单信息
     * @param userId 客户ID
     * @return 订单合集
     */
    @Override
    public List<Order> findOrdersByUserId(String userId) {
        List<Order> orderVoList=new ArrayList<>();
        List<String> markIdList=orderMapper.findAllMarkIdByUserId(userId);
        for(String markId:markIdList){
            orderVoList.add(getOrderVo(markId));
        }
        return orderVoList;
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
        List<Order> orderVoList=new ArrayList<>();
        cn.jsnu.css.pojo.Order orderPojo=new cn.jsnu.css.pojo.Order();
        orderPojo.setUserId(userId);orderPojo.setStatus(status);
        List<String> markIdList=orderMapper.findAllMarkIdByUserIdAndStatus(orderPojo);
        for(String markId:markIdList){
            orderVoList.add(getOrderVo(markId));
        }
        return orderVoList;
    }

    /**
     * 根据markId获取Vo Order对象
     * @param markId 标识ID
     * @return Vo Order对象
     */
    private Order getOrderVo(String markId){
        List<cn.jsnu.css.pojo.Order> orders=orderMapper.findOrdersByMarkId(markId);
        Order orderVo=new Order();
        List<Goods> goodsList=new ArrayList<>();
        for(cn.jsnu.css.pojo.Order order:orders){
            orderVo=new Order(order);
            Goods goods=goodMapper.findGoodsById(order.getGoodsId());
            goods.setQuantity(orderMapper.findOrderById(order.getOrderId()).getQuantity());
            goodsList.add(goods);
            orderVo.setAddress(addressMapper.findAddressByAddressId(order.getAddressId()));
        }
        orderVo.setGoodsList(goodsList);
        return orderVo;
    }
}
