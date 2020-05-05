package cn.jsnu.css.pojo;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:36
 */
public class Category {
    private String cateId;
    private String cateName;
    private int cateLevel;
    private String superCate;

    public Category(){}

    @Override
    public String toString() {
        return "Category{" +
                "cateId='" + cateId + '\'' +
                ", cateName='" + cateName + '\'' +
                ", cateLevel=" + cateLevel +
                ", superCate='" + superCate + '\'' +
                '}';
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getCateLevel() {
        return cateLevel;
    }

    public void setCateLevel(int cateLevel) {
        this.cateLevel = cateLevel;
    }

    public String getSuperCate() {
        return superCate;
    }

    public void setSuperCate(String superCate) {
        this.superCate = superCate;
    }
}
