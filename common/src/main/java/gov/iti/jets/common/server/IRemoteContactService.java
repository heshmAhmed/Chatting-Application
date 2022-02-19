package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.ContactDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteContactService extends Remote {
    List<ContactDTO> getAllUserContacts (String userId)throws RemoteException;
}
