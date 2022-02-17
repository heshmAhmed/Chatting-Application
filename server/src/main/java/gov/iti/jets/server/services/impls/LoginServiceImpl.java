package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.ILoginService;
import gov.iti.jets.server.services.mapper.UserEntityMapper;
import gov.iti.jets.server.services.util.HashingFactory;
import java.util.Optional;

public class LoginServiceImpl implements ILoginService {
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IUserRepository userRepository = repoFactory.getUserRepo();
    private final HashingFactory hashPassword = HashingFactory.getInstance();

    @Override
    public boolean isPhoneNumberExist(String phoneNumber) {
        boolean result = false;
        Optional<UserEntity> user = userRepository.findUserByNumber(phoneNumber);
        result = user.isPresent();
        return result;
    }

    @Override
    public boolean isPasswordCorrect(String phoneNumber, String password) {
        boolean result = false;
//        password = hashPassword.hashPassword(password);
        Optional<UserEntity> user = userRepository.findUserByNumber(phoneNumber);
        if (user.isPresent()) {
            result = (user.get().getPassword()).equals(password);
        }
        return result;
    }

    @Override
    public UserDTO getUserData(String phoneNumber) {
        Optional<UserEntity> user = userRepository.findUserByNumber(phoneNumber);
        return UserEntityMapper.INSTANCE.userEntityToDTO(user.orElseThrow());
    }

}