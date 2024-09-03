package ormtask302.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class ProjectTest {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
        entityManagerFactory = Persistence.createEntityManagerFactory("orm-task3-02");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    @Test
    @Transactional
    public void testCreateProject() {
        entityManager.getTransaction().begin();

        Project project = new Project();
        project.setNAME("Project Sandeep");

        ItemUpdate itemUpdate = new ItemUpdate("sandeep", LocalDate.now());
        project.update(itemUpdate);

        entityManager.persist(project);
        entityManager.getTransaction().commit();

        Project created_project = entityManager.find(Project.class, project.getPROJECT_ID());
        Assertions.assertEquals("Project Sandeep", created_project.getNAME());
        Assertions.assertEquals(1, created_project.getPROJECT_ID());
    }
}