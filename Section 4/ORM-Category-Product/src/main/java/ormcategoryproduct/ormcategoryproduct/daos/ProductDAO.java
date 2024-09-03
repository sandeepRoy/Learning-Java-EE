package ormcategoryproduct.ormcategoryproduct.daos;

import ormcategoryproduct.ormcategoryproduct.dtos.CreateProductDTO;
import ormcategoryproduct.ormcategoryproduct.dtos.UpdateProductDTO;
import ormcategoryproduct.ormcategoryproduct.exceptions.product.ProductExistsException;
import ormcategoryproduct.ormcategoryproduct.exceptions.product.ProductNotFoundException;

import java.util.List;

public interface ProductDAO<Product> {
    List<Product> getAllProducts();
    Product getProductById(Integer product_id) throws ProductNotFoundException;
    void saveProduct(CreateProductDTO createProductDTO) throws ProductExistsException;
    void updateProduct(UpdateProductDTO updateProductDTO, Integer product_id) throws ProductNotFoundException;
    void deleteProduct(Integer product_id) throws ProductNotFoundException;
}
