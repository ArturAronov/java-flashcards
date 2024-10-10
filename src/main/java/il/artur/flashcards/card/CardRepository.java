package il.artur.flashcards.card;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class CardRepository {
    private List<Card> cards = new ArrayList<>();

    List<Card> findAll() {
        return cards;
    }

    Optional<Card> findById(Integer id) {
        return cards.stream().filter(card -> card.id() == id).findFirst();
    }

    void create(Card card) {
        cards.add(card);
    }

    void update(Card card) {
        Optional<Card> existingCard = findById(card.id());

        if(existingCard.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        cards.set(cards.indexOf(existingCard.get()), card);
    }

    void delete(Integer id) {
        cards.removeIf(card -> card.id().equals(id));
    }

    @PostConstruct
    private void init() {
        cards.add(new Card(
                1,
                0,
                0,
                0,
                "Hello",
                "World",
                Category.EASY,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        cards.add(new Card(
                2,
                0,
                0,
                0,
                "Goodbye",
                "World",
                Category.MEDIUM,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));
    }
}
