package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.GroupDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteGroupService extends Remote {

    String createGroup(GroupDTO groupDTO) throws RemoteException;
    void addContactsToGroup(String groupId, List<String> contacts) throws RemoteException;
    List<GroupDTO> getUserGroups(String userId) throws RemoteException;
}
