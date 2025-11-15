package ehsan.bookstore.dto.mapper;

import ehsan.bookstore.dto.AffiliateUserPointsDto;
import ehsan.bookstore.persistent.domain.AffiliateUserPoints;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface AffiliateUserPointsMapper {

  AffiliateUserPoints toEntity(AffiliateUserPointsDto affiliateUserPointsDto);

  AffiliateUserPointsDto toDto(AffiliateUserPoints affiliateUserPoints);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  AffiliateUserPoints partialUpdate(
      AffiliateUserPointsDto affiliateUserPointsDto,
      @MappingTarget AffiliateUserPoints affiliateUserPoints);
}