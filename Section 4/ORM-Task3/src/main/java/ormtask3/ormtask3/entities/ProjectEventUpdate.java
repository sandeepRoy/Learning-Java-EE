package ormtask3.ormtask3.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PROJECT_EVENT_UPDATES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEventUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_EVENTUPDATE_ID")
    private Integer projectEventUpdate_id;

    @ManyToOne
    private Project project;

    @Embedded
    private ItemUpdate itemUpdate;
}

/*
*
ElementCollection
CollectionTable
JoinColumn
private List<ItemUpdate> updates = new ArrayList<>();
AttributeOverrides

* */
