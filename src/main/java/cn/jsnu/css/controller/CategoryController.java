package cn.jsnu.css.controller;

import cn.jsnu.css.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author 李广帅
 * @date 2020/5/5 21:01
 */
public class CategoryController {
    @Autowired
    @Qualifier("CategoryServiceImpl")
    private CategoryService categoryService;
}
