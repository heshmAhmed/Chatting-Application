package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.server.repository.interfaces.IGroupChatRepo;
import gov.iti.jets.server.repository.util.ImageUtility;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IGroupService;
import gov.iti.jets.server.services.mapper.GroupMapper;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupService implements IGroupService {
    private final IGroupChatRepo groupChatRepo = RepoFactory.getInstance().getGroupChatRepo();
    private final static GroupService groupService = new GroupService();
    private final ImageUtility imageUtility = ImageUtility.getInstance();
    private final ServerUtil serverUtil = ServerUtil.getInstance();
    private GroupService() {}

    public static GroupService getInstance() {
        return groupService;
    }

    @Override
    public String createGroup(GroupDTO groupDTO) {
        if(!groupDTO.getImg().equals("")) {
            String[] imageTokens = imageUtility.splitOverSpace(groupDTO.getImg());
            imageUtility.writeImageToDisk(groupDTO.getName()+ "-" + imageTokens[0], imageTokens[1]);
            groupDTO.setImg(groupDTO.getName() + "-" + imageTokens[0]);
        }
        else
            groupDTO.setImg("group.png");
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
        boolean added = groupChatRepo.addUserToGroup(phoneNumber, Long.parseLong(groupId));
        if(added) {
            IClientCallback iClientCallback = serverUtil.onlineUsers.get(phoneNumber);
            if(iClientCallback != null) {
                try {
                    iClientCallback.receiveNewGroup();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        return added;
    }
}
