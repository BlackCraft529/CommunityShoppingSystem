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
    public static String getRandomString(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                case 0:
                    result = Math.round(Math.random() * 25 + 65);
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
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
}
