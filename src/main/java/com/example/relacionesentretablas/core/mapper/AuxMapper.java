package com.example.relacionesentretablas.core.mapper;

import com.example.relacionesentretablas.alumnos_estudios.application.IAlumno_EstudioService;
import com.example.relacionesentretablas.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.input.Alumnos_EstudiosDTOInput;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output.Alumnos_EstudiosDTOOutput;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output.Alumnos_EstudiosDTOOutputSimple;
import com.example.relacionesentretablas.persona.application.IPersonaService;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.output.PersonaDTOOutput;
import com.example.relacionesentretablas.profesor.application.IProfesorService;
import com.example.relacionesentretablas.profesor.domain.Profesor;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.input.ProfesorDTOInput;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output.ProfesorDTOOutput;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output.ProfesorDTOOutputSimple;
import com.example.relacionesentretablas.student.application.IStudentService;
import com.example.relacionesentretablas.student.domain.Student;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.input.StudentDTOInput;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.output.StudentDTOOutput;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.output.StudentDTOOutputSimple;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuxMapper {
    @Autowired
    IStudentService studentService;
    @Autowired
    IPersonaService personaService;
    @Autowired
    IProfesorService profesorService;
    @Autowired
    IAlumno_EstudioService alumnos_estudiosService;


    public Profesor createProfesor(ProfesorDTOInput profesorInput) {
        Profesor profesor = new Profesor();
        profesor.setId(profesorInput.getId());
        profesor.setPersona(personaService.findById(profesorInput.getIdPersona()).get());
        profesor.setComents(profesorInput.getComents());
        profesor.setBranch(profesorInput.getBranch());
        profesor.setStudents(studentService.Tolist(profesorInput.getClavesEstudiantes()));
        profesor.setBranch(profesorInput.getBranch());
        return profesor;

    }

    public Student createStudent(StudentDTOInput studentDTOInput) {
        Student estudiante = new Student();
        estudiante.setId_student(studentDTOInput.getId_student());
        estudiante.setPersona(personaService.findById(studentDTOInput.getIdpersona()).get());
        estudiante.setNum_hours_week(studentDTOInput.getNum_hours_week());
        estudiante.setComents(studentDTOInput.getComents());
        estudiante.setProfesor(profesorService.findById(studentDTOInput.getIdprofesor()).get());
        estudiante.setBranch(studentDTOInput.getBranch());
        return estudiante;
    }

    public Alumnos_Estudios createAlumnos_Estudios(Alumnos_EstudiosDTOInput estudiosDTO) {

        Alumnos_Estudios estudios = new Alumnos_Estudios();

        estudios.setId_study(estudiosDTO.getId_study());
        estudios.setProfesor(profesorService.findById(estudiosDTO.getIdprofesor()).get());
        estudios.setStudent(studentService.findById(estudiosDTO.getIDStudent()).get());
        estudios.setAsignatura(estudiosDTO.getAsignatura());
        estudios.setComment(estudiosDTO.getComment());
        estudios.setInitial_date(estudiosDTO.getInitial_date());
        estudios.setFinish_date(estudiosDTO.getFinish_date());
        return estudios;
    }


    public StudentDTOOutputSimple createStudentDTOOutputSimple(Student estudiante) {
        StudentDTOOutputSimple studentDTO = new StudentDTOOutputSimple();
        studentDTO.setId_student(estudiante.getId_student());
        studentDTO.setPersona(new PersonaDTOOutput(estudiante.getPersona()));
        studentDTO.setNum_hours_week(estudiante.getNum_hours_week());
        studentDTO.setComents(estudiante.getComents());
        List<Alumnos_EstudiosDTOOutputSimple> estudios = new ArrayList<>();
        if (estudiante.getEstudios() != null)
            estudiante.getEstudios().forEach(estudio -> estudios.add(new Alumnos_EstudiosDTOOutputSimple(estudio)));
        studentDTO.setEstudios(estudios);
        return studentDTO;
    }

    public StudentDTOOutput createStudentDTOOutput(Student estudiante) {
        StudentDTOOutput studentDTO = new StudentDTOOutput();
        studentDTO.setId_student(estudiante.getId_student());
        studentDTO.setPersona(new PersonaDTOOutput(estudiante.getPersona()));
        studentDTO.setNum_hours_week(estudiante.getNum_hours_week());
        studentDTO.setComents(estudiante.getComents());
        List<Alumnos_EstudiosDTOOutputSimple> estudios = new ArrayList<>();
        estudiante.getEstudios().forEach(estudio -> estudios.add(new Alumnos_EstudiosDTOOutputSimple(estudio)));
        studentDTO.setEstudios(estudios);
        return studentDTO;
    }

    public ProfesorDTOOutputSimple createProfesorDTOOutputSimple(Profesor profesor) {
        ProfesorDTOOutputSimple profesorDTO = new ProfesorDTOOutputSimple();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setPersona(new PersonaDTOOutput(personaService.findById(profesor.getPersona().getId()).get()));
        profesorDTO.setComents(profesor.getComents());
        profesorDTO.setBranch(profesor.getBranch());

        List<StudentDTOOutputSimple> students = new ArrayList<>();
        profesor.getStudents().forEach(estudiante -> students.add(createStudentDTOOutputSimple(estudiante)));

        profesorDTO.setStudents(students);

        return profesorDTO;


    }

    public ProfesorDTOOutput createProfesorDTOOutput(Profesor profesor) {
        ProfesorDTOOutput profesorDTO = new ProfesorDTOOutput();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setPersona(new PersonaDTOOutput(personaService.findById(profesor.getPersona().getId()).get()));
        profesorDTO.setComents(profesor.getComents());
        profesorDTO.setBranch(profesor.getBranch());

        List<StudentDTOOutputSimple> students = new ArrayList<>();
        profesor.getStudents().forEach(estudiante -> students.add(createStudentDTOOutputSimple(estudiante)));

        profesorDTO.setAlumnos(students);

        return profesorDTO;

    }

    public Alumnos_EstudiosDTOOutput createAlumnos_EstudiosDTOOutput(Alumnos_Estudios estudios) {
        Alumnos_EstudiosDTOOutput estudiosDTO = new Alumnos_EstudiosDTOOutput();
        estudiosDTO.setId_study(estudios.getId_study());
        estudiosDTO.setProfesor(createProfesorDTOOutput(estudios.getProfesor()));
        estudiosDTO.setStudent(createStudentDTOOutput(estudios.getStudent()));
        estudiosDTO.setAsignatura(estudios.getAsignatura());
        estudiosDTO.setComment(estudios.getComment());
        estudiosDTO.setInitial_date(estudios.getInitial_date());
        estudiosDTO.setFinish_date(estudios.getFinish_date());
        return estudiosDTO;

    }


}
