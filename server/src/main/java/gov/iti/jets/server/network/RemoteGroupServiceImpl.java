package gov.iti.jets.server.network;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.common.server.IRemoteGroupService;
import gov.iti.jets.server.services.interfaces.IGroupService;
import gov.iti.jets.server.services.util.ServerUtil;
import gov.iti.jets.server.services.util.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteGroupServiceImpl extends UnicastRemoteObject implements IRemoteGroupService {
    private final IGroupService groupService = ServiceFactory.getInstance().getGroupService();
    private final ServerUtil serverUtil = ServerUtil.getInstance();

    public RemoteGroupServiceImpl() throws RemoteException {
    }

    @Override
    public String createGroup(GroupDTO groupDTO) throws RemoteException {
        return groupService.createGroup(groupDTO);
    }

    @Override
    public void addContactsToGroup(String groupId, List<String> contacts) throws RemoteException {
        contacts.forEach(contact -> groupService.addUserToGroup(contact, groupId));
        List<String> groupContacts = groupService.getGroupUsers(groupId);
//        System.out.println("groupContacts: " +  groupContacts);
        groupContacts.forEach(groupContact ->{
            IClientCallback iClientCallback = serverUtil.onlineUsers.get(groupContact);
            if(iClientCallback != null) {
                try {
                    iClientCallback.receiveNewGroup();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public List<GroupDTO> getUserGroups(String userId) throws RemoteException {
        return groupService.getUserGroups(userId);
    }
}
