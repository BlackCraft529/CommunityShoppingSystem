package cn.jsnu.css.pojo;

import java.util.Date;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:15
 */
public class Goods {
    private String goodsId;
    private String goodsName;
    private String goodsSummary;
    private double goodsPrice;
    private double goodsSalesPrice;
    private String goodsCate;
    private int goodsSales;
    private Date goodsCreateTime;
    private int goodsRemain;
    private String goodsImage;
    private int quantity;

    public Goods(){}
    public Goods(String goodsId, String goodsName, String goodsSummary, String goodsCate, double goodsPrice, double goodsSalesPrice, int goodsRemain, String goodsImage,int goodsSales,Date goodsCreateTime){
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsSummary = goodsSummary;
        this.goodsPrice = goodsPrice;
        this.goodsSalesPrice = goodsSalesPrice;
        this.goodsRemain = goodsRemain;
        this.goodsImage = goodsImage;
        this.goodsCate=goodsCate;
        this.goodsSales=goodsSales;
        this.goodsCreateTime=goodsCreateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(int goodsSales) {
        this.goodsSales = goodsSales;
    }

    public Date getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(Date goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSummary='" + goodsSummary + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsSalesPrice=" + goodsSalesPrice +
                ", goodsCate='" + goodsCate + '\'' +
                ", goodsSales=" + goodsSales +
                ", goodsCreateTime=" + goodsCreateTime +
                ", goodsRemain=" + goodsRemain +
                ", goodsImage='" + goodsImage + '\'' +
                '}';
    }

    public String getGoodsCate() {
        return goodsCate;
    }

    public void setGoodsCate(String goodsCate) {
        this.goodsCate = goodsCate;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSummary() {
        return goodsSummary;
    }

    public void setGoodsSummary(String goodsSummary) {
        this.goodsSummary = goodsSummary;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getGoodsSalesPrice() {
        return goodsSalesPrice;
    }

    public void setGoodsSalesPrice(double goodsSalesPrice) {
        this.goodsSalesPrice = goodsSalesPrice;
    }

    public int getGoodsRemain() {
        return goodsRemain;
    }

    public void setGoodsRemain(int goodsRemain) {
        this.goodsRemain = goodsRemain;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }
}
