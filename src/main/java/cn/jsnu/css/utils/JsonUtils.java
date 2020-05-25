package cn.jsnu.css.utils;


import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/23 13:08
 */
public class JsonUtils {
    /**
     * Json数据转换为Map
     * @param jsonData json数据
     * @return map数据集
     */
    private static Map<String,String> parseJSONWithJSONObject(String jsonData) {
        JSONObject json = JSONObject.parseObject(jsonData);
        String goodsInfoJson=json.getString("goodsInfo");
        JSONObject goodsJson=JSONObject.parseObject(goodsInfoJson);
        Map<String,String> data=new HashMap<>();
        for(String key:goodsJson.keySet()){
            data.put(key,goodsJson.getString(key));
        }
        data.put("addressId",json.getString("addressId"));
        return data;
    }

    /**
     * 通过JSON获取地址ID
     * @param json json字符串
     * @return 地址ID
     */
    public static String getAddressIdFromJson(String json){
        return parseJSONWithJSONObject(json).get("addressId");
    }

    /**
     * 通过json字符解析获取商品及其数量
     * @param json json字符串
     * @return 商品信息
     */
    public static Map<String ,Integer> getGoodsInfoFromJson(String json){
        Map<String ,Integer> goodsInfo=new HashMap<>();
        Map<String,String> jsonData=parseJSONWithJSONObject(json);
        for(String key: jsonData.keySet()){
            if(!"addressId".equalsIgnoreCase(key)){
                goodsInfo.put(key,Integer.parseInt(jsonData.get(key)));
            }
        }
        return goodsInfo;
    }
}
