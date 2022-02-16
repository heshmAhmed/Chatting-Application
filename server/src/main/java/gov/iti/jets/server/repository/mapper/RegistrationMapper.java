package gov.iti.jets.server.repository.mapper;

import gov.iti.jets.common.dtos.RegistrationDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegistrationMapper {

    RegistrationMapper REGISTRATION_MAPPER = Mappers.getMapper(RegistrationMapper.class);
    UserEntity USER (RegistrationDTO dto);





}
