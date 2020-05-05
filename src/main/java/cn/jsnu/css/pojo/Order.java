package cn.jsnu.css.pojo;

import java.util.Date;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:32
 */
public class Order {
    private String orderId;
    private String goodId;
    private String userId;
    private int quantity;
    private double settlementAmount;
    private double paymentAmount;
    private Date createTime;
    private int status;
    private String makeId;

    public Order() { }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", userId='" + userId + '\'' +
                ", quantity=" + quantity +
                ", settlementAmount=" + settlementAmount +
                ", paymentAmount=" + paymentAmount +
                ", createTime=" + createTime +
                ", status=" + status +
                ", makeId='" + makeId + '\'' +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
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

    public String getMakeId() {
        return makeId;
    }

    public void setMakeId(String makeId) {
        this.makeId = makeId;
    }
}
