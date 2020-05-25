package cn.jsnu.css.pojo;

import java.util.Date;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:32
 */
public class Order {
    private String orderId;
    private String goodsId;
    private String userId;
    private int quantity;
    private double settlementAmount;
    private double paymentAmount;
    private Date createTime;
    private int status;
    private String markId;
    private String addressId;

    public Order() { }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", userId='" + userId + '\'' +
                ", quantity=" + quantity +
                ", settlementAmount=" + settlementAmount +
                ", paymentAmount=" + paymentAmount +
                ", createTime=" + createTime +
                ", status=" + status +
                ", markId='" + markId + '\'' +
                ", addressId=" + addressId +
                '}';
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
