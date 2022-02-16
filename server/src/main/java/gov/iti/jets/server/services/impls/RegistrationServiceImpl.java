package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.RegistrationDTO;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.mapper.RegistrationMapper;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IRegistrationService;
import gov.iti.jets.server.services.util.HashPassword;
import java.sql.SQLException;


public class RegistrationServiceImpl implements IRegistrationService {
    private  final RepoFactory repoFactory=RepoFactory.getInstance();
    private  final  IUserRepository userRepo = repoFactory.getUserRepo();

    @Override
    public boolean isPhoneExisted(String userPhone) {

        boolean founded = false;
         try {
            founded = userRepo.checkUserPhone(userPhone);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( "in service"+founded);
        return founded;
    }

    @Override
    public boolean isEmailExisted(String email) {
        boolean founded = false;
        try {
            founded = userRepo.checkUserEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println( "in service"+founded);
        return founded;

    }

    @Override
    public boolean createNewUser(RegistrationDTO registrationDTO) {

        HashPassword.getInstance().hashPassword(registrationDTO.getPassword());
        UserEntity user= RegistrationMapper.REGISTRATION_MAPPER.USER(registrationDTO);


      // userRepo.insertUser(user);

        return false;
    }
}
