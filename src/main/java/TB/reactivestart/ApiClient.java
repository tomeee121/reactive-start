package TB.reactivestart;

import TB.reactivestart.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ApiClient {

    public void invokeGetFromApiUri(){
        Flux<Student> studentFlux = WebClient.create().get()
                .uri("http://localhost:8080")
                .retrieve()
                .bodyToFlux(Student.class);
        studentFlux.subscribe(info -> log.info(info.toString()));
    }

//    @EventListener(ApplicationContextEvent.class)
//    public void invokeAddToApiUri(){
//        Flux<Student> studentFlux = WebClient.create().post()
//                .uri("http://localhost:8080")
//                .body(Mono.just(new Student("Świeżo", "Dodany")), Student.class)
//                .retrieve()
//                .bodyToFlux(Student.class);
//        studentFlux.subscribe(info -> log.info(info.toString()));
//    }
}
