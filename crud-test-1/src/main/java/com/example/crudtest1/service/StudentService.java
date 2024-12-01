package com.example.crudtest1.service;

import com.example.crudtest1.entity.Student;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class StudentService {
    @PersistenceContext
    EntityManager entityManager;

    public List<Student> getAllStudents() {
        return entityManager.createQuery("select student from Student student", Student.class).getResultList();
    }

    public Student createStudent(String student_name) {
        Student student = Student.builder().student_name(student_name).build();
        entityManager.persist(student);
        return student;
    }
}
