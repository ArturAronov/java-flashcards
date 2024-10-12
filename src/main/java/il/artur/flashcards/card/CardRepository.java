// Version 2: in-memory SQL

package il.artur.flashcards.card;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;
import org.springframework.util.Assert;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepository {
    private static final Logger log = LoggerFactory.getLogger(CardRepository.class);
    private final JdbcClient jdbcClient;

    public CardRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Card> findAll() {
        return jdbcClient
                .sql("SELECT * FROM card")
                .query(Card.class)
                .list();
    }

    public void update(Card card) {
        var updated = jdbcClient
                .sql("UPDATE Card SET question = ?, answer = ?, date_edited = CURRENT_TIMESTAMP WHERE id = ?")
                .params(List.of(card.question(), card.answer(), card.id()))
                .update();

        Assert.state(updated == 1, "Failed to update card " + card.id());
    }

    public void create(Card card) {
        var updated = jdbcClient
                .sql("INSERT INTO Card(question, answer, category) VALUES (?, ?, ?)")
                .params(List.of(card.question(), card.answer(), card.category().toString()))
                .update();

        Assert.state(updated == 1, "Failed to create new card");
    }

    public void delete(Integer id) {
        var updated = jdbcClient
                .sql("DELETE FROM Card WHERE id = :id")
                .param("id", id)
                .update();

        Assert.state(updated == 1, "Failed to delete card with id: " + id);
    }
}



// Version 1
// package il.artur.flashcards.card;
//
// import jakarta.annotation.PostConstruct;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Repository;
// import org.springframework.web.server.ResponseStatusException;
//
// import java.util.List;
// import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Optional;
//
// @Repository
// public class CardRepository {
//     private List<Card> cards = new ArrayList<>();
//
//     List<Card> findAll() {
//         return cards;
//     }
//
//     Optional<Card> findById(Integer id) {
//         return cards.stream().filter(card -> card.id() == id).findFirst();
//     }
//
//     void create(Card card) {
//         cards.add(card);
//     }
//
//     void update(Card card) {
//         Optional<Card> existingCard = findById(card.id());
//
//         if(existingCard.isEmpty()) {
//             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//         }
//
//         cards.set(cards.indexOf(existingCard.get()), card);
//     }
//
//     void delete(Integer id) {
//         cards.removeIf(card -> card.id().equals(id));
//     }
//
//     @PostConstruct
//     private void init() {
//         cards.add(new Card(
//                 1,
//                 0,
//                 0,
//                 0,
//                 "Hello",
//                 "World",
//                 Category.EASY,
//                 LocalDateTime.now(),
//                 LocalDateTime.now()
//         ));
//
//         cards.add(new Card(
//                 2,
//                 0,
//                 0,
//                 0,
//                 "Goodbye",
//                 "World",
//                 Category.MEDIUM,
//                 LocalDateTime.now(),
//                 LocalDateTime.now()
//         ));
//     }
// }
