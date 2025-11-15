
package ehsan.bookstore.persistent.service;

import lombok.AllArgsConstructor;
import ehsan.bookstore.constant.AffiliateActionSlug;
import ehsan.bookstore.constant.TierSlug;
import ehsan.bookstore.exception.ResourceNotFoundException;
import ehsan.bookstore.persistent.domain.AffiliateUsers;
import ehsan.bookstore.persistent.domain.Affiliates;
import ehsan.bookstore.persistent.domain.InstanceActions;
import ehsan.bookstore.persistent.domain.Instances;
import ehsan.bookstore.persistent.domain.Tiers;
import ehsan.bookstore.persistent.repository.InstanceActionsRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InstanceActionsService {

  private final InstanceActionsRepository instanceActionsRepository;
  private final TiersService tiersService;
  private final AffiliateUsersService affiliateUsersService;
  private final AffiliateUserPointsService affiliateUserPointsService;

  public InstanceActions save(InstanceActions instanceActions) {
    return instanceActionsRepository.save(instanceActions);
  }

  public InstanceActions joinAffiliate(Affiliates selectedAffiliate, Instances selectedInstance) {
    Tiers lowestTiers = tiersService.getSingleBySlug(TierSlug.BRONZE)
        .orElseThrow(ResourceNotFoundException::new);

    AffiliateUsers selectedAffiliateUser = affiliateUsersService.saveAffiliateUsers(
        selectedAffiliate, lowestTiers, selectedInstance);

    InstanceActions joinAction = instanceActionsRepository.findByInstanceAndSlugAndTiers(
            selectedInstance, AffiliateActionSlug.JOIN, lowestTiers)
        .orElseThrow(ResourceNotFoundException::new);
    affiliateUserPointsService.savePoints(selectedAffiliateUser, joinAction);
    return joinAction;
  }
}
