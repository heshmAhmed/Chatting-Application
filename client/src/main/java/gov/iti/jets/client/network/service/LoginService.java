package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.impls.ClientCallbackImpl;
import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteLoginService;
import java.rmi.RemoteException;

public class LoginService {
    private static LoginService loginService;
    private static RegistryFactory registryFactory = RegistryFactory.getInstance();
    private IRemoteLoginService remoteLoginService = registryFactory.getRemoteLoginService();
    private ModelFactory modelFactory = ModelFactory.getInstance();

    private LoginService() {
    }

    public static LoginService getInstance() {
        if(loginService == null)
            loginService = new LoginService();
        return loginService;
    }

    public boolean validatePhoneNumber(String phoneNumber) throws RemoteException {
        return remoteLoginService.checkUserPhoneNumber(phoneNumber);
    }

    public boolean validatePassword(String phoneNumber, String password) throws RemoteException {
//        return remoteLoginService.checkUserPassword(phoneNumber, password);
    return true;
    }


    public void submitLogin(String id){
        UserDTO userDTO = new UserDTO();
        try {
            userDTO =  remoteLoginService.getUser(id, new ClientCallbackImpl());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        modelFactory.fillUserModel(userDTO);
    }


}
