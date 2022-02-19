package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteRegistrationService;
import gov.iti.jets.server.services.impls.RegistrationServiceImpl;
import gov.iti.jets.server.services.interfaces.IRegistrationService;
import gov.iti.jets.server.services.util.ServiceFactory;
import jakarta.validation.constraints.Email;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteRegistrationServiceImpl extends UnicastRemoteObject implements IRemoteRegistrationService {

    IRegistrationService registrationService = ServiceFactory.getInstance().registrationService();

    public RemoteRegistrationServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean isPhoneRegistered(String userPhoneNumber) throws RemoteException {
        if (userPhoneNumber.matches("\\d{11,15}"))
            return registrationService.checkPhoneNumber(userPhoneNumber);
        return false;
    }

    @Override
    public boolean isEmailRegistered(@Email String userEmail) throws RemoteException {
        if (!userEmail.equals(""))
            return registrationService.checkEmail(userEmail);
        return false;
    }

    @Override
    public boolean createNewUser(UserDTO userDTO) throws RemoteException {
        return registrationService.addNewUser(userDTO);
    }
}
