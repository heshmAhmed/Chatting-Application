package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.UserEntity;
import gov.iti.jets.server.repository.interfaces.IContactRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactRepoImpl implements IContactRepository {

    private Connection connection;
    private final static ContactRepoImpl contactRepo = new ContactRepoImpl();

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
    public List<UserEntity> getUserContacts(String userId) {
        List<UserEntity> contacts = null;
        String query ="";

        return contacts;
    }
}
