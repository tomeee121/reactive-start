package TB.reactivestart;

import TB.reactivestart.model.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class FillStudentTableService {
    private StudentRepo studentRepo;
    public FillStudentTableService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        Flux<Student> studentList = Flux.just(
                new Student("Tomasz", "Borowski"),
                new Student("Jan", "Nowak"),
                new Student("Robert", "Kowalski")
        );

        studentRepo.saveAll(studentList).subscribe();
    }
}
