package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IContactRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;
import gov.iti.jets.server.repository.util.ResultSetMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactRepoImpl implements IContactRepository {

    private Connection connection;
    private final static ContactRepoImpl contactRepo = new ContactRepoImpl();
    private final ResultSetMapper mapper = ResultSetMapper.getInstance();

    public static ContactRepoImpl getInstance() {
        return contactRepo;
    }

    private ContactRepoImpl() {
        try {
            connection = DataSourceFactory.getInstance().getConnection();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    @Override
    public List<UserEntity> getUserContacts(String phoneNumber) {
        List<UserEntity> contacts =new ArrayList<>();
        Optional<UserEntity> userEntity = Optional.empty();
        String query = "select d.phone_number, d.username, d.email, d.image, d.gender,\n" +
                " d.country, d.date_of_birth, d.bio, d.user_status ,d.pass\n" +
                "from users u inner join user_contacts us\n" +
                "on u.phone_number = us.user_number\n" +
                "inner join users d on us.contact_number = d.phone_number\n" +
                "where u.phone_number = ? ;";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                userEntity = mapper.mapToUserEntity(resultSet);
                contacts.add(userEntity.orElseThrow());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contacts;
    }
}
