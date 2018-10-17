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
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name = "Studytimetable")
public class Studytimetable {
    @Id
    @SequenceGenerator(name="No_STT",sequenceName="No_STT")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="No_STT")
    @Column(name = "No")

    private  @NonNull  Long idStudytimetable;
    private  @NonNull String timedate;
    private  @NonNull String day;


    @ManyToOne private Subject subjects;
    @ManyToOne private Room rooms;
    @ManyToOne private Teacher teachers;

public Studytimetable(String timedate, String day, Subject subject, Room room, Teacher teacher){
    this.timedate = timedate;
    this.day = day;
    this.subjects = subject;
    this.rooms = room;
    this.teachers  = teacher;

}

}

