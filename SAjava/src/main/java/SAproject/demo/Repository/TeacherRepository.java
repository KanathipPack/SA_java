package SAproject.demo.Repository;
import SAproject.demo.entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByNameteacher(String nameteacher);
}
