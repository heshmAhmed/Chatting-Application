package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.RegistrationDTO;
import gov.iti.jets.common.dtos.UserDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

//isRegistered

public interface IRemoteRegistrationService extends Remote{

    public boolean isPhoneRegistered(String userPhoneNumber) throws RemoteException;
    public boolean isEmailRegistered(String userEmail)throws RemoteException;
    public boolean createNewUser(RegistrationDTO user)throws RemoteException;








}
