package ehsan.bookstore.persistent.repository;

import java.util.Optional;
import ehsan.bookstore.constant.TierSlug;
import ehsan.bookstore.persistent.domain.Tiers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiersRepository extends JpaRepository<Tiers, Long> {

  Optional<Tiers> findByTierSlugAndLevel(TierSlug tierSlug, int level);

  Optional<Tiers> findByTierSlug(TierSlug tierSlug);
}