package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.impls.ClientCallbackImpl;
import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.Popups;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteLoginService;
import java.rmi.RemoteException;

public class LoginService {
    private static LoginService loginService;
    private static RegistryFactory registryFactory = RegistryFactory.getInstance();
    private IRemoteLoginService remoteLoginService = registryFactory.getRemoteLoginService();
    private ModelFactory modelFactory = ModelFactory.getInstance();
    private ContactService contactService = ContactService.getInstance();
    private UserDTO userDTO;
    private GroupService groupService = GroupService.getInstance();

    private LoginService() {
    }

    public static LoginService getInstance() {
        if(loginService == null)
            loginService = new LoginService();
        return loginService;
    }

    public boolean isUserOnline(String phoneNumber) throws RemoteException {
        return remoteLoginService.isUserOnline(phoneNumber);
    }
    public boolean validatePhoneNumber(String phoneNumber) throws RemoteException {
        return remoteLoginService.checkUserPhoneNumber(phoneNumber);
    }

    public boolean validatePassword(String phoneNumber, String password) throws RemoteException {
        return remoteLoginService.checkUserPassword(phoneNumber, password);
    }

    public void submitLogin(String id){
        UserDTO userDTO;
        try {
            userDTO =  remoteLoginService.getUser(id, new ClientCallbackImpl());
            modelFactory.fillUserModel(userDTO);
            modelFactory.fillContactModels(userDTO.getContacts());
            contactService.loadUserInvitations();
            groupService.loadGroups();

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
