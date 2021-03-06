package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.AddressMapper;
import cn.jsnu.css.dao.GoodMapper;
import cn.jsnu.css.dao.OrderMapper;
import cn.jsnu.css.dao.ShopCartMapper;
import cn.jsnu.css.length.Length;
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
     *
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
     *
     * @param orderId 订单ID
     */
    @Override
    public void deleteOrderById(String orderId) {
        orderMapper.deleteOrderById(orderId);
    }

    /**
     * 更新订单状态
     *
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
     *
     * @return 订单合集
     * @deprecated
     */
    @Override
    public List<cn.jsnu.css.pojo.Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }

    /**
     * 根据订单ID查询订单
     *
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
     *
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
     * 模糊查询订单 通过订单号、商品名、商品编号 查询订单信息
     *
     * @param vagueString 字符串
     * @param userId 用户ID
     * @return 订单信息
     */
    @Override
    public List<Order> findOrderByVagueString(String vagueString,String userId) {
        List<String> markIdList;
        //订单号
        if(vagueString.length()== Length.ORDER.getLength()){
            if(orderMapper.findOrderById(vagueString)!=null){
                cn.jsnu.css.pojo.Order order=orderMapper.findOrderById(vagueString);
                List<Order> returnOrders=new ArrayList<>();
                returnOrders.add(getOrderVo(order.getMarkId()));
                return returnOrders;
            }
        }
        //商品ID
        if(vagueString.length()==Length.GOODS.getLength()){
            Map<String,String> data=new HashMap<>(2);
            data.put("userId",userId);
            data.put("goodsId",vagueString);
            if(orderMapper.findOrdersByGoodsIdAndUserId(data)!=null){
                List<cn.jsnu.css.pojo.Order> orderList=orderMapper.findOrdersByGoodsIdAndUserId(data);
                markIdList=new ArrayList<>();
                //获取所有不重复的markId
                for(cn.jsnu.css.pojo.Order order:orderList){
                    if(!markIdList.contains(order.getMarkId())){
                        markIdList.add(order.getMarkId());
                    }
                }
                List<Order> orderVoList=new ArrayList<>();
                //通过MarkId获取订单vo类，返回
                for(String markId:markIdList){
                    orderVoList.add(getOrderVo(markId));
                }
                if(orderVoList.size()>0) {
                    return orderVoList;
                }
            }
        }
        //通过模糊商品名查询订单
        List<cn.jsnu.css.pojo.Order> orderList = orderMapper.findOrdersByUserId(userId);
        //获取所有不重复的markId
        markIdList=new ArrayList<>();
        for (cn.jsnu.css.pojo.Order order : orderList) {
            if (!markIdList.contains(order.getMarkId())) {
                markIdList.add(order.getMarkId());
            }
        }
        List<Order> orderVoList = new ArrayList<>();
        //通过MarkId获取订单vo类，返回
        for (String markId : markIdList) {
            orderVoList.add(getOrderVo(markId));
        }
        List<Order> returnOrders=new ArrayList<>();
        for(Order order:orderVoList){
            for(Goods goods:order.getGoodsList()){
                if(goods.getGoodsName().contains(vagueString)){
                    returnOrders.add(order);
                    break;
                }
            }
        }
        return returnOrders;
    }

    /**
     * 根据markId获取Vo Order对象
     *
     * @param markId 标识ID
     * @return Vo Order对象
     */
    private Order getOrderVo(String markId){
        List<cn.jsnu.css.pojo.Order> orders=orderMapper.findOrdersByMarkId(markId);
        Order orderVo=new Order();
        List<Goods> goodsList=new ArrayList<>();
        double settlementAmount=0;
        double paymentAmount=0;
        for(cn.jsnu.css.pojo.Order order:orders){
            orderVo=new Order(order);
            settlementAmount+=order.getSettlementAmount();
            paymentAmount+=order.getPaymentAmount();
            Goods goods=goodMapper.findGoodsById(order.getGoodsId());
            goods.setQuantity(orderMapper.findOrderById(order.getOrderId()).getQuantity());
            goodsList.add(goods);
            orderVo.setAddress(addressMapper.findAddressByAddressId(order.getAddressId()));
        }
        orderVo.setGoodsList(goodsList);
        orderVo.setSettlementAmount(settlementAmount);
        orderVo.setPaymentAmount(paymentAmount);
        return orderVo;
    }
}
