package edu.miu.cs.cs425.studentmgmt.repository;

import edu.miu.cs.cs425.studentmgmt.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
//    List<Student> findStudentsByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContaining(  String studentNumber,
//                                                                            String firstname,
//                                                                            String middleName, String lastName);

    // Custom Query using JPQL
 //   @Query(value = "select p from Student where p.firstName = :firstName")
 //   Optional<Student> getPublisherByName(String name);

//    @Query(value = "select p from students p where  LIKE %?1%", nativeQuery = true)
//    Optional<Student> getStudentWhereNameStartsWith(String nameStart);

//       @Query(value = "select p from students p where  LIKE %?1%", nativeQuery = true)
    List<Student> findStudentsByStudentNumberContainingOrLastNameContainingOrFirstNameContaining
            (String studentNumber, String lastName, String firstName);


}
