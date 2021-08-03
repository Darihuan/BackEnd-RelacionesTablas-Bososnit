package com.example.relacionesentretablas.student.application;

import com.example.relacionesentretablas.student.domain.Student;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.input.StudentDTOInput;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.output.StudentDTOOutputSimple;

import java.util.List;
import java.util.Optional;


public interface IStudentService {
    StudentDTOOutputSimple findStudentbyID(Integer id);

    Optional<Student> findById(Integer id);

    List<StudentDTOOutputSimple> allStudents();

    StudentDTOOutputSimple saveStudent(StudentDTOInput studentDTO);

    StudentDTOOutputSimple updateStudent(StudentDTOInput studentDTO, Integer id);

    void deleteStudent(Integer id);

    List<Student> Tolist(List<Integer> listId);
}
