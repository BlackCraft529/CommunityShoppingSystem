package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.Category;
import cn.jsnu.css.pojo.Goods;
import cn.jsnu.css.service.CategoryService;
import cn.jsnu.css.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 李广帅
 * @date 2020/5/5 21:01
 */
@Controller
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    @Qualifier("GoodServiceImpl")
    private GoodService goodService;

    @Autowired
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;

    /**
     * 跳转至商品详情页
     * @param goodsId 商品ID
     * @param model 数据
     * @return 商品详情页名
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(String goodsId, Model model) {
        Goods goods = goodService.findGoodsById(goodsId);
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("goods", goods);
        return "goodsInfo";
    }


    /**
     * 商品分类展示
     * @param cateId 分类ID
     * @param model 数据
     * @return 商品列表页
     */
    @RequestMapping("/goodsListCate")
    public String goodsListByCate(String cateId, Model model) {
        List<Goods> goods = goodService.findGoodsByCategory(cateId);
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("goods", goods);
        return "goodsList";
    }


    /**
     * 根据商品名查找商品
     * @param goodsName 商品名
     * @return 商品列表页
     */
    @RequestMapping("/goodsListName")
    public String goodsListByName(String goodsName, Model model) {
        List<Goods> goods = goodService.findGoodsByName(goodsName);
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("goods", goods);
        return "goodsList";
    }
}
