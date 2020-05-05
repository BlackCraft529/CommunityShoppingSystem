package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.CategoryMapper;
import cn.jsnu.css.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:58
 */
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public void setCategoryMapper(CategoryMapper categoryMapper){this.categoryMapper=categoryMapper;}

}
