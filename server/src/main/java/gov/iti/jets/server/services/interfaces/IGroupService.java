package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.GroupDTO;
import java.util.List;

public interface IGroupService {
    String createGroup(GroupDTO groupDTO);
    List<GroupDTO> getUserGroups(String phoneNumber);
    boolean addUserToGroup(String phoneNumber, String groupId);
    List<String> getGroupUsers(String groupId);
}
