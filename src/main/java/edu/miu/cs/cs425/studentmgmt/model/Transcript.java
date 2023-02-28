package edu.miu.cs.cs425.studentmgmt.model;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;
    private String degreeTitle;

    @OneToOne(mappedBy = "transcript")
    private Student student;

    @Override
    public String  toString(){
        return String.format("Transcript{transcriptId: %s, degreeTitle: %s}", transcriptId, degreeTitle);
    }
}
