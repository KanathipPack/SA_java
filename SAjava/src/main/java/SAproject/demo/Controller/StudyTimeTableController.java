package SAproject.demo.Controller;
import SAproject.demo.Repository.RoomRepository;
import SAproject.demo.Repository.StudyTimeTableRepository;
import SAproject.demo.Repository.SubjectRepository;
import SAproject.demo.Repository.TeacherRepository;
import SAproject.demo.entity.Room;
import SAproject.demo.entity.Studytimetable;

import SAproject.demo.entity.Subject;
import SAproject.demo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.sql.Time;
import java.util.Collection;
import java.util.Timer;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudyTimeTableController {

  @Autowired private final StudyTimeTableRepository Sttrepository;
  @Autowired private RoomRepository roomRepository;
  @Autowired private TeacherRepository teacherRepository;
  @Autowired private SubjectRepository subjectRepository;
  public StudyTimeTableController(StudyTimeTableRepository STTrepository){

      this.Sttrepository = STTrepository;
    }
    @GetMapping("/Studytimetables")
    public Collection<Studytimetable> Studytimetable() {
      return Sttrepository.findAll();
    }

    @PostMapping("/stt/add/{day},{time},{teacher},{room},{subject}")
    public  Studytimetable newStudytimetable(Studytimetable stt,@PathVariable String day, @PathVariable String time,@PathVariable String teacher,@PathVariable String room,@PathVariable String subject){

      Teacher teacheradd = teacherRepository.findByNameteacher(teacher);
      Room roomadd = roomRepository.findByRoomname(room);
      Subject subjectadd = subjectRepository.findBynamesubject(subject);

      String[] timecode = {"08.00-10.00","10.00-12.00","13.00-15.00"};
      int timeint = Integer.parseInt(time);

      stt.setDay(day);
      stt.setTimedate(timecode[timeint]);
      stt.setTeachers(teacheradd);
      stt.setRooms(roomadd);
      stt.setSubjects(subjectadd);

      return Sttrepository.save(stt);
    }
  @GetMapping

  @RequestMapping(value ="/delete/{idStudytimetable}")
   public  void deleteStudyTimeTable(Studytimetable stt,@PathVariable Long idStudytimetable){

   Sttrepository.deleteById(idStudytimetable);

  }
}

