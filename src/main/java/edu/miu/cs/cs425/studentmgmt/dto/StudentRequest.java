package edu.miu.cs.cs425.studentmgmt.dto;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
public class StudentRequest {
    private String studentNumber;
    @NotBlank(message = "first name  cannot be blank or empty or null")
    private String firstName;
    private String middleName;
    @NotBlank(message = "last name  cannot be blank or empty or null")
    private String lastName;
    private Double cgpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;
    private boolean isInternational;
    private List<Classroom> classrooms;
    private Transcript transcript;
}
