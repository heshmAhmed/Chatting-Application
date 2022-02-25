package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.dtos.UserDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteProfileService extends Remote {
    boolean updateProfile(UserDTO userDTO) throws RemoteException;
    boolean updateUserStatus(String phoneNumber, Status status, List<String> contacts) throws RemoteException;

}
