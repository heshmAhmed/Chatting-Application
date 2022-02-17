package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;
import gov.iti.jets.server.repository.util.ResultSetMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class UserRepoImpl implements IUserRepository {
    private  Connection connection;
    private final static UserRepoImpl userRepo = new UserRepoImpl();
    private final ResultSetMapper mapper = ResultSetMapper.getInstance();

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
    public Optional<UserEntity> findUserByNumber(String number) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from users where phone_number = ?");
            preparedStatement.setString(1, number);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapper.mapToUserEntity(Objects.requireNonNull(resultSet));
    }

    @Override
    public boolean insertUser(UserEntity userEntity) {
        return false;
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
