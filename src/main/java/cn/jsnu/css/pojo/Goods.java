package cn.jsnu.css.pojo;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:15
 */
public class Goods {
    private String goodId;
    private String goodName;
    private String goodSummary;
    private double goodPrice;
    private double goodSalesPrice;
    private int goodsCate;
    private int goodRemain;
    private String goodImage;

    public Goods(){}
    public Goods(String goodId, String goodName, String goodSummary, int goodsCate, double goodPrice, double goodSalesPrice, int goodRemain, String goodImage){
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodSummary = goodSummary;
        this.goodPrice = goodPrice;
        this.goodSalesPrice = goodSalesPrice;
        this.goodRemain = goodRemain;
        this.goodImage = goodImage;
        this.goodsCate=goodsCate;
    }
    @Override
    public String toString() {
        return "Good{" +
                "goodid='" + goodId + '\'' +
                ", goodName='" + goodName + '\'' +
                ", goodSummary='" + goodSummary + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodSalesPrice=" + goodSalesPrice +
                ", goodRemain=" + goodRemain +
                ", goodImage='" + goodImage + '\'' +
                '}';
    }

    public int getGoodsCate() {
        return goodsCate;
    }

    public void setGoodsCate(int goodsCate) {
        this.goodsCate = goodsCate;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodSummary() {
        return goodSummary;
    }

    public void setGoodSummary(String goodSummary) {
        this.goodSummary = goodSummary;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public double getGoodSalesPrice() {
        return goodSalesPrice;
    }

    public void setGoodSalesPrice(double goodSalesPrice) {
        this.goodSalesPrice = goodSalesPrice;
    }

    public int getGoodRemain() {
        return goodRemain;
    }

    public void setGoodRemain(int goodRemain) {
        this.goodRemain = goodRemain;
    }

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage;
    }
}
