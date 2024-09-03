package todo.todo.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Must not be empty!")
    @Size(min = 10, message = "Task should be atleast of 10 characters!")
    private String task;

    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate createdDate;

    @NotNull(message = "Due Date Required")
    @FutureOrPresent(message = "Due Date Must be Future or Present")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dueDate;

    private Boolean isCompleted;

    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate completedDate;

    @PrePersist
    public void init() {
        setCreatedDate(LocalDate.now());
    }
}
