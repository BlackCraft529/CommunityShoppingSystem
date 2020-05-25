package cn.jsnu.css.vo;

import cn.jsnu.css.pojo.Address;
import cn.jsnu.css.pojo.Goods;
import java.util.Date;
import java.util.List;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/23 18:27
 */
public class Order {
    private String orderId;
    private List<Goods> goodsList;
    private String userId;
    private double settlementAmount;
    private double paymentAmount;
    private Date createTime;
    private int status;
    private String markId;
    private Address address;

    public Order(){}

    public Order(cn.jsnu.css.pojo.Order order){
        this.setCreateTime(order.getCreateTime());
        this.setMarkId(order.getMarkId());
        this.setOrderId(order.getOrderId());
        this.setPaymentAmount(order.getPaymentAmount());
        this.setSettlementAmount(order.getSettlementAmount());
        this.setStatus(order.getStatus());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", goodsId=" + goodsList +
                ", userId='" + userId + '\'' +
                ", settlementAmount=" + settlementAmount +
                ", paymentAmount=" + paymentAmount +
                ", createTime=" + createTime +
                ", status=" + status +
                ", markId='" + markId + '\'' +
                ", address=" + address +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(double settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMarkId() {
        return markId;
    }

    public void setMarkId(String markId) {
        this.markId = markId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
