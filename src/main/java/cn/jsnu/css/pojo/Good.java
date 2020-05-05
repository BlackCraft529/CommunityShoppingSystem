package cn.jsnu.css.pojo;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:15
 */
public class Good {
    private String goodId;
    private String goodName;
    private String goodSummary;
    private double goodPrice;
    private double goodSalesPrice;
    private int goodRemain;
    private String goodImage;

    public Good(){}
    public Good(String goodId,String goodName,String goodSummary,double goodPrice,double goodSalesPrice,int goodRemain,String goodImage){
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodSummary = goodSummary;
        this.goodPrice = goodPrice;
        this.goodSalesPrice = goodSalesPrice;
        this.goodRemain = goodRemain;
        this.goodImage = goodImage;
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
