package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Lesson11RestfulapiStudentmgmtApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;



    public static void main(String[] args) {
        SpringApplication.run(Lesson11RestfulapiStudentmgmtApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello spring boot, Student Management app started......");
//        //creating student
//        var student1=Student.build(null,"000-61-0001", "Anna","Lynn", "Smith",3.45,
//                LocalDate.of(2019,5,24),true,null,null);
//        var saveStudent1=addNewStudent(student1);
//        System.out.println(saveStudent1);
//        var student2=Student.build(null,"000-61-0003", "LEMESSA",
//                "TAYE", "ADUGNA",3.49,
//                LocalDate.of(2019,6,24),true,null,null);
//        var saveStudent2=addNewStudent(student2);
//        System.out.println(saveStudent2);

    }

//    private Student addNewStudent(Student student){
//        return studentService.addNewStudent(student);
//    }
}
