package cn.jsnu.css.length;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/27 22:23
 */
public enum Length {
    //订单Id长度
    ORDER(12),
    //分类ID长度
    CATEGORY(8),
    //商品ID长度
    GOODS(15),
    //标识符ID长度 -Order.MarkId
    MARK(25),
    //地址ID长度
    ADDRESS(32);

    int length;
    Length(int length){this.length=length; }

    public int getLength() {
        return length;
    }
}
