package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.CategoryMapper;
import cn.jsnu.css.pojo.Category;
import cn.jsnu.css.service.CategoryService;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:58
 */
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    public void setCategoryMapper(CategoryMapper categoryMapper){this.categoryMapper=categoryMapper;}

    /**
     * 新增一个分类
     * @param cateName 商品名称
     * @param cateLevel 分类等级
     * @param superCate 上层分类ID
     */
    @Override
    public void addCategory(String cateName, int cateLevel, String superCate) {
        String randomId= RandomId.getRandomCategoryId();
        while(findCategoryById(randomId)!=null){
            randomId=RandomId.getRandomCategoryId();
        }
        categoryMapper.addCategory(new Category(randomId,cateName,cateLevel,superCate));
    }

    /**
     * 根据分类ID查找分类
     * @param categoryId 分类ID
     * @return 分类
     */
    @Override
    public Category findCategoryById(String categoryId) {
        return categoryMapper.findCategoryById(categoryId);
    }

    /**
     * 删除一个分类
     * @param categoryId 分类ID
     */
    @Override
    public void deleteCategoryById(String categoryId) {
        categoryMapper.deleteCategoryById(categoryId);
    }

    /**
     * 更新分类信息
     * @param category 分类
     */
    @Override
    public void updateCategoryById(Category category) {
        categoryMapper.updateCategoryById(category);
    }

    /**
     * 查找所有分类信息
     * @return 分类合集
     */
    @Override
    public List<Category> findAllCategories() {
        return categoryMapper.findAllCategories();
    }

    /**
     * 根据分类层级查找分类
     * @param cateLevel 等级
     * @return 分类集合
     */
    @Override
    public List<Category> findCategoryByLevel(int cateLevel) {
        return categoryMapper.findCategoryByLevel(cateLevel);
    }


}
