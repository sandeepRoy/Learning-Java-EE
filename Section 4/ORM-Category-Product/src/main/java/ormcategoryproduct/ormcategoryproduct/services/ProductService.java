package ormcategoryproduct.ormcategoryproduct.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ormcategoryproduct.ormcategoryproduct.daos.ProductDAO;
import ormcategoryproduct.ormcategoryproduct.dtos.CreateProductDTO;
import ormcategoryproduct.ormcategoryproduct.dtos.UpdateProductDTO;
import ormcategoryproduct.ormcategoryproduct.entities.Category;
import ormcategoryproduct.ormcategoryproduct.entities.Product;
import ormcategoryproduct.ormcategoryproduct.exceptions.product.ProductExistsException;
import ormcategoryproduct.ormcategoryproduct.exceptions.product.ProductNotFoundException;

import java.util.List;

@ApplicationScoped
@Transactional
public class ProductService implements ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> getAllProducts() {
        return entityManager
                .createQuery("select product from Product product order by product.product_name", Product.class)
                .getResultList();
    }

    @Override
    public Product getProductById(Integer product_id) throws ProductNotFoundException{
        Product product = entityManager.find(Product.class, product_id);
        if(product == null) {
            throw new ProductNotFoundException("Product Not Found!");
        }
        return product;
    }

    @Override
    public void saveProduct(CreateProductDTO createProductDTO) throws ProductExistsException {
        entityManager
                .createQuery("select product from Product product order by product.product_name", Product.class)
                .getResultList()
                .stream()
                .filter(product -> product.getProduct_manufacturer().equals(createProductDTO.getProduct_name()))
                .findAny()
                .ifPresent(product -> {
                    try {
                        throw new ProductExistsException("Product already listed by manufacturer");
                    } catch (ProductExistsException e) {
                        throw new RuntimeException(e);
                    }
                });

        Category category = entityManager.find(Category.class, createProductDTO.getCategory_id());

        Product product = new Product();
        product.setProduct_name(createProductDTO.getProduct_name());
        product.setProduct_price(createProductDTO.getProduct_price());
        product.setProduct_manufacturer(createProductDTO.getProduct_manufacturer());
        product.setProduct_inStock(createProductDTO.getProduct_inStock());
        product.setCategory(category);

        entityManager.persist(product);
    }

    @Override
    public void updateProduct(UpdateProductDTO updateProductDTO, Integer product_id) throws ProductNotFoundException {
        Product product = entityManager.find(Product.class, product_id);
        if(product == null) {
            throw new ProductNotFoundException("Product Not Found");
        }

        product.setProduct_name(updateProductDTO.getProduct_name());
        product.setProduct_price(updateProductDTO.getProduct_price());
        product.setProduct_manufacturer(updateProductDTO.getProduct_manufacturer());
        product.setProduct_inStock(updateProductDTO.getProduct_inStock());

        entityManager.merge(product);
    }

    @Override
    public void deleteProduct(Integer product_id) throws ProductNotFoundException {
        Product product = entityManager.find(Product.class, product_id);
        if(product == null) {
            throw new ProductNotFoundException("Product Not Found");
        }
        entityManager.remove(product);
    }
}
