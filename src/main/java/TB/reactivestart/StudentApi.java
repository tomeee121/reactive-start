package TB.reactivestart;

import TB.reactivestart.model.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class StudentApi {
    private StudentRepo studentRepo;
    public StudentApi(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> get() {
        return studentRepo.findAll().delayElements(Duration.ofSeconds(1));
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Student> getBySurname(@RequestParam String surname) {
        return studentRepo.findBySurname(surname);
    }

    @PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<Student> add(@RequestBody Student student) {
        return studentRepo.insert(student);
    }
}
