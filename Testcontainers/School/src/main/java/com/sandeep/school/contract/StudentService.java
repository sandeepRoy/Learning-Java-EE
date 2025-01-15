package com.sandeep.school.contract;

import com.sandeep.school.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO createStudent(String student_name);
    StudentDTO getStudentByName(String student_name);
}
