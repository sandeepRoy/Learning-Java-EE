package ormtask302.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("orm-task3-02");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        if(entityManager.isOpen()) { entityManager.close(); }
        if(entityManagerFactory.isOpen()) { entityManagerFactory.close(); }
    }

    @Test
    @Transactional
    void testCreateTask() {
        entityManager.getTransaction().begin();

        Task task = new Task();
        task.setSUBJECT("Test Subject");
        task.setDETAILS("Test Details");

        List<String> people_who_logged_in = new ArrayList<>();
        people_who_logged_in.add("Sandeep Roy"); people_who_logged_in.add("John Doe");
        people_who_logged_in.add("Sandeep Roy"); people_who_logged_in.add("Name Surname");
        task.watchers(people_who_logged_in);

        Comment comment1_sandeepRoy = new Comment("Sandeep Roy", LocalDate.now(), "Comment1");
        Comment comment2_sandeepRoy = new Comment("Sandeep Roy", LocalDate.now().plusDays(1), "Comment2");
        task.comments(comment1_sandeepRoy);
        task.comments(comment2_sandeepRoy);


        ItemUpdate itemupdate_sandeepRoy = new ItemUpdate("Sandeep Roy", LocalDate.now().plusDays(2));
        ItemUpdate itemupdate_jhonDoe = new ItemUpdate("Jhon Doe", LocalDate.now().plusDays(3));
        task.updates(itemupdate_sandeepRoy);
        task.updates(itemupdate_jhonDoe);

        HashMap<String, String> tags = new HashMap<>();
        tags.put("Sandeep Roy", "Description Sandeep");
        tags.put("John Doe", "Description John");
        task.tags(tags);

        entityManager.persist(task);
        entityManager.getTransaction().commit();
        Task task_updated = entityManager.find(Task.class, 1);

        // Tasks
        Assertions.assertEquals("Test Subject", task_updated.getSUBJECT());
        Assertions.assertEquals("Test Details", task_updated.getDETAILS());

        // Watchers
        Assertions.assertEquals("John Doe", task_updated.getLoginSet().stream().toList().get(0));
        Assertions.assertEquals("Name Surname", task_updated.getLoginSet().stream().toList().get(2));

        // Comments
        Assertions.assertEquals("Sandeep Roy", task_updated.getCommentList().get(0).getAuthor());
        Assertions.assertEquals("Comment1", task_updated.getCommentList().get(0).getComment());

        // Updates
        Assertions.assertEquals("Jhon Doe", task_updated.getItemUpdateList().get(1).getUser());
        Assertions.assertEquals(LocalDate.now().plusDays(3), task_updated.getItemUpdateList().get(1).getDate());

        // Tags
        Assertions.assertEquals("Description Sandeep", task_updated.getTagMap().get("Sandeep Roy"));
    }
}