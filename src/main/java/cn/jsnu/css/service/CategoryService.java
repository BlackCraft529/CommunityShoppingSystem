package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Category;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:58
 */
public interface CategoryService {
    /**
     * 新增商品
     *
     * @param cateName 商品名称
     * @param cateLevel 分类等级
     * @param superCate 上层分类ID
     */
    void addCategory(String cateName,int cateLevel,String superCate);

    /**
     * 根据ID查找分类
     *
     * @param categoryId 分类ID
     * @return 分类
     */
    Category findCategoryById(String categoryId);

    /**
     * 删除一个分类
     *
     * @param categoryId 分类ID
     */
    void deleteCategoryById(String categoryId);

    /**
     * 更新分类信息
     *
     * @param category 分类
     */
    void updateCategoryById(Category category);

    /**
     * 查找所有分类信息
     *
     * @return 分类合集
     */
    List<Category> findAllCategories();

    /**
     * 根据分类层级查找分类
     *
     * @param cateLevel 等级
     * @return 分类集合
     */
    List<Category> findCategoryByLevel(int cateLevel);
}
