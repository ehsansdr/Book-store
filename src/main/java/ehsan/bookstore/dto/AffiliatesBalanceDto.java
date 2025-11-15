package ehsan.bookstore.dto;

import ehsan.bookstore.persistent.domain.Affiliates;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import ehsan.bookstore.constant.AffiliationIndicator;

/**
 * DTO for {@link Affiliates}
 */
public record AffiliatesBalanceDto(@NotNull AffiliationIndicator indicatorType,
                                   @NotNull String indicatorValue,
                                   @NotNull String affiliationCode,
                                   @NotNull List<AffiliateUserPointsDto> pointsDtos,
                                   @NotNull int totalPoints,
                                   @NotNull InstanceTiersDto tiersDto) implements
    Serializable {

}