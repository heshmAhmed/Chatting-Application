package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IRegistrationService;
import gov.iti.jets.server.services.mapper.UserEntityMapper;
import gov.iti.jets.server.services.mapper.UserEntityMapperImpl;
import gov.iti.jets.server.services.util.HashingFactory;

import java.sql.SQLOutput;
import java.util.Optional;

public class RegistrationServiceImpl implements IRegistrationService {
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IUserRepository userRepo = repoFactory.getUserRepo();
    private final HashingFactory hashingFactory = HashingFactory.getInstance();
    // validation
    /*
        phone_number -> null
        phone_number -> ""
        phone_number "dsd0555s"
     */
    @Override
    public boolean checkPhoneNumber(String phoneNumber) {
        return userRepo.isPhoneNumberExist(phoneNumber);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.isEmailExist(email);
    }

    @Override
    public boolean addNewUser(UserDTO userDTO){
        String hashedPassword = hashingFactory.hashPassword(userDTO.getPassword());

        UserEntity user = UserEntityMapper.INSTANCE.userDTOToEntity(userDTO);
        userRepo.insertUser(user);


        System.err.print("RemoteService");
        return true;

//      RegistrationDTO registrationDTO1
//      UserEntity user = RegistrationMapper.REGISTRATION_MAPPER.USER(registrationDTO);
//      user.setPassword(hashedPassword);
//        UserEntity userEntity = UserEntityMapper.INSTANCE.userDTOToEntity();
//        userRepo.insertUser(userEntity);


        //userRepo.insertUser(userDTO);
      //  return false;
    }
}
