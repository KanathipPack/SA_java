package SAproject.demo.Repository;
        import SAproject.demo.entity.Room;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public
interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomname(String roomname);
}