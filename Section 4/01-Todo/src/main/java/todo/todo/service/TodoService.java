package todo.todo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import todo.todo.dto.CreateTodoDto;
import todo.todo.dto.CompleteTodoDto;
import todo.todo.entity.Todo;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
@Transactional
public class TodoService {
    @PersistenceContext
    EntityManager entityManager;

    public String createTodo(CreateTodoDto createTodoDto) {
        Todo todo = new Todo();
        todo.setTask(createTodoDto.getTask());
        todo.setDueDate(createTodoDto.getDueDate());
        todo.setIsCompleted(false);

        entityManager.persist(todo);
        return "Check DB";
    }

    public String updateTodo_complete(Long id, CompleteTodoDto completeTodoDto) {
        Todo todo = entityManager.find(Todo.class, id);
        todo.setIsCompleted(completeTodoDto.getIsCompleted());
        todo.setCompletedDate(LocalDate.now());


        entityManager.merge(todo);
        return "Check DB";
    }

    public List<Todo> getAllDueTodos() {
        List<Todo> resultList = entityManager
                .createQuery(
                "select todo from Todo todo where todo.isCompleted = false and todo.dueDate >= :today", Todo.class
                )
                .setParameter("today", LocalDate.now())
                .getResultList();
        return resultList;
    }

    public List<Todo> getAllCompletedTodos() {
        List<Todo> resultList = entityManager
                .createQuery(
                        "select todo from Todo todo where todo.isCompleted = true", Todo.class
                )
                .getResultList();
        return resultList;
    }
}
