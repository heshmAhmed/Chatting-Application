package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteRegistrationService;
import gov.iti.jets.server.services.impls.RegistrationServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteRegistrationServiceImpl extends UnicastRemoteObject implements IRemoteRegistrationService {
    RegistrationServiceImpl registrationService = new RegistrationServiceImpl();

    public RemoteRegistrationServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean isPhoneRegistered(String userPhoneNumber) throws RemoteException {
        return registrationService.checkPhoneNumber(userPhoneNumber);
    }

    @Override
    public boolean isEmailRegistered(String userEmail) throws RemoteException {
        return registrationService.checkEmail(userEmail);

    }

    @Override
    public boolean createNewUser(UserDTO userDTO) throws RemoteException {
        System.out.println("RemoteReg");
        return registrationService.addNewUser(userDTO);
    }
}
