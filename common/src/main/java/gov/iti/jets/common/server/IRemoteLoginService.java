package gov.iti.jets.common.server;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.UserDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteLoginService extends Remote {
    boolean checkUserPhoneNumber(String phoneNumber) throws RemoteException;
    boolean checkUserPassword(String phoneNumber, String Password) throws RemoteException;
    UserDTO getUser(String phoneNumber, IClientCallback client) throws RemoteException;
    boolean isUserOnline(String phoneNumber) throws RemoteException;
}


