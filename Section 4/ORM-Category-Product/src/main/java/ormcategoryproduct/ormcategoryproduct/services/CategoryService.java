package ormcategoryproduct.ormcategoryproduct.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ormcategoryproduct.ormcategoryproduct.daos.CategoryDAO;
import ormcategoryproduct.ormcategoryproduct.dtos.CreateCategoryDTO;
import ormcategoryproduct.ormcategoryproduct.entities.Category;
import ormcategoryproduct.ormcategoryproduct.exceptions.category.CategoryNotFoundException;

import java.util.List;

@ApplicationScoped
@Transactional
public class CategoryService implements CategoryDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = entityManager
                // "select distinct c from Category c left join fetch c.productList order by c.category_name"
                .createQuery("select category from Category category order by category.category_name", Category.class)
                .getResultList();
        return categories;
    }

    @Override
    public Category getCategoryById(Integer category_id) throws CategoryNotFoundException {
        Category category = entityManager.find(Category.class, category_id);
        if(category == null) {
            throw new CategoryNotFoundException("Category Not Found");
        }
        return category;
    }

    @Override
    public void saveCategory(CreateCategoryDTO createCategoryDto) {
        List<Category> categories = entityManager
                .createQuery(
                        "select category from Category category order by category.category_name", Category.class)
                .getResultList();

        categories.stream()
                .filter(category -> category.getCategory_name().equals(createCategoryDto.getCategory_name()))
                .findAny()
                .ifPresent(category -> {
                    throw new RuntimeException("Duplicate Category Exists : " + category.getCategory_id());
                });

        Category category = new Category();
        category.setCategory_name(createCategoryDto.getCategory_name());

        entityManager.persist(category);
    }

    @Override
    public void updateCategory(CreateCategoryDTO createCategoryDto, Integer category_id) {
        Category category = entityManager.find(Category.class, category_id);
        if(category.equals(null)) {
            throw new RuntimeException("Category Not Found!");
        }


        category.setCategory_name(createCategoryDto.getCategory_name());
        entityManager.persist(category);
    }

    @Override
    public void deleteCategory(Integer category_id) {
        Category category = entityManager.find(Category.class, category_id);
        if(category.equals(null)) {
            throw new RuntimeException("Category Not Found!");
        }
        entityManager.remove(category);
    }
}
