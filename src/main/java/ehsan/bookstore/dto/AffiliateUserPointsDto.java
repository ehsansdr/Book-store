package ehsan.bookstore.dto;

import ehsan.bookstore.persistent.domain.AffiliateUserPoints;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * DTO for {@link AffiliateUserPoints}
 */
public record AffiliateUserPointsDto(InstanceActionsDto action, int point, ZonedDateTime createdAt,
                                     ZonedDateTime updatedAt) implements
    Serializable {

}