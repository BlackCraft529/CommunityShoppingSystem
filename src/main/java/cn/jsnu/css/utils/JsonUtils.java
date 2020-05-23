package cn.jsnu.css.utils;


import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/23 13:08
 */
public class JsonUtils {
    public static void parseJSONWithJSONObject(String jsonData) {
        JSONObject json = JSONObject.parseObject(jsonData);
        String goodsInfoJson=json.getString("goodsInfo");
        JSONObject goodsJson=JSONObject.parseObject(goodsInfoJson);
        Map<String,Integer> data=new HashMap<>();
        for(String key:goodsJson.keySet()){
            data.put(key,Integer.parseInt(goodsJson.getString(key)));
        }
        String addressId=json.getString("addressId");
    }
}
