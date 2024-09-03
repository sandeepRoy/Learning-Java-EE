package ormtask3.ormtask3.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Entity
@Table(name = "TODO_TAGS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_TAG_ID")
    private Integer todoTag_id;

    @ManyToOne
    @JoinColumn(name = "TODO_ID")
    @JsonbTransient
    private Todo todo;

    @ElementCollection
    @CollectionTable(
            name = "todoTag_attributes",
            joinColumns = @JoinColumn(name = "todo_tag_id")
    )
    @MapKeyColumn(name = "NAME")
    @Column(name = "DESCRIPTION")
    private HashMap<String, String> tagMap = new HashMap<>();
}
