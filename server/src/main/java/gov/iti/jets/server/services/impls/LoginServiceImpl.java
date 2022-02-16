package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.ILoginService;

import java.sql.SQLException;
import java.util.Optional;

public class LoginServiceImpl implements ILoginService {
    private final IUserRepository userRepository = RepoFactory.getUserRepo();


    @Override
    public boolean isPhoneNumberExist(String phoneNumber) {
        try {

            Optional<UserEntity> user =  userRepository.findUserByNumber(phoneNumber);

            return user.isPresent();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isPasswordCorrect(String phoneNumber, String password) {
        return false;
    }

    @Override
    public UserDTO getUserData(String phoneNumber, IClientCallback clientCallback) {
        return null;
    }
}
