package gov.iti.jets.server.network;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.server.services.impls.LoginServiceImpl;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.interfaces.ILoginService;
import gov.iti.jets.server.services.util.ServerUtil;
import gov.iti.jets.server.services.util.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteLoginServiceImpl extends UnicastRemoteObject implements IRemoteLoginService {
    ILoginService loginService = ServiceFactory.getInstance().loginService();
    IContactService contactService = ServiceFactory.getInstance().getContactService();
    ServerUtil serverUtil = ServerUtil.getInstance();

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
    public boolean checkUserPassword(String phoneNumber, String password) throws RemoteException {
        if( password.length() > 0 ) {
            return loginService.isPasswordCorrect(phoneNumber, password);
        }
        return false;
    }

    @Override
    public UserDTO getUser(String phoneNumber, IClientCallback clientCallback) throws RemoteException {
        UserDTO userDTO = loginService.getUserData(phoneNumber);
        userDTO.setContacts(contactService.getAllUserContacts(phoneNumber));
        serverUtil.addUserToOnline(phoneNumber, clientCallback);
        return userDTO;
    }
}
