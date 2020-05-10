package cn.jsnu.css.pojo;

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
    private int goodsCate;
    private int goodsRemain;
    private String goodsImage;

    public Goods(){}
    public Goods(String goodsId, String goodsName, String goodsSummary, int goodsCate, double goodsPrice, double goodsSalesPrice, int goodsRemain, String goodsImage){
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsSummary = goodsSummary;
        this.goodsPrice = goodsPrice;
        this.goodsSalesPrice = goodsSalesPrice;
        this.goodsRemain = goodsRemain;
        this.goodsImage = goodsImage;
        this.goodsCate=goodsCate;
    }
    @Override
    public String toString() {
        return "Good{" +
                "goodid='" + goodsId + '\'' +
                ", goodName='" + goodsName + '\'' +
                ", goodSummary='" + goodsSummary + '\'' +
                ", goodPrice=" + goodsPrice +
                ", goodSalesPrice=" + goodsSalesPrice +
                ", goodRemain=" + goodsRemain +
                ", goodImage='" + goodsImage + '\'' +
                '}';
    }

    public int getGoodsCate() {
        return goodsCate;
    }

    public void setGoodsCate(int goodsCate) {
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
