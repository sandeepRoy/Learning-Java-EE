package ormtask302.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private Integer PROJECT_ID;

    @Column(name = "NAME")
    private String NAME;

    @ElementCollection
    @CollectionTable(name = "PROJECT_EVENT_UPDATES", joinColumns = @JoinColumn(name = "PROJECT_ID"))
    @AttributeOverride(name = "user", column = @Column(name = "USER_NAME"))
    @AttributeOverride(name = "date", column = @Column(name = "EVENT_DATE"))
    private List<ItemUpdate> projectItemUpdateList = new ArrayList<>();

    public void update(ItemUpdate itemUpdate) {
        this.projectItemUpdateList.add(itemUpdate);
    }
}
