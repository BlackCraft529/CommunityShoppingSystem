package cn.jsnu.css.controller;

import cn.jsnu.css.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李广帅
 * @date 2020/5/5 21:01
 */
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    @Qualifier("GoodServiceImpl")
    private GoodService goodService;
    /**
     * 跳转至商品详情页
     * @param id 商品ID
     * @return 商品详情页名
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(String id) {
        return "goodsInfo";
    }
}
