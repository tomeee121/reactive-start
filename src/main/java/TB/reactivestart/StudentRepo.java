package TB.reactivestart;

import TB.reactivestart.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepo extends ReactiveMongoRepository<Student, String> {

    Mono<Student> findBySurname(String surname);
}
