package SAproject.demo.Controller;

import SAproject.demo.Repository.SubjectRepository;
import SAproject.demo.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class SubjectsController {
    @Autowired
    private final SubjectRepository subjectRepository;

    public SubjectsController(SubjectRepository subjectRepository){

        this.subjectRepository = subjectRepository;
    }
    @GetMapping("/Subjects")
    public Collection<Subject> Subject() {
        return subjectRepository.findAll().stream().collect(Collectors.toList());
    }
}
