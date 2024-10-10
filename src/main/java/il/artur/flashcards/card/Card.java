package il.artur.flashcards.card;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public record Card(
        @NotEmpty Integer id,
        @PositiveOrZero Integer correct,
        @PositiveOrZero Integer wrong,
        @PositiveOrZero Integer skipped,
        String question,
        String answer,
        Category category,
        @PastOrPresent LocalDateTime dateCreated,
        @PastOrPresent LocalDateTime dateEdited
) {}
