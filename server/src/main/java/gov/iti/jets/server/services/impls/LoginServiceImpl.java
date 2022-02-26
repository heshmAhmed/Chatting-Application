package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.ImageUtility;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.ILoginService;
import gov.iti.jets.server.services.mapper.UserEntityMapper;
import gov.iti.jets.server.services.util.HashingFactory;
import java.util.Optional;

public class LoginServiceImpl implements ILoginService {
    private final static LoginServiceImpl loginServiceImpl=new LoginServiceImpl();
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IUserRepository userRepository = repoFactory.getUserRepo();
    private final HashingFactory hashPassword = HashingFactory.getInstance();
    private final ImageUtility imageUtility = ImageUtility.getInstance();

    private LoginServiceImpl(){

    }

    public static LoginServiceImpl getInstance() {
        return loginServiceImpl;
    }
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
        password = hashPassword.hashPassword(password);
        Optional<UserEntity> user = userRepository.findUserByNumber(phoneNumber);
        if (user.isPresent()) {
            result = (user.get().getPassword()).equals(password);
        }
        return result;
    }

    @Override
    public UserDTO getUserData(String phoneNumber) {
        Optional<UserEntity> user = userRepository.findUserByNumber(phoneNumber);
        UserDTO userDTO = UserEntityMapper.INSTANCE.userEntityToDTO(user.orElseThrow());
        userDTO.setImage(imageUtility.readImage(userDTO.getImage()));
        System.out.println(userDTO);
        return userDTO;
    }

}