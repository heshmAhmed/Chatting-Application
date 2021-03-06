package gov.iti.jets.server.repository.impls;

import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;
import gov.iti.jets.server.repository.util.ResultSetMapper;
import java.sql.*;
import java.util.Optional;

public class UserRepoImpl implements IUserRepository {
    private final static UserRepoImpl userRepo = new UserRepoImpl();
    private final ResultSetMapper resultSetMapper = ResultSetMapper.getInstance();
    private UserRepoImpl() {}

    public static UserRepoImpl getInstance() {
        return userRepo;
    }

    @Override
    public Optional<UserEntity> findUserByNumber(String phoneNumber) {
        PreparedStatement preparedStatement = null;
        Optional<UserEntity> optionalUserEntity = Optional.empty();
        try(Connection connection = DataSourceFactory.getInstance().getConnection()) {
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
        try (Connection connection = DataSourceFactory.getInstance().getConnection()) {
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
        try (Connection connection = DataSourceFactory.getInstance().getConnection()) {
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
        try (Connection connection = DataSourceFactory.getInstance().getConnection()){
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
        int rowUpdated = 0;
        try (Connection connection = DataSourceFactory.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("update users set\n" +
                    "bio = ?, username = ?, country = ?, date_of_birth = ? where phone_number = ?");
            preparedStatement.setString(1, userEntity.getBio());
            preparedStatement.setString(2, userEntity.getUsername());
            preparedStatement.setString(3, userEntity.getCountry());
            preparedStatement.setDate(4, new Date(userEntity.getDateOfBirth()));
            preparedStatement.setString(5, userEntity.getPhoneNumber());
            rowUpdated = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated > 0;
    }

    @Override
    public boolean updateStatus(String phoneNumber, Status status) {
        PreparedStatement preparedStatement;
        boolean updated = false;
        try (Connection connection = DataSourceFactory.getInstance().getConnection()){
            preparedStatement = connection.prepareStatement("update users set user_status = ? where phone_number = ?");
            preparedStatement.setString(1, status.toString());
            preparedStatement.setString(2, phoneNumber);
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public boolean updateUserImage(String phoneNumber, String imgPath) {
        PreparedStatement preparedStatement;
        boolean updated = false;
        try (Connection connection = DataSourceFactory.getInstance().getConnection()) {
            preparedStatement = connection.prepareStatement("update users set image = ? where phone_number = ?");
            preparedStatement.setString(1, imgPath);
            preparedStatement.setString(2, phoneNumber);
            updated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

}
