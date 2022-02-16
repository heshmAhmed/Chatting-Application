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
    private Connection connection;
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
    public boolean checkUserPhone(String number) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where phone_number = ?");
        preparedStatement.setString(1, number);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUserEmail(String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ?");
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean insertUser(UserEntity userEntity) {
        int status = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into users " +
                    "(phone_number ,username,email,gender,country,date_of_birth,password )values (?,?,?,?,?,?,?)");

            preparedStatement.setString(1, userEntity.getPhoneNumber());
            preparedStatement.setString(2, userEntity.getUsername());
            preparedStatement.setString(3, userEntity.getEmail());
            preparedStatement.setString(4, userEntity.getGender());
            preparedStatement.setString(5, userEntity.getCountry().name());
            preparedStatement.setDate(6, userEntity.getDateOfBirth());
            preparedStatement.setString(7, userEntity.getPassword());
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (status > 0)
            return true;

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
