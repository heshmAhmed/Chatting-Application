package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.common.dtos.MessageDTO;

import java.util.List;

public interface IGroupService {
    String createGroup(GroupDTO groupDTO);
    List<GroupDTO> getUserGroups(String phoneNumber);
    boolean addUserToGroup(String phoneNumber, String groupId);
    void sendMsgToGroup(MessageDTO messageDTO, List<String> contacts);
}
