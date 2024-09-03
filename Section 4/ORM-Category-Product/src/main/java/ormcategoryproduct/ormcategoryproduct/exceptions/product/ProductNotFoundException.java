package ormcategoryproduct.ormcategoryproduct.exceptions.product;

public class ProductNotFoundException extends Exception {
    private String message;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
