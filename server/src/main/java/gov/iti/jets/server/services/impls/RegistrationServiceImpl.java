package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IRegistrationService;
import gov.iti.jets.server.services.mapper.UserEntityMapper;
import gov.iti.jets.server.services.util.HashingFactory;

import java.sql.SQLOutput;
import java.util.Optional;

public class RegistrationServiceImpl implements IRegistrationService {
    private final static RegistrationServiceImpl registrationService = new RegistrationServiceImpl();
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IUserRepository userRepo = repoFactory.getUserRepo();
    private final HashingFactory hashingFactory = HashingFactory.getInstance();

    private RegistrationServiceImpl() {

    }

    public static RegistrationServiceImpl getInstance() {
        return registrationService;
    }

    @Override
    public boolean checkPhoneNumber(String phoneNumber) {
        return userRepo.isPhoneNumberExist(phoneNumber);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.isEmailExist(email);
    }

    @Override
    public boolean addNewUser(UserDTO userDTO) {
        String hashedPassword = hashingFactory.hashPassword(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);
        UserEntity user = UserEntityMapper.INSTANCE.userDTOToEntity(userDTO);
        return userRepo.insertUser(user);
    }
}
