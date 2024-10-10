package il.artur.flashcards;

import il.artur.flashcards.card.Card;
import il.artur.flashcards.card.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger((Application.class));

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Application launched successfully!!");
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Card card = new Card(1, 0, 0, 0, "foo", "bar", Category.EASY, LocalDateTime.now(), LocalDateTime.now());
			log.info("Card: " + card);
		};
	}
}
