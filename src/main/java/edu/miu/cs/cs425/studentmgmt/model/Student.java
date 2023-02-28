package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")

@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;


@NotBlank(message = "student Number  cannot be blank or empty or null")
@Column(name = "student_Number", nullable = false)
private String studentNumber;
    @NotBlank(message = "first name  cannot be blank or empty or null")
    @Column(name = "first_Name", nullable = false)
private String firstName;
    @Column(name = "middle_Name", nullable = true)
private String middleName;

    @NotBlank(message = "last name  cannot be blank or empty or null")
    @Column(name = "last_Name", nullable = false)
private String lastName;
    @Column(name = "cgpa", nullable = true)
private Double cgpa;

   @DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate dateOfEnrollment;
   private boolean isInternational;



    @ManyToMany
   @JoinTable(name = "students_classRoom",
   joinColumns = {@JoinColumn(name = "student_Id",referencedColumnName = "studentId")},
           inverseJoinColumns = {@JoinColumn(name = "classroom_Id", referencedColumnName = "classroomId")}
   )

   private List<Classroom>classrooms;


   @OneToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "transcript_Id",nullable = true)
   private Transcript transcript;

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                ", isInternational=" + isInternational +
                ", classrooms=" + classrooms +
                ", transcript=" + transcript +
                '}';
    }
}
