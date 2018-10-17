package SAproject.demo.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Teacher")
public class Teacher {
    @Id
    @SequenceGenerator(name="teacher_seq",sequenceName="teacher_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="teacher_seq")
    @Column(name="teacher_ID",unique = true, nullable = true)
    private   @NonNull    Long id_teacher;
    private   @NonNull String nameteacher;
/*
    @OneToMany(mappedBy = "teachers",cascade = CascadeType.ALL,orphanRemoval = true)

    private List<Studytimetable> studytimetables;
*/
    public Teacher(){}
    public Teacher(String nameteacher){

        this.nameteacher = nameteacher;
    }

}
