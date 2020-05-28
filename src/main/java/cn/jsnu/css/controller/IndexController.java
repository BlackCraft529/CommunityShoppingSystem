package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.Category;
import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.service.CategoryService;
import cn.jsnu.css.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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

    /**
     * 首页
     *
     * @param session session对象
     * @return 首页
     */
    @RequestMapping("/index")
    public String index(HttpSession session, Model model) {
        List<Category> categories = categoryService.findAllCategories();
        List<Goods> newsList = goodService.findNewestGoods(8);
        List<Goods> hotsList = goodService.findHotGoods(8);
        model.addAttribute("hotsList", hotsList);
        model.addAttribute("newsList", newsList);
        model.addAttribute("categories", categories);
        return "index";
    }

    /**
     * 跳转至首页
     *
     * @return 首页
     */
    @RequestMapping("/")
    public String toIndex() {
        return "redirect:/index";
    }
}
