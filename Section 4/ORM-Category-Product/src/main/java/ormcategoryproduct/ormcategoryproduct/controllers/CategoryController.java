package ormcategoryproduct.ormcategoryproduct.controllers;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ormcategoryproduct.ormcategoryproduct.dtos.CreateCategoryDTO;
import ormcategoryproduct.ormcategoryproduct.entities.Category;
import ormcategoryproduct.ormcategoryproduct.exceptions.category.CategoryNotFoundException;
import ormcategoryproduct.ormcategoryproduct.services.CategoryService;

import java.util.List;

@ApplicationScoped
@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {
    @Inject
    private CategoryService categoryService;

    @GET
    @Path("/all")
    public Response getAllCategories() {
        List allCategories = categoryService.getAllCategories();
        return Response.status(Response.Status.OK).entity(allCategories).build();
    }

    @GET
    @Path("/{category_id}")
    public Response getCategoryById(@PathParam("category_id") Integer category_id) throws CategoryNotFoundException {
        Category categoryById = categoryService.getCategoryById(category_id);
        return Response.status(Response.Status.OK).entity(categoryById).build();
    }

    @POST
    @Path("/new")
    public Response saveCategory(CreateCategoryDTO createCategoryDto) {
        categoryService.saveCategory(createCategoryDto);
        return Response.status(Response.Status.CREATED).entity("Created").build();
    }

    @PUT
    @Path("/{category_id}")
    public Response updateCategory(@PathParam("category_id") Integer category_id, CreateCategoryDTO createCategoryDto) {
        categoryService.updateCategory(createCategoryDto, category_id);
        return Response.status(Response.Status.CREATED).entity("Updated").build();
    }

    @DELETE
    @Path("/{category_id}")
    public Response deleteCategory(@PathParam("category_id") Integer category_id) {
        categoryService.deleteCategory(category_id);
        return Response.status(Response.Status.OK).entity("Deleted").build();
    }
}
