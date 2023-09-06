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
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @version 0.0.1
 */
@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
@Slf4j
public class StudentControllerLocal {

    private final StudentGenerator students;

    @GetMapping("students") //GET [/api/v1/students]
    List<Student> getStudents() throws SQLException {
        return students.studentList();
    }

    @GetMapping("students/{id}") // :id
    Student getStudent(@PathVariable String id) {
        return students.studentList().stream().filter(s-> s.getId().toString().equals(id)).findFirst().orElseThrow(() -> new RuntimeException());
    }

    @PostMapping("student")
    String createStudent(@RequestBody StudentCreate student) {
        UUID uuid = UUID.randomUUID();
        students.studentList().add(new Student(uuid, student.getFirstName(), student.getLastName()));
        return uuid.toString();
    }

    @PutMapping("student")
    Student updateStudent(@RequestBody Student student) throws SQLException {
        Student st = students.studentList().stream().filter(s-> s.getId().equals(student.getId())).findFirst().orElseThrow(() -> new RuntimeException());
        st.setFirstName(student.getFirstName());
        st.setLastName(student.getLastName());
        return st;
    }

    @DeleteMapping("student/{uuid}")
    Boolean deleteStudent(@PathVariable UUID uuid){
//         students = students.stream().filter(s -> !s.getId().equals(uuid)).collect(Collectors.toList());
         return true;
    }
}
