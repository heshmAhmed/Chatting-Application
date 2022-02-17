package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.RegistrationDTO;

import gov.iti.jets.common.server.IRemoteRegistrationService;
import gov.iti.jets.server.repository.impls.UserRepoImpl;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.services.impls.RegistrationServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteRegistrationServiceImpl extends UnicastRemoteObject implements IRemoteRegistrationService {
    IUserRepository userRepo = UserRepoImpl.getInstance();
    RegistrationServiceImpl service = new RegistrationServiceImpl();

    public RemoteRegistrationServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean isPhoneRegistered(String userPhoneNumber) throws RemoteException {
        return service.isPhoneExisted(userPhoneNumber);
    }

    @Override
    public boolean isEmailRegistered(String userEmail) throws RemoteException {
        return service.isEmailExisted(userEmail);

    }

    @Override
    public boolean createNewUser(RegistrationDTO user) throws RemoteException {
        return service.createNewUser(user);
    }
}
