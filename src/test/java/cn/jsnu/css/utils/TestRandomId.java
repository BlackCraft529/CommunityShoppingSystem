package cn.jsnu.css.utils;

import org.junit.Test;

/**
 * @author 李广帅
 * @date 2020/5/27 12:37 上午
 */
public class TestRandomId {

    @Test
    public void testGetUUID() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomId.getUUID().toString().replaceAll("-", ""));
        }
    }
}
