package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;
import gov.iti.jets.server.repository.util.ResultSetMapper;
import java.sql.*;
import java.util.Optional;

public class UserRepoImpl implements IUserRepository {
    private Connection connection;
    private final static UserRepoImpl userRepo = new UserRepoImpl();
    private final ResultSetMapper resultSetMapper = ResultSetMapper.getInstance();


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
    public Optional<UserEntity> findUserByNumber(String phoneNumber) {
        PreparedStatement preparedStatement = null;
        Optional<UserEntity> optionalUserEntity = Optional.empty();
        try {
            preparedStatement = connection.prepareStatement("select * from users where phone_number = ?");
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            optionalUserEntity = resultSetMapper.mapToUserEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalUserEntity;
    }

    @Override
    public boolean isPhoneNumberExist(String phoneNumber) {
        boolean found = false;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select phone_number from users where phone_number = ?");
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            found = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }

    @Override
    public boolean isEmailExist(String email) {
        boolean found = false;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select email from users where email = ?");
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            found = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }

    @Override
    public boolean insertUser(UserEntity userEntity) {
        int rowsInserted = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users " +
                    "(phone_number ,username,email,gender,country,date_of_birth,pass )values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, userEntity.getPhoneNumber());
            preparedStatement.setString(2, userEntity.getUsername());
            preparedStatement.setString(3, userEntity.getEmail());
            preparedStatement.setString(4, userEntity.getGender());
            preparedStatement.setString(5, userEntity.getCountry());
            preparedStatement.setDate(6, new Date(userEntity.getDateOfBirth()));
            preparedStatement.setString(7, userEntity.getPassword());
            rowsInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted > 0;
    }

    @Override
    public boolean deleteUser(String phoneNumber) {
        return false;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        return false;
    }
}
