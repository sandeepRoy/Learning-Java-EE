package ormcategoryproduct.ormcategoryproduct.controllers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ormcategoryproduct.ormcategoryproduct.dtos.CreateProductDTO;
import ormcategoryproduct.ormcategoryproduct.dtos.UpdateProductDTO;
import ormcategoryproduct.ormcategoryproduct.entities.Product;
import ormcategoryproduct.ormcategoryproduct.exceptions.product.ProductExistsException;
import ormcategoryproduct.ormcategoryproduct.exceptions.product.ProductNotFoundException;
import ormcategoryproduct.ormcategoryproduct.services.ProductService;

import java.util.List;

@ApplicationScoped
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
    @Inject
    private ProductService productService;

    @GET
    @Path("/all")
    public Response getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return Response.status(Response.Status.OK).entity(allProducts).build();
    }

    @GET
    @Path("/{product_id}")
    public Response getProductById(@PathParam("product_id") Integer product_id) throws ProductNotFoundException {
        Product productById = productService.getProductById(product_id);
        return Response.status(Response.Status.OK).entity(productById).build();
    }

    @POST
    @Path("/new")
    public Response saveProduct(CreateProductDTO createProductDTO) throws ProductExistsException {
        productService.saveProduct(createProductDTO);
        return Response.status(Response.Status.CREATED).entity("Created").build();
    }

    @PUT
    @Path("/{product_id}")
    public Response updateProduct(@PathParam("product_id") Integer product_id, UpdateProductDTO updateProductDTO) throws ProductNotFoundException {
        productService.updateProduct(updateProductDTO, product_id);
        return Response.status(Response.Status.OK).entity("Updated").build();
    }

    @DELETE
    @Path("/{product_id}")
    public Response deleteProduct(@PathParam("product_id") Integer product_id) throws ProductNotFoundException {
        productService.deleteProduct(product_id);
        return Response.status(Response.Status.OK).entity("Deleted").build();
    }
}
