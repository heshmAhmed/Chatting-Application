package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;

import java.sql.SQLException;
import java.util.Optional;

public class UserRepoImpl implements IUserRepository {
    @Override
    public Optional<UserEntity> findUserByEmail(String email) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<UserEntity> findUserByNumber(String number) throws SQLException {
        return Optional.empty();
    }

    @Override
    public boolean insertUser(UserEntity userEntity) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteUser(String phoneNumber) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) throws SQLException {
        return false;
    }
}
