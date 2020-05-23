package cn.jsnu.css.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author wrx-18090248
 * @date 2020/4/28 12:14
 */
public class RandomId {
    /**
     * 获取指定长度随机字符串
     * @param length 长度
     * @return 随机字符串
     */
    private static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append((char) result);
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append((char) result);
                    break;
                case 2:
                    sb.append(new Random().nextInt(10));
                    break;
                default: break;
            }
        }
        return sb.toString();
    }

    /**
     * 获取随机UUID
     * @return 转换为String返回
     */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取一个随机昵称
     * @param phoneNum 用户ID
     * @return 随机ID：手机号-随机字符5个
     */
    public static String getFirstNickName(String phoneNum){
        return phoneNum+"-"+getRandomString(5);
    }

    /**
     * 获取一个随机的商品ID
     * @return 随机商品ID
     */
    public static String getRandomGoodId(){
        return getRandomString(15);
    }

    /**
     * 获取一个随机分类ID
     * @return 随机分类ID
     */
    public static String getRandomCategoryId(){return getRandomString(8);}

    /**
     * 获取一个随机订单号
     * @return 订单号
     */
    public static String getRandomOrderId(){return getRandomString(12);}

    /**
     * 获取随机标识符ID-Order用
     * @return 标识符ID25位
     */
    public static String getRandomMarkId(){return  getRandomString(25);}

    /**
     * 获取一个随机地址ID
     * @return 随机地址ID
     */
    public static String getRandomAddressId(){return getRandomString(32);}
}
