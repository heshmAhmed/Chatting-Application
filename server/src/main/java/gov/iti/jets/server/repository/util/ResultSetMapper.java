package gov.iti.jets.server.repository.util;

import gov.iti.jets.server.repository.entity.ContactEntity;
import gov.iti.jets.server.repository.entity.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ResultSetMapper {
    private static final ResultSetMapper mapper = new ResultSetMapper();
    private ImageUtility imageUtility = ImageUtility.getInstance();
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
            userEntity.setImage(imageUtility.readImage(resultSet.getString("image")));
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

    public Optional<ContactEntity> mapToContactEntity(ResultSet resultSet) {
        Optional<ContactEntity> contactEntityOptional = Optional.empty();
        try {
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.setPhoneNumber(resultSet.getString("phone_number"));
            contactEntity.setUsername(resultSet.getString("username"));
            contactEntity.setStatus(resultSet.getString("user_status"));
            contactEntity.setBio(resultSet.getString("bio"));
            contactEntity.setImage(imageUtility.readImage(resultSet.getString("image")));
            contactEntityOptional = Optional.of(contactEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactEntityOptional;
    }


}
