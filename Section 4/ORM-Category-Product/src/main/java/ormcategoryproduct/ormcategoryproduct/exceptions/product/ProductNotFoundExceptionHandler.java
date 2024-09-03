package ormcategoryproduct.ormcategoryproduct.exceptions.product;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import ormcategoryproduct.ormcategoryproduct.exceptions.ExceptionInformation;

@Provider
public class ProductNotFoundExceptionHandler implements ExceptionMapper<ProductNotFoundException> {

    @Override
    public Response toResponse(ProductNotFoundException productNotFoundException) {
        ExceptionInformation exceptionInformation = new ExceptionInformation();
        exceptionInformation.setException_message(productNotFoundException.getMessage());
        exceptionInformation.setException_code("PRODUCT-INVALID-GET");

        return Response.status(Response.Status.BAD_REQUEST).entity(exceptionInformation).build();
    }
}
