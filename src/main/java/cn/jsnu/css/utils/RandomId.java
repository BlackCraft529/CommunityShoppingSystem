package cn.jsnu.css.utils;

import java.util.Random;

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

}