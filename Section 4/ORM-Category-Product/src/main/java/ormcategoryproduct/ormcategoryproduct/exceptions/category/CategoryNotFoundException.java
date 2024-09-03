package ormcategoryproduct.ormcategoryproduct.exceptions.category;

public class CategoryNotFoundException extends Exception {
    private String message;

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
