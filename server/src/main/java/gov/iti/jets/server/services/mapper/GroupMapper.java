package gov.iti.jets.server.services.mapper;

import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.server.repository.entity.GroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);
    GroupEntity groupDTOToEntity(GroupDTO groupDTO);
    @Mapping(target = "contacts", ignore = true)
    GroupDTO groupEntityToDTO(GroupEntity groupEntity);
}
