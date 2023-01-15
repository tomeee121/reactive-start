package TB.reactivestart;

import TB.reactivestart.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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

    @GetMapping
    public Flux<Student> get() {
        return studentList;
    }
}
