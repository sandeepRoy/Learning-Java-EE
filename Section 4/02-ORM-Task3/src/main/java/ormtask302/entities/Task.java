package ormtask302.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "TODOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Integer TODO_ID;

    private String SUBJECT;

    private String DETAILS;

    @ElementCollection
    @CollectionTable(name = "TODO_WATCHERS", joinColumns = @JoinColumn(name = "TODO_ID"))
    @Column(name = "LOGIN")
    private Set<String> loginSet = new HashSet<>();

    public void watchers(List<String> people_logged_in) {
       for(String people : people_logged_in) {
           loginSet.add(people);
       }
    }

    @ElementCollection
    @CollectionTable(name = "TODO_COMMENTS", joinColumns = @JoinColumn(name = "TODO_ID"))
    private List<Comment> commentList = new ArrayList<>();

    public void comments(Comment comment) {
        this.commentList.add(comment);
    }

    @ElementCollection
    @CollectionTable(name = "TODO_UPDATES", joinColumns = @JoinColumn(name = "TODO_ID"))
    @AttributeOverride(name = "user", column = @Column(name = "AUTHOR"))
    @AttributeOverride(name = "date", column = @Column(name = "UPDATE_DATE"))
    private List<ItemUpdate> itemUpdateList = new ArrayList<>();

    public void updates(ItemUpdate itemUpdate) {
        this.itemUpdateList.add(itemUpdate);
    }

    @ElementCollection
    @CollectionTable(name = "TODO_TAGS", joinColumns = @JoinColumn(name = "TODO_ID"))
    @MapKeyColumn(name = "NAME")
    @Column(name = "DESCRIPTION")
    private Map<String, String> tagMap = new HashMap<>();

    public void tags(Map<String, String> tags) {
       this.tagMap.putAll(tags);
    }
}
