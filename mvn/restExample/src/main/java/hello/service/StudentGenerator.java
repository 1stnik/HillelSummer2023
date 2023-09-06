package hello.service;

import hello.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class StudentGenerator {

    /**
     *
     * @return
     */
    public List<Student> studentList() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(UUID.randomUUID(), "Ivan", "Ivanov"));
        students.add(new Student(UUID.randomUUID(), "Petr", "Petrov"));
        students.add(new Student(UUID.randomUUID(), "Sidr", "Sidorov"));

        return students;
    }

    /**
     * Generate new student
     *
     * @param firstName - FN
     * @param lastName - LN
     * @return {@link java.util.ArrayList} of {@link Student}
     */
    public  Student getStudent(String firstName, String lastName){
        return new Student(UUID.randomUUID(), firstName, lastName);
    }
}
