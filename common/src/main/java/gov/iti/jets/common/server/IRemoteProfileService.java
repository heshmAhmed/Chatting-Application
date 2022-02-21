package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.UserDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteProfileService extends Remote {
    public boolean updateProfile(UserDTO userDTO) throws RemoteException;
}
