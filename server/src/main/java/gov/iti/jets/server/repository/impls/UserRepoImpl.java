package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

public class UserRepoImpl implements IUserRepository {
    private  Connection connection;
    private final static UserRepoImpl userRepo = new UserRepoImpl();

    private UserRepoImpl() {
        try {
            connection = DataSourceFactory.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static UserRepoImpl getInstance() {
        return userRepo;
    }

    @Override
    public Optional<UserEntity> findUserByEmail(String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        return Optional.of(new UserEntity());
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
