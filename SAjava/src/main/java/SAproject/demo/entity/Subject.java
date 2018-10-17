package SAproject.demo.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    @SequenceGenerator(name="subject_seq",sequenceName="subject_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subject_seq")
    @Column(name="subject_ID",unique = true, nullable = true)
    private @NonNull Long id_Subjects;
    private @NonNull String namesubject;

  /* @OneToMany(mappedBy = "subjects",cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Studytimetable> studytimetables;
*/
public Subject(String namesubject){
    this.namesubject = namesubject;

}
}
