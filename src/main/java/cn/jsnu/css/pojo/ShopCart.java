package cn.jsnu.css.pojo;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/15 20:16
 */
public class ShopCart {
    private String userId;
    private String goodsId;
    private int quantity;

    public ShopCart(){};
    public ShopCart(String userId,String goodsId,int quantity){
        this.userId=userId;
        this.goodsId=goodsId;
        this.quantity=quantity;
    }
    @Override
    public String toString() {
        return "ShopCart{" +
                "userId='" + userId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
