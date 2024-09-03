package ormcategoryproduct.ormcategoryproduct.exceptions.product;

public class ProductExistsException extends Exception {
    private String message;

    public ProductExistsException(String message) {
        super(message);
    }
}
