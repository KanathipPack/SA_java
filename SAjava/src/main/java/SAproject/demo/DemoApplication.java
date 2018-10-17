package SAproject.demo;

import SAproject.demo.entity.*;
import SAproject.demo.Repository.*;
import SAproject.demo.Controller.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	ApplicationRunner init(RoomRepository RoomRepository, StudyTimeTableRepository StudyTimeTableRepository,
						   SubjectRepository SubjectRepository, TeacherRepository TeacherRepository) throws Exception{
		return args -> {

			Teacher teacher = new Teacher("pack");
			TeacherRepository.save(teacher);
			Teacher teacher2 = new Teacher("kanathip");
			TeacherRepository.save(teacher2);

			Room room = new Room("B4101");
			RoomRepository.save(room);

			Room room2 = new Room("B1202");
			RoomRepository.save(room2);

			Room room3 = new Room("B1108");
			RoomRepository.save(room3);

			Room room4 = new Room("B3032");
			RoomRepository.save(room4);

			Subject subject = new Subject("System Analysis and Design");
			SubjectRepository.save(subject);

			Subject subject2 = new Subject("Microprocessor");
			SubjectRepository.save(subject2);

			Subject subject3 = new Subject("Knowledge Discovery and Data Mining");
			SubjectRepository.save(subject3);

			String[] timedate = {"08.00-10.00","10.00-12.00","13.00-15.00"};

			Studytimetable stt = new Studytimetable(timedate[1],"Monday",subject,room2,teacher);
			StudyTimeTableRepository.save(stt);

		RoomRepository.findAll().forEach(System.out::println);
		SubjectRepository.findAll().forEach(System.out::println);
		TeacherRepository.findAll().forEach(System.out::println);

			StudyTimeTableRepository.findAll().forEach(System.out::println);
		};
	}


	}