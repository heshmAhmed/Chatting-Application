package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.server.repository.entity.UserEntity;

import java.sql.SQLException;
import java.util.Optional;

public interface IUserRepository {
    public Optional<UserEntity> findUserByEmail(String email) throws SQLException;
    public Optional<UserEntity> findUserByNumber(String number) throws SQLException;
    public boolean insertUser(UserEntity userEntity) throws SQLException;
    public boolean deleteUser(String phoneNumber) throws SQLException;
    public boolean updateUser(UserEntity userEntity) throws SQLException;
    public boolean checkUserPhone(String number) throws SQLException;
    public boolean checkUserEmail(String email) throws SQLException;
}
