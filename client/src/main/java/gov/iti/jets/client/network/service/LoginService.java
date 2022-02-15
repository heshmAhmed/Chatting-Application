package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.impls.ClientCallbackImpl;
import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.common.server.IRemoteLoginService;
import java.rmi.RemoteException;

public class LoginService {
    private static LoginService loginService;
    private static RegistryFactory registryFactory = RegistryFactory.getInstance();
    private IRemoteLoginService remoteLoginService = registryFactory.getRemoteLoginService();

    private LoginService() {
    }

    public static LoginService getInstance() {
        if(loginService == null)
            loginService = new LoginService();
        return loginService;
    }

    public boolean checkPhoneNumber(String phoneNumber) throws RemoteException {
        remoteLoginService.checkUserPhoneNumber(phoneNumber);
        return true;
    }

    public boolean checkPassword(String phoneNumber, String password) throws RemoteException {
        remoteLoginService.checkUserPassword(phoneNumber, password);

        return true;
    }

    public boolean connect() throws RemoteException {
        remoteLoginService.getUser("01151", new ClientCallbackImpl());
        return true;
    }


}
