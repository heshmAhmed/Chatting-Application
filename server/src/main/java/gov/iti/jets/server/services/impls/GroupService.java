package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.server.repository.interfaces.IGroupChatRepo;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IGroupService;
import gov.iti.jets.server.services.mapper.GroupMapper;
import java.util.ArrayList;
import java.util.List;

public class GroupService implements IGroupService {
    private final IGroupChatRepo groupChatRepo = RepoFactory.getInstance().getGroupChatRepo();
    private final static GroupService groupService = new GroupService();
    private GroupService() {}

    public static GroupService getInstance() {
        return groupService;
    }

    @Override
    public String createGroup(GroupDTO groupDTO) {
        return groupChatRepo.createGroup(GroupMapper.INSTANCE.groupDTOToEntity(groupDTO)) + "";
    }


    @Override
    public List<GroupDTO> getUserGroups(String phoneNumber) {
        List<GroupDTO> groupDTOS = new ArrayList<>();
        groupChatRepo.getUserGroups(phoneNumber).forEach(groupEntity -> {
            GroupDTO groupDTO = GroupMapper.INSTANCE.groupEntityToDTO(groupEntity);
            groupDTO.setContacts(groupChatRepo.getGroupUsers(groupEntity.getId()));
            groupDTOS.add(groupDTO);
        });
        return groupDTOS;
    }

    @Override
    public boolean addUserToGroup(String phoneNumber, String groupId) {
        return groupChatRepo.addUserToGroup(phoneNumber, Long.parseLong(groupId));
    }
}
