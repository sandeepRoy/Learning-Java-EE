package ormcategoryproduct.ormcategoryproduct.exceptions.category;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import ormcategoryproduct.ormcategoryproduct.exceptions.ExceptionInformation;

@Provider
public class CategoryNotFoundExceptionHandler implements ExceptionMapper<CategoryNotFoundException> {
    @Override
    public Response toResponse(CategoryNotFoundException categoryNotFoundException) {

        ExceptionInformation exceptionInformation = new ExceptionInformation();
        exceptionInformation.setException_message(categoryNotFoundException.getMessage());
        exceptionInformation.setException_code("INV-DE");

        return Response.status(Response.Status.BAD_REQUEST).entity(exceptionInformation).build();
    }
}
