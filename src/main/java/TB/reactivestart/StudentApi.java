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

    private Flux<Student> studentList;
    public StudentApi() {
         studentList = Flux.just(
                new Student("Tomasz", "Borowski"),
                new Student("Jan", "Nowak"),
                new Student("Robert", "Kowalski")
        );
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> get() {
        return studentList.delayElements(Duration.ofSeconds(2));
    }

    @PostMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> add(@RequestBody Student student) {
        return studentList.mergeWith(Mono.just(student));
    }
}
