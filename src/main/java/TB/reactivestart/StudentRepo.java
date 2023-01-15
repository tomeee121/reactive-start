package TB.reactivestart;

import TB.reactivestart.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
}
