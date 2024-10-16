package il.artur.flashcards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import il.artur.flashcards.card.Card;
import il.artur.flashcards.card.Category;
import il.artur.flashcards.card.JdbcClientCardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger((Application.class));

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Application launched successfully!!");
	}

	@Bean
	CommandLineRunner card(JdbcClientCardRepository jdbcClientCardRepository) {
		return args -> {
			Card card = new Card(
					null,
					null,
					null,
					null,
					"Foo",
					"Bar",
					Category.EASY,
					null,
					null
			);
			jdbcClientCardRepository.create(card);
		};
	}
}
