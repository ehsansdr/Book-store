package ehsan.bookstore.persistent.repository;

import java.util.Optional;
import lombok.NonNull;
import ehsan.bookstore.constant.AffiliateActionSlug;
import ehsan.bookstore.persistent.domain.InstanceActions;
import ehsan.bookstore.persistent.domain.Instances;
import ehsan.bookstore.persistent.domain.Tiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstanceActionsRepository extends JpaRepository<InstanceActions, Long> {

  Optional<InstanceActions> findByInstanceAndSlugAndTiers(@NonNull Instances instance,
      @NonNull AffiliateActionSlug slug, @NonNull Tiers tiers);

  Optional<InstanceActions> findFirstByTiersAndSlugAndDeletedAtNotNullOrderByCreatedAtDesc(
      Tiers tiers, AffiliateActionSlug slug);
}