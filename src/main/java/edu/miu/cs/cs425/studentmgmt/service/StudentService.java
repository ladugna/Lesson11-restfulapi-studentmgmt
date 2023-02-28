package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.dto.StudentRequest;
import edu.miu.cs.cs425.studentmgmt.exception.StudentNotFoundException;
import edu.miu.cs.cs425.studentmgmt.model.Student;

import java.util.List;


public interface StudentService {

    public Student addNewStudent(StudentRequest studentRequest);

     public List<Student> getAllStudents();
    public abstract Student getStudentById(Long studentId) throws StudentNotFoundException;
    public abstract Student updateStudent(StudentRequest updateStudent, Long studentId);
    public abstract void deleteStudentById(Long studentId);
    public Student searchStudentByName(String nameStart);
    List<Student> searchStudentByNameOrNumber(String searchString);
//    public List<Student> primeStudents();



}
