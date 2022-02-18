package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.server.repository.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    public Optional<UserEntity> findUserByNumber(String phoneNumber);
    public boolean isPhoneNumberExist(String phoneNumber);
    public boolean isEmailExist(String email);
    public boolean insertUser(UserEntity userEntity);
    public boolean deleteUser(String phoneNumber);
    public boolean updateUser(UserEntity userEntity);
}
