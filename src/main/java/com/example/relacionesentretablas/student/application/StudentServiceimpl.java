package com.example.relacionesentretablas.student.application;

import com.example.relacionesentretablas.core.error.NotFoundException;
import com.example.relacionesentretablas.core.mapper.AuxMapper;
import com.example.relacionesentretablas.student.domain.Student;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.input.StudentDTOInput;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.output.StudentDTOOutputSimple;
import com.example.relacionesentretablas.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements IStudentService {
    @Autowired
    StudentRepository repositorio;
    @Autowired
    AuxMapper mapper;

    @Override
    public StudentDTOOutputSimple findStudentbyID(Integer id) {
        Student student = repositorio.findById(id).orElseThrow(() -> new NotFoundException("no existe estudiante con id:" + id));

        return mapper.createStudentDTOOutputSimple(student);
    }

    @Override
    public Optional<Student> findById(Integer id) {


        return repositorio.findById(id);
    }

    @Override
    public List<StudentDTOOutputSimple> allStudents() {
        List<Student> students = repositorio.findAll();
        List<StudentDTOOutputSimple> studentsDTO = new ArrayList();
        students.forEach(element -> studentsDTO.add(mapper.createStudentDTOOutputSimple(element)));
        return studentsDTO;
    }

    @Override
    public StudentDTOOutputSimple saveStudent(StudentDTOInput studentDTO) {
        Student student = mapper.createStudent(studentDTO);

        repositorio.save(student);

        return mapper.createStudentDTOOutputSimple(student);
    }

    @Override
    public StudentDTOOutputSimple updateStudent(StudentDTOInput studentDTO, Integer id) {
        Student student = mapper.createStudent(studentDTO);

        Student comprobarExisteEstudiante = repositorio.findById(id).orElseThrow(() -> new NotFoundException("no existe estudiante con id:" + id));

        repositorio.save(student);

        return mapper.createStudentDTOOutputSimple(student);

    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = repositorio.findById(id).orElseThrow(() -> new NotFoundException("no existe estudiante con id: " + id));
        repositorio.deleteById(id);

    }

    @Override
    public List<Student> Tolist(List<Integer> listId) {
        List<Student> estudiantes = new ArrayList<>();
        listId.forEach(clave -> estudiantes.add(repositorio.findById(clave).orElseThrow(() -> new NotFoundException("No existe estudiante en la base de datos con id:" + clave))));
        return estudiantes;
    }
}
