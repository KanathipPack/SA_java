package SAproject.demo.Controller;

import SAproject.demo.Repository.TeacherRepository;
import SAproject.demo.entity.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    TeacherController(TeacherRepository teacherRepository){

        this.teacherRepository = teacherRepository;
    }

    @RequestMapping("/teacher/add")
    @ResponseBody
    public String add(@Valid @RequestBody Teacher teacher){
        teacherRepository.save(teacher);
        return "Add OK";
    }


    @GetMapping("/Teachers")
    public Collection<Teacher> Teacher()
    {
        return teacherRepository.findAll().stream().collect(Collectors.toList());
    }

}
