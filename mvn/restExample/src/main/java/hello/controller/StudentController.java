package hello.controller;

import hello.dto.Student;
import hello.dto.StudentCreate;
import hello.dto.StudentDto;
import hello.service.StudentGenerator;
import hello.service.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    StudentRepository sr = new StudentRepository();

    @GetMapping("students") //GET [/api/v1/students]
    List<StudentDto> getStudents() throws SQLException {
        return sr.getStudents();
    }

    @GetMapping("students/{id}") // :id
    StudentDto getStudent(@PathVariable int id) throws SQLException {
        return sr.getStudent(id);
    }

    @PostMapping("student")
    int createStudent(@RequestBody StudentCreate student) throws SQLException {
        sr.createUser(student);
        return 0;
    }

    @PutMapping("student")
    Student updateStudent(@RequestBody StudentDto student) throws SQLException {
        sr.updateStudent(student);
        return new Student();
    }

    @DeleteMapping("student/{id}")
    Boolean deleteStudent(@PathVariable int id) throws SQLException {
         sr.deleteStudent(id);
         return true;
    }
}
