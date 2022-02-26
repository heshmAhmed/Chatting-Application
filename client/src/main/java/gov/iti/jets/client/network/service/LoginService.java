package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.impls.ClientCallbackImpl;
import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.ModelFactory;
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
        return remoteLoginService.checkUserPassword(phoneNumber, password);
    }

    public void submitLogin(String id){
        System.err.println(id);
        if(userDTO == null){
            try {
                userDTO =  remoteLoginService.getUser(id, new ClientCallbackImpl());
                modelFactory.fillUserModel(userDTO);
                modelFactory.fillContactModels(userDTO.getContacts());
                contactService.loadUserInvitations();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else{
            if(!userDTO.getPhoneNumber().equals(id)){
                System.out.println(userDTO.getPhoneNumber().equals(id));
                userDTO.getContacts().clear();
                System.out.println(userDTO.getContacts().size());
                modelFactory.fillContactModels(userDTO.getContacts());
                try {
                    userDTO =  remoteLoginService.getUser(id, new ClientCallbackImpl());
                    modelFactory.fillUserModel(userDTO);
                    modelFactory.fillContactModels(userDTO.getContacts());
                    contactService.loadUserInvitations();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
