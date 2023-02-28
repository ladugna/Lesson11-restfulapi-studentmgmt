package edu.miu.cs.cs425.studentmgmt.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    private String buildingName;
    private String roomNumber;


    @ManyToMany(mappedBy = "classrooms")
    private List<Student>students;

    @Override
    public String  toString(){
        return String.format("Classroom{classroomId: %s, buildingName: %s, roomNumber: %s}", classroomId,buildingName,roomNumber);
    }

}
