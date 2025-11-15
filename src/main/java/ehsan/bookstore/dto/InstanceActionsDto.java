package ehsan.bookstore.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import ehsan.bookstore.constant.AffiliateActionSlug;
import ehsan.bookstore.persistent.domain.InstanceActions;

/**
 * DTO for {@link InstanceActions}
 */
public record InstanceActionsDto(Long id, AffiliateActionSlug slug, String description,
                                 int pointAchieved, ZonedDateTime createdAt,
                                 ZonedDateTime updatedAt, ZonedDateTime deletedAt) implements
    Serializable {

}