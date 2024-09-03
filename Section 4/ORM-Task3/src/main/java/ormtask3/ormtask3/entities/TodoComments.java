package ormtask3.ormtask3.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TODO_COMMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_COMMENT_ID")
    private Integer todoComment_id;

    @ManyToOne
    @JoinColumn(name = "TODO_ID")
    @JsonbTransient
    private Todo todo;

    @Embedded
    private Comment comment;
}
