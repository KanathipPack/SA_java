package SAproject.demo.Repository;
        import SAproject.demo.entity.Subject;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;
        import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findBynamesubject(String namesubject);
}