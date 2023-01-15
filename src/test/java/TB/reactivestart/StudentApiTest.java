package TB.reactivestart;

import TB.reactivestart.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureWebTestClient
class StudentApiTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void get() {
        webTestClient.get()
                .uri("/")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBodyList(Student.class)
                .hasSize(3);
    }

    @Test
    void getBySurname() {
        webTestClient.get()
                .uri("/find?surname=Kowalski")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Student.class)
                .value(student -> {
                    Assertions.assertThat(student.getName()).isEqualTo("Robert");
                });
    }

    @Test
    void add() {
        webTestClient
                .post()
                .uri("/")
                .body(Mono.just(new Student("Testowy", "Test")), Student.class)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Student.class)
                .value(student -> {
                    Assertions.assertThat(student.getName()).isEqualTo("Testowy");
                    Assertions.assertThat(student.getSurname()).isEqualTo("Test");
                });
    }
}