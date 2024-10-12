package il.artur.flashcards.card;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardRepository cardRepository;
    private CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @GetMapping("")
    List<Card> findAll() {
        return cardRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Card card) {
        System.out.println(card);
        cardRepository.create(card);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    void update(@RequestBody Card card) {
        cardRepository.update(card);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        cardRepository.delete(id);
    }
}
