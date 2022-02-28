package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.server.repository.entity.UserEntity;
import java.util.Optional;

public interface IUserRepository {
    Optional<UserEntity> findUserByNumber(String phoneNumber);
    boolean isPhoneNumberExist(String phoneNumber);
    boolean isEmailExist(String email);
    boolean insertUser(UserEntity userEntity);
    boolean deleteUser(String phoneNumber);
    boolean updateUser(UserEntity userEntity);
    boolean updateStatus(String phoneNumber, Status status);
    boolean updateUserImage(String phoneNumber, String imgPath);
}
