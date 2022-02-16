package gov.iti.jets.server.network;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.server.services.impls.LoginServiceImpl;
import gov.iti.jets.server.services.interfaces.ILoginService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteLoginServiceImpl extends UnicastRemoteObject implements IRemoteLoginService {

    ILoginService loginService = new LoginServiceImpl();

    public RemoteLoginServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean checkUserPhoneNumber(String phoneNumber) throws RemoteException {
        if(phoneNumber.matches("\\d{11,15}")){

            return loginService.isPhoneNumberExist(phoneNumber);

        }
        return false;
    }

    @Override
    public boolean checkUserPassword(String phoneNumber, String Password) throws RemoteException {
        return false;
    }

    @Override
    public UserDTO getUser(String phoneNumber, IClientCallback client) throws RemoteException {
        return null;
    }
}
