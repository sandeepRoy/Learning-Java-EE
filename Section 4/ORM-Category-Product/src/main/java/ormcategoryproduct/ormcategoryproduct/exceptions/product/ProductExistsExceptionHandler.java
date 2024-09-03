package ormcategoryproduct.ormcategoryproduct.exceptions.product;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import ormcategoryproduct.ormcategoryproduct.exceptions.ExceptionInformation;

@Provider
public class ProductExistsExceptionHandler implements ExceptionMapper<ProductExistsException> {

    @Override
    public Response toResponse(ProductExistsException productExistsException) {
        ExceptionInformation exceptionInformation = new ExceptionInformation();
        exceptionInformation.setException_message(productExistsException.getMessage());
        exceptionInformation.setException_code("PRODUCT-DUPLICATE-POST");

        return Response.status(Response.Status.FORBIDDEN).entity(exceptionInformation).build();
    }
}
