package ormtask3.ormtask3.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TODO_UPDATES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoUpdates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_UPDATE_ID")
    private Integer todoUpdate_id;

    @ManyToOne
    @JoinColumn(name = "TODO_ID")
    @JsonbTransient
    private Todo todo;

    @Embedded
    private ItemUpdate itemUpdate;
}
