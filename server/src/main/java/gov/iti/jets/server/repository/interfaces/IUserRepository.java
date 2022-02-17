package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.server.repository.entity.UserEntity;

import java.sql.SQLException;
import java.util.Optional;

public interface IUserRepository {
    public Optional<UserEntity> findUserByNumber(String number);
    public boolean insertUser(UserEntity userEntity);
    public boolean deleteUser(String phoneNumber);
    public boolean updateUser(UserEntity userEntity);
}
