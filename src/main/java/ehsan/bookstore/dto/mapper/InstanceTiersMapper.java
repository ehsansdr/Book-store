package ehsan.bookstore.dto.mapper;

import ehsan.bookstore.dto.InstanceTiersDto;
import ehsan.bookstore.persistent.domain.Tiers;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface InstanceTiersMapper {

  Tiers toEntity(InstanceTiersDto instanceTiersDto);

  InstanceTiersDto toDto(Tiers tiers);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Tiers partialUpdate(
      InstanceTiersDto instanceTiersDto, @MappingTarget Tiers tiers);
}