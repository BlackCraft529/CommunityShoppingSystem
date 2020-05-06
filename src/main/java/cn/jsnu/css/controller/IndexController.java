package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.Category;
import cn.jsnu.css.service.CategoryService;
import cn.jsnu.css.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/5/6 9:37 上午
 */
@Controller
public class IndexController {

    @Autowired
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;


    @Autowired
    @Qualifier("GoodServiceImpl")
    private GoodService goodService;

    @RequestMapping("/index")
    public String index(HttpSession session) {
        return "index";
    }


}
