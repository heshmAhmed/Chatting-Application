package gov.iti.jets.server.repository.util;

import gov.iti.jets.server.repository.entity.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ResultSetMapper {
    private static final ResultSetMapper mapper = new ResultSetMapper();
    private ResultSetMapper() {}

    public static ResultSetMapper getInstance() {
        return mapper;
    }

    public Optional<UserEntity> mapToUserEntity(ResultSet resultSet) {
        Optional<UserEntity> userEntityOptional = Optional.empty();
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setPhoneNumber(resultSet.getString("phone_number"));
            userEntity.setUsername(resultSet.getString("username"));
            userEntity.setEmail(resultSet.getString("email"));
            userEntity.setPassword(resultSet.getString("pass"));
            userEntity.setImage(resultSet.getString("image"));
            userEntity.setGender(resultSet.getString("gender"));
            userEntity.setCountry(resultSet.getString("country"));
            userEntity.setDateOfBirth(resultSet.getDate("date_of_birth").getTime());
            userEntity.setBio(resultSet.getString("bio"));
            userEntity.setStatus(resultSet.getString("user_status"));
            userEntityOptional = Optional.of(userEntity);
         } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntityOptional;
    }


}
