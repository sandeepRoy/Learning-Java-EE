package ormtask3.ormtask3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TODOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Integer todo_id;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "DETAILS")
    private String details;

    @OneToMany(
            mappedBy = "TODOS",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<TodoWatchers> todoWatchersList;

    @OneToMany(
            mappedBy = "TODOS",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<TodoComments> todoCommentsList;

    @OneToMany(
            mappedBy = "TODOS",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<TodoUpdates> todoUpdatesList;

    @OneToMany(
            mappedBy = "TODOS",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<TodoTags> todoTagsList;
}
