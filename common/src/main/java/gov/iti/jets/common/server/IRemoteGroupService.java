package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.GroupDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteGroupService extends Remote {

    public String createGroup(GroupDTO groupDTO) throws RemoteException;

}
