package com.example.crudtest1.service;

import com.example.crudtest1.controller.StudentController;
import com.example.crudtest1.entity.Student;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.OrderBy;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class StudentServiceTest {

    @Deployment
    public static WebArchive createDeployment() {

        WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "crud-test-1-1.0-SNAPSHOT.war")
                .addClasses(StudentService.class, Student.class, StudentController.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(webArchive.toString(true));
        return webArchive;
    }

    public static EntityManager em;
    static Weld weld;
    WeldContainer weldContainer;


    @BeforeClass
    public static void init() {
        em = Persistence.createEntityManagerFactory("h2-persistence-unit").createEntityManager();
        weld = new Weld();
        WeldContainer container = weld.initialize();
        container.event().fire(em);
    }

    @AfterClass
    public static void close() throws Exception {
        weld.shutdown();
    }

    @Test
    @OrderBy(value = "1")
    public void shouldReturnZeroBeforeAddingStudent() {
        List<Student> students = em.createQuery("select student from Student student", Student.class).getResultList();
        System.out.println("EntityManager At: " + em.toString());
        System.out.println("71: " + students.size());
        assertEquals(students.size(), 0);
    }

    @Test
    @OrderBy(value = "2")
    public void shouldCreateStudent() {

        String student_name = "Sandeep Roy";
        Student student = Student.builder().student_name(student_name).build();
        student.setStudent_id(1);
        em.persist(student);


        System.out.println("EntityManager At: " + em.toString());
        System.out.println("81: " + student.toString());
        assertEquals(student_name, student.getStudent_name());
    }

    @Test
    @OrderBy(value = "3")
    public void shouldReturnAllStudentsCount() {
        List<Student> students = em.createQuery("select student from Student student", Student.class).getResultList();

        System.out.println("EntityManager At: " + em.toString());
        System.out.println("87: " + students.size());
        assertEquals(students.size(), 0);
    }

}