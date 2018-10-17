package SAproject.demo.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "Room")
public class Room {
    @Id
    @SequenceGenerator(name="room_seq",sequenceName="room_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="room_seq")
    @Column(name="room_ID",unique = true, nullable = true)
    private @NonNull Long id_room;
    private @NonNull String roomname;
/*
    @OneToMany(mappedBy = "rooms" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Studytimetable> studytimetables;
*/

    public Room(String roomname){
        this.roomname = roomname;
            }
}


