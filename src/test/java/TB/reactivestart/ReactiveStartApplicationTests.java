package TB.reactivestart;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest
class ReactiveStartApplicationTests {

	@Test
	void contextLoads() {
		Flux.just("Tomek", "Roman").map(String::toUpperCase).subscribe(System.out::println);

		Mono.just("Tomek").map(String::toUpperCase).subscribe(System.out::println);

	}

}
