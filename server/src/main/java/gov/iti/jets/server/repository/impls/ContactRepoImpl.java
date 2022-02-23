package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.ContactEntity;
import gov.iti.jets.server.repository.interfaces.IContactRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;
import gov.iti.jets.server.repository.util.ResultSetMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<ContactEntity> getUserContacts(String phoneNumber) {
        List<ContactEntity> contacts =new ArrayList<>();
        String query = "select d.phone_number, d.username, d.image, \n" +
                " d.bio, d.user_status\n" +
                "from users u inner join user_contacts us\n" +
                "on u.phone_number = us.user_number\n" +
                "inner join users d on us.contact_number = d.phone_number\n" +
                "where u.phone_number = ? ;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 contacts.add(mapper.mapToContactEntity(resultSet).orElseThrow());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean addNewContact(String user1Phone, String user2Phone) {
        String query ="INSERT INTO user_contacts (user_number, contact_number) VALUES (?, ?);";
        int rowsInserted = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user1Phone);
            statement.setString(2, user2Phone);
            rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted > 0;
    }

    @Override
    public ContactEntity getContact(String phoneNumber) {
        ContactEntity entity=new ContactEntity();
        String query="SELECT phone_number,username,image,bio,user_status\n" +
                "FROM users\n" +
                "where phone_number=?;";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, phoneNumber);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
                entity=mapper.mapToContactEntity(resultSet).orElseThrow();

        }catch (SQLException e){

            e.printStackTrace();
        }


        return entity;
    }


}
