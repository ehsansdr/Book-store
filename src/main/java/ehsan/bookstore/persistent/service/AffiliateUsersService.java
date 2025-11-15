package ehsan.bookstore.persistent.service;

import lombok.AllArgsConstructor;
import ehsan.bookstore.persistent.domain.AffiliateUsers;
import ehsan.bookstore.persistent.domain.Affiliates;
import ehsan.bookstore.persistent.domain.Instances;
import ehsan.bookstore.persistent.domain.Tiers;
import ehsan.bookstore.persistent.repository.AffiliateUsersRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AffiliateUsersService {

  private final AffiliateUsersRepository affiliateUsersRepository;

  AffiliateUsers saveAffiliateUsers(Affiliates currentAffiliate, Tiers tiers,Instances instances) {
    AffiliateUsers affiliateUsers = new AffiliateUsers(currentAffiliate, tiers , instances);
    return affiliateUsersRepository.save(affiliateUsers);
  }
}
