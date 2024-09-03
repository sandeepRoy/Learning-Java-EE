package ormcategoryproduct.ormcategoryproduct.daos;

import ormcategoryproduct.ormcategoryproduct.dtos.CreateCategoryDTO;
import ormcategoryproduct.ormcategoryproduct.exceptions.category.CategoryNotFoundException;

import java.util.List;

public interface CategoryDAO<Category> {
    List<Category> getAllCategories();
    Category getCategoryById(Integer category_id) throws CategoryNotFoundException;
    void saveCategory(CreateCategoryDTO createCategoryDTO);
    void updateCategory(CreateCategoryDTO createCategoryDto, Integer category_id);
    void deleteCategory(Integer category_id);
}
