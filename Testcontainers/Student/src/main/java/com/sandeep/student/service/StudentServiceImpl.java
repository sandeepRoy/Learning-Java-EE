package com.sandeep.student.service;

import com.sandeep.student.dto.StudentDTO;
import com.sandeep.student.ejb.StudentService;
import com.sandeep.student.entity.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StudentDTO> getAllStudents() {
        return entityManager.createQuery("SELECT student FROM Student student", Student.class)
                .getResultList()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(String student_name) {
        Student student = new Student();
        student.setStudent_name(student_name);
        entityManager.persist(student);
        return toDTO(student);
    }

    @Override
    public StudentDTO getStudentByName(String student_name) {
        Student student = entityManager.createQuery("SELECT student FROM Student student where student.student_name = :student_name", Student.class)
                .setParameter("student_name", student_name)
                .getSingleResult();
        StudentDTO studentDTO = toDTO(student);
        return studentDTO;
    }

    private StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setStudent_id(student.getStudent_id());
        dto.setStudent_name(student.getStudent_name());
        return dto;
    }
}