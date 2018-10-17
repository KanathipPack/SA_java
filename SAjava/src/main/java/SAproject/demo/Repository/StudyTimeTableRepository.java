package SAproject.demo.Repository;
        import SAproject.demo.entity.Studytimetable;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.web.bind.annotation.CrossOrigin;

        import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface StudyTimeTableRepository extends JpaRepository<Studytimetable, Long> {
    Studytimetable findByidStudytimetable(Long idStudytimetable);
    @Override
    void deleteById(Long aLong);

}

