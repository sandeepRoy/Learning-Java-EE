package ormtask3.ormtask3.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TODO_WATCHERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoWatchers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_WATCHER_ID")
    private Integer todoWatcher_id;

    @ManyToOne
    @JoinColumn(name = "TODO_ID")
    @JsonbTransient
    private Todo todo;

    @Column(name = "LOGIN")
    private String login;
}