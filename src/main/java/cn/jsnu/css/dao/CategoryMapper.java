package cn.jsnu.css.dao;

import cn.jsnu.css.pojo.Category;
import java.util.List;

/**
 * @author wrx-18090248
 * @date 2020/5/5 20:57
 */
public interface CategoryMapper {
    /**
     * 新增商品
     * @param category 分类
     */
    void addCategory(Category category);

    /**
     * 根据ID查找分类
     * @param categoryId 分类ID
     * @return 分类
     */
    Category findCategoryById(String categoryId);

    /**
     * 删除一个分类
     * @param categoryId 分类ID
     */
    void deleteCategoryById(String categoryId);

    /**
     * 更新分类信息
     * @param category 分类
     */
    void updateCategoryById(Category category);

    /**
     * 查找所有分类信息
     * @return 分类合集
     */
    List<Category> findAllCategories();

    /**
     * 根据分类名查找分类
     * @param name 分类名
     * @return 分类
     */
    Category findCategoryByName(String name);

    /**
     * 根据分类层级查找分类
     * @param cateLevel 等级
     * @return 分类集合
     */
    List<Category> findCategoryByLevel(int cateLevel);
}
