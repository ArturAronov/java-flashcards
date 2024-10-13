package il.artur.flashcards.card;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.asm.TypeReference;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

@Component
public class CardJsonDataLoader implements CommandLineRunner {
    private final ObjectMapper objectMapper;
    private final CardRepository cardRepository;
    private static final Logger log = LoggerFactory.getLogger(CardJsonDataLoader.class);

    public CardJsonDataLoader(CardRepository cardRepository, ObjectMapper objectMapper) {
        this.cardRepository = cardRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String ...args) throws Exception {
        if(cardRepository.count() < 10) {
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/cards.json")) {
                Cards allCards = objectMapper.readValue(inputStream, Cards.class);
                log.info("Reading {} from JSON data and saving to database", allCards.cards().size());
                cardRepository.saveAll(allCards.cards());
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }
        } else {
            log.info("Not loading Cards from JSON data because the collection contains more than 10 items");
        }
    }
}
