package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.common.server.IRemoteGroupService;
import gov.iti.jets.server.services.interfaces.IGroupService;
import gov.iti.jets.server.services.util.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteGroupServiceImpl extends UnicastRemoteObject implements IRemoteGroupService{
    private final IGroupService groupService = ServiceFactory.getInstance().getGroupService();

    public RemoteGroupServiceImpl() throws RemoteException {
    }

    @Override
    public String createGroup(GroupDTO groupDTO) throws RemoteException {
        return groupService.createGroup(groupDTO);
    }

    @Override
    public void addContactsToGroup(String groupId, List<String> contacts) throws RemoteException {
        contacts.forEach(u -> groupService.addUserToGroup(u,groupId));

        ///////////////////////Modify let return weather a successful operation or not
    }
}
