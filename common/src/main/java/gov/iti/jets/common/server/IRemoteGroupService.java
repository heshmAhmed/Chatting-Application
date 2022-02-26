package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.GroupDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteGroupService extends Remote {

    public String createGroup(GroupDTO groupDTO) throws RemoteException;
    public void addContactsToGroup(String groupId, List<String> contacts) throws RemoteException;
}
