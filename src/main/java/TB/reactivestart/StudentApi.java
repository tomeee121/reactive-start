package TB.reactivestart;

import TB.reactivestart.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class StudentApi {
    private StudentRepo studentRepo;
//    private Flux<Student> studentList;
    public StudentApi(StudentRepo studentRepo) {
//         studentList = Flux.just(
//                new Student("Tomasz", "Borowski"),
//                new Student("Jan", "Nowak"),
//                new Student("Robert", "Kowalski")
//        );

        this.studentRepo = studentRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> get() {
        return studentRepo.findAll().delayElements(Duration.ofSeconds(1));
    }

    @PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Student> add(@RequestBody Student student) {
        return studentRepo.insert(student);
    }
}
