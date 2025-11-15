package ehsan.bookstore.dto;

import ehsan.bookstore.persistent.domain.Affiliates;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import ehsan.bookstore.constant.AffiliationIndicator;

/**
 * DTO for {@link Affiliates}
 */
public record AffiliatesDto(@NotNull AffiliationIndicator indicatorType,
                            @NotNull String indicatorValue,
                            @NotNull String affiliationCode) implements
    Serializable {

}