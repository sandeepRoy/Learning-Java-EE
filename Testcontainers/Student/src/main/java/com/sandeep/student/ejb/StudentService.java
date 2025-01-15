package com.sandeep.student.ejb;

import com.sandeep.student.dto.StudentDTO;
import com.sandeep.student.entity.Student;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO createStudent(String student_name);

    StudentDTO getStudentByName(String student_name);
}
