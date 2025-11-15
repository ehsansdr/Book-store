package ehsan.bookstore.persistent.bootstrap;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ehsan.bookstore.constant.AffiliateActionSlug;
import ehsan.bookstore.constant.TierSlug;
import ehsan.bookstore.persistent.domain.InstanceActions;
import ehsan.bookstore.persistent.domain.Instances;
import ehsan.bookstore.persistent.domain.Tiers;
import ehsan.bookstore.persistent.service.InstanceActionsService;
import ehsan.bookstore.persistent.service.InstancesService;
import ehsan.bookstore.persistent.service.TiersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GallerygardiSeed implements CommandLineRunner {

  private final TiersService instanceTiersService;
  private final InstancesService instancesService;
  private final InstanceActionsService instanceActionsService;

  @Override
  public void run(String... args) throws Exception {
    Optional<Instances> currentInstance = instancesService.findByName(
        net.sepidan.common.constant.Instances.GALLERYGARDI);
    if (currentInstance.isPresent()) {
      Instances currentInstances = currentInstance.get();
      if (!instanceTiersService.existsBySlugAndLevel(TierSlug.BRONZE, 0)) {
        Tiers bronze = instanceTiersService.create(new Tiers(TierSlug.BRONZE, "bronze", 0, 1800));
        instanceActionsService.save(
            new InstanceActions(currentInstances, bronze, AffiliateActionSlug.JOIN, 50));
        instanceActionsService.save(
            new InstanceActions(currentInstances, bronze, AffiliateActionSlug.INTRODUCE, 200));
      }

      if (!instanceTiersService.existsBySlugAndLevel(TierSlug.SILVER, 1)) {
        Tiers silver = instanceTiersService.create(new Tiers(TierSlug.SILVER, "silver", 1, 3600));
        instanceActionsService.save(
            new InstanceActions(currentInstances, silver, AffiliateActionSlug.JOIN, 50));
        instanceActionsService.save(
            new InstanceActions(currentInstances, silver, AffiliateActionSlug.INTRODUCE, 200));
      }

      if (!instanceTiersService.existsBySlugAndLevel(TierSlug.GOLD, 2)) {
        Tiers gold = instanceTiersService.create(new Tiers(TierSlug.GOLD, "gold", 2, 5400));
        instanceActionsService.save(
            new InstanceActions(currentInstances, gold, AffiliateActionSlug.JOIN, 50));
        instanceActionsService.save(
            new InstanceActions(currentInstances, gold, AffiliateActionSlug.INTRODUCE, 200));
      }

      if (!instanceTiersService.existsBySlugAndLevel(TierSlug.VIP, 3)) {
        Tiers vip = instanceTiersService.create(new Tiers(TierSlug.VIP, "vip", 3, 7200));
        instanceActionsService.save(
            new InstanceActions(currentInstances, vip, AffiliateActionSlug.JOIN, 50));
        instanceActionsService.save(
            new InstanceActions(currentInstances, vip, AffiliateActionSlug.INTRODUCE, 200));
      }

    }
  }
}