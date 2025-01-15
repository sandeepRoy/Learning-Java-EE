package com.sandeep.school.service;

import com.sandeep.school.contract.StudentService;
import com.sandeep.school.dto.StudentDTO;
import com.sandeep.school.entity.School;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

@ApplicationScoped
@Transactional
public class SchoolService {
    @PersistenceContext
    EntityManager entityManager;

    private StudentService studentService;

    public SchoolService() {
        try {
            InitialContext context = new InitialContext();
            studentService = (StudentService) context.lookup("java:global/Student-1.0-SNAPSHOT/StudentServiceImpl!com.sandeep.student.ejb.StudentService");
        } catch (NamingException e) {
            throw new RuntimeException("Failed to lookup StudentService", e);
        }
    }

    public List<School> getAllSchools() {
        return entityManager.createQuery("select school from School school", School.class).getResultList();
    }

    public School createSchool(String school_name) {
        School school = new School();
        school.setSchool_name(school_name);
        entityManager.persist(school);
        return school;
    }

    public School assignStudentToSchool(String school_name, String student_name) {
        School school = entityManager
                .createQuery("select school from School school where school.school_name = :school_name", School.class)
                .setParameter("school_name", school_name)
                .getSingleResult();

        StudentDTO studentDTO = studentService.getStudentByName(student_name);
        school.setStudent_name(studentDTO.getStudent_name());
        entityManager.merge(school);
        return school;
    }
}
