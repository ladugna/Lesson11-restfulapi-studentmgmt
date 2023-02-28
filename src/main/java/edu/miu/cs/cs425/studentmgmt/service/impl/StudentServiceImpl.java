package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.dto.StudentRequest;
import edu.miu.cs.cs425.studentmgmt.exception.StudentNotFoundException;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
//    private static List<Student> accounts = new ArrayList<>();
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(StudentRequest newStudentRequest) {
        var newStudent = Student.build(null, newStudentRequest.getStudentNumber(),
                newStudentRequest.getFirstName(), newStudentRequest.getMiddleName(),
                newStudentRequest.getLastName(), newStudentRequest.getCgpa(),
                newStudentRequest.getDateOfEnrollment(),newStudentRequest.isInternational(),
                newStudentRequest.getClassrooms(),
                newStudentRequest.getTranscript());
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId).orElseThrow(() ->
                new StudentNotFoundException(String.format("Student with Id %d is not found", studentId)));
    }

    @Override
    public Student updateStudent(StudentRequest updateStudentRequest, Long studentId) {
        var updateStudent = Student.build(studentId, updateStudentRequest.getStudentNumber(),
                updateStudentRequest.getFirstName(),
                updateStudentRequest.getMiddleName(), updateStudentRequest.getLastName(),
                updateStudentRequest.getCgpa(), updateStudentRequest.getDateOfEnrollment(),
                updateStudentRequest.isInternational(), updateStudentRequest.getClassrooms(),
                updateStudentRequest.getTranscript());
        return studentRepository.save(updateStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student searchStudentByName(String nameStart) {
        return null;
    }

    @Override
    public List<Student> searchStudentByNameOrNumber(String searchString) {
        return studentRepository.findStudentsByStudentNumberContainingOrLastNameContainingOrFirstNameContaining(
                searchString,searchString,searchString);
    }

   /* @Override
    public Student searchStudentByName(String nameStart) {
        return studentRepository.getStudentWhereNameStartsWith(nameStart).orElse(null);
    }*/

   /* public List<Student> primeStudents(){

        return getPrimeAccounts();

    }
    public List<Student> getPrimeAccounts() {
        List<Student> primeStudents = new ArrayList<>();
        for (Student account : accounts) {
            if (account.getCgpa() > 3) {
                primeStudents.add((Student) accounts);
            }
        }
        return primeStudents;
    }
*/
}
