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
    public void setOrderMapper(OrderMapper orderMapper){this.orderMapper=orderMapper;}

    @Autowired
    private ShopCartMapper shopCartMapper;
    public void setShopCartMapper(ShopCartMapper shopCartMapper){this.shopCartMapper=shopCartMapper;}

    @Autowired
    private GoodMapper goodMapper;
    public void setGoodMapper(GoodMapper goodMapper){this.goodMapper=goodMapper;}

    @Autowired
    private AddressMapper addressMapper;
    public void setAddressMapper(AddressMapper addressMapper){this.addressMapper=addressMapper;}
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
            cn.jsnu.css.pojo.Order order= new cn.jsnu.css.pojo.Order();
            order.setOrderId(orderId);
            order.setGoodsId(key);
            order.setUserId(userId);
            order.setQuantity(goodsInfo.get(key));
            order.setSettlementAmount(0D);
            order.setPaymentAmount(0D);
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
            List<cn.jsnu.css.pojo.Order> orders=orderMapper.findOrdersByMarkId(markId);
            for(cn.jsnu.css.pojo.Order order:orders){
                Order orderVo=new Order(order);
                List<Goods> goodsList=new ArrayList<>();
                goodsList.add(goodMapper.findGoodsById(order.getGoodsId()));
                orderVo.setGoodsList(goodsList);
                orderVo.setAddress(addressMapper.findAddressByAddressId(order.getAddressId()));
                orderVoList.add(orderVo);
            }
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
            List<cn.jsnu.css.pojo.Order> orders=orderMapper.findOrdersByMarkId(markId);
            for(cn.jsnu.css.pojo.Order order:orders){
                Order orderVo=new Order(order);
                List<Goods> goodsList=new ArrayList<>();
                goodsList.add(goodMapper.findGoodsById(order.getGoodsId()));
                orderVo.setGoodsList(goodsList);
                orderVo.setAddress(addressMapper.findAddressByAddressId(order.getAddressId()));
                orderVoList.add(orderVo);
            }
        }
        return orderVoList;
    }

}
