package todo.todo.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import todo.todo.dto.CreateTodoDto;
import todo.todo.dto.CompleteTodoDto;
import todo.todo.entity.Todo;
import todo.todo.service.TodoService;

import java.util.List;

@ApplicationScoped
@Path("/todo")
public class TodoController {
    @Inject
    TodoService todoService;

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTodo(CreateTodoDto createTodoDto) {
        String data = todoService.createTodo(createTodoDto);
        Response response = Response.status(Response.Status.CREATED).entity(data).build();
        return response;
    }

    @PUT
    @Path("/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response markTaskComplete(@PathParam("id") Long id, CompleteTodoDto completeTodoDto) {
        String data = todoService.updateTodo_complete(id, completeTodoDto);
        Response response = Response.status(Response.Status.CREATED).entity(data).build();
        return response;
    }

    @GET
    @Path("/due")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllDueTodos() {
        List<Todo> allDueTodos = todoService.getAllDueTodos();
        Response response = Response.status(Response.Status.OK).entity(allDueTodos).build();
        return response;
    }

    @GET
    @Path("/completed")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllCompletedTodos() {
        List<Todo> allDueTodos = todoService.getAllCompletedTodos();
        Response response = Response.status(Response.Status.OK).entity(allDueTodos).build();
        return response;
    }
}
