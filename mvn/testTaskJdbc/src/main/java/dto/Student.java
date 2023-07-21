package dto;

import java.sql.Date;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Student {
    private Integer id;
    private String lastName;
    private String firstName;
    private String email;
    private Date dateOfBirth;
    private String group;
    private String country;
}
