package gov.iti.jets.server.services.mapper;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactDtoMapper {

    ContactDtoMapper INSTANCE = Mappers.getMapper(ContactDtoMapper.class);

    @Mapping(source = "phoneNumber", target = "contactId")
    @Mapping(source = "username", target = "contactName")
    @Mapping(source = "image", target = "contactImage")
    @Mapping(source = "status", target = "contactStatus")
    ContactDTO userEntityToDTO(UserEntity entity);
}
