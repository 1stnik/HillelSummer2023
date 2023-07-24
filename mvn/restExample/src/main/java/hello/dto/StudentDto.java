package hello.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;

    public StudentDto(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Deprecated
    /**
     * @since 1.0.0
     * @deprecated from 1.1.1
     */
    public String getFullName() {
        return lastName + " " + firstName;
    }
}
