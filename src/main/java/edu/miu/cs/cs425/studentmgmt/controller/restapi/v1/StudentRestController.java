package edu.miu.cs.cs425.studentmgmt.controller.restapi.v1;


import edu.miu.cs.cs425.studentmgmt.dto.StudentRequest;
import edu.miu.cs.cs425.studentmgmt.exception.StudentNotFoundException;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/eregistrar/api/student"})
public class StudentRestController {


    private StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = {"/list"})

    public ResponseEntity<List<Student>> listStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());

    }

    @GetMapping(value = {"/get/{studentId}"})
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId)
            throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.addNewStudent(studentRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentRequest studentRequest,
                                                 @PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.updateStudent(studentRequest, studentId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = {"/search/{nameStart}"})
    public ResponseEntity<List<Student>> searchStudentByName(@PathVariable String nameStart) {
        return ResponseEntity.ok(studentService.searchStudentByNameOrNumber(nameStart));
    }

//    @GetMapping("/prime")
//    public ResponseEntity<List<Student>> listPrimeStudent() {
//        return ResponseEntity.ok(studentService.primeStudents());
//
//    }



}
