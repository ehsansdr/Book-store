package ehsan.bookstore.persistent.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import ehsan.bookstore.constant.TierSlug;
import ehsan.bookstore.persistent.domain.Tiers;
import ehsan.bookstore.persistent.repository.TiersRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TiersService {

  private final TiersRepository tiersRepository;

  public boolean existsBySlugAndLevel(TierSlug tierSlug, int level) {
    return tiersRepository.findByTierSlugAndLevel(tierSlug, level).isPresent();
  }

  public Optional<Tiers> getSingleBySlug(TierSlug tierSlug) {
    return tiersRepository.findByTierSlug(tierSlug);
  }

  public Tiers create(Tiers tiers) {
    return tiersRepository.save(tiers);
  }
}
