package il.artur.flashcards.card;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final JdbcClientCardRepository jdbcClientCardRepository;
    private CardController(JdbcClientCardRepository jdbcClientCardRepository) {
        this.jdbcClientCardRepository = jdbcClientCardRepository;
    }


    @GetMapping("")
    List<Card> findAll() {
        return jdbcClientCardRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Card card) {
        System.out.println(card);
        jdbcClientCardRepository.create(card);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    void update(@RequestBody Card card) {
        jdbcClientCardRepository.update(card);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        jdbcClientCardRepository.delete(id);
    }
}
