package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteRegistrationService;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.impls.UserRepoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Optional;

public class RemoteRegistrationServiceImpl extends UnicastRemoteObject implements IRemoteRegistrationService {
    UserRepoImpl userRepo = UserRepoImpl.getInstance();

    public RemoteRegistrationServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean isPhoneRegistered(String userPhoneNumber) throws RemoteException {
        System.out.println("isPhoneRegistered");
        Optional<UserEntity> user = null;
        try {
            user = userRepo.findUserByNumber(userPhoneNumber);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user.isPresent());
        return user.isPresent();
    }

    @Override
    public boolean isEmailRegistered(String userEmail) throws RemoteException {
        return false;
    }

    @Override
    public UserDTO createNewUser(UserDTO user) throws RemoteException {
        return null;
    }
}
