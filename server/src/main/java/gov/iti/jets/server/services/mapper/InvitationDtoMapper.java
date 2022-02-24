package gov.iti.jets.server.services.mapper;


import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.server.repository.entity.InvitationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvitationDtoMapper {

    InvitationDtoMapper INSTANCE = Mappers.getMapper(InvitationDtoMapper.class);
    InvitationDTO invitationDto(InvitationEntity entity);

}
