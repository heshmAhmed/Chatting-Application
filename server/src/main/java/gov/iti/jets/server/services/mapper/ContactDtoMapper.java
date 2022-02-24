package gov.iti.jets.server.services.mapper;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.server.repository.entity.ContactEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactDtoMapper {
    ContactDtoMapper INSTANCE = Mappers.getMapper(ContactDtoMapper.class);
    ContactDTO contactEntityToDTO(ContactEntity contactEntity);
}
