package ehsan.bookstore.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.time.ZonedDateTime;
import ehsan.bookstore.persistent.domain.Tiers;

/**
 * DTO for {@link Tiers}
 */
public record InstanceTiersDto(@NotNull String title, @Positive int level,
                               @PositiveOrZero int pointsThreshold, ZonedDateTime createdAt,
                               ZonedDateTime updatedAt) implements
    Serializable {

}