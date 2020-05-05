package cn.jsnu.css.controller;

import cn.jsnu.css.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author wrx-18090248
 * @date 2020/5/5 21:01
 */
public class GoodController {
    @Autowired
    @Qualifier("GoodServiceImpl")
    private GoodService goodService;
}
