package gov.iti.jets.common;

import gov.iti.jets.common.dtos.UserDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginService extends Remote {

    boolean checkUserPhoneNumber(String phoneNumber) throws RemoteException;
    boolean checkUserPassword(String phoneNumber, String Password) throws RemoteException;


    void    getUser(String phoneNumber, UserDTO userDTO) throws RemoteException;

}
