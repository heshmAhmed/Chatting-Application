package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.server.repository.entity.GroupEntity;
import java.util.List;
import java.util.Optional;

public interface IGroupChatRepo {
    List<GroupEntity> getAllGroups();
    Optional<GroupEntity> findGroup(long groupId);
    List<String> getGroupUsers(long groupId);
    boolean addUserToGroup(String phoneNumber, long groupId);
    long createGroup(GroupEntity groupEntity);
    List<GroupEntity> getUserGroups(String phoneNumber);

}
