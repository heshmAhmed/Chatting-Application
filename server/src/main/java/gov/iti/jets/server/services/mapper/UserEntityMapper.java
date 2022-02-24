package gov.iti.jets.server.services.mapper;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {
     UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

     @Mapping(source = "dateOfBirth", target = "dob")
     UserDTO userEntityToDTO(UserEntity entity);

     @Mapping(source = "dob", target = "dateOfBirth")
     UserEntity userDTOToEntity(UserDTO dto);
}
