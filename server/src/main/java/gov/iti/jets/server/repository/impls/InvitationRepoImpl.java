package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.InvitationEntity;
import gov.iti.jets.server.repository.interfaces.IInvitationRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class InvitationRepoImpl implements IInvitationRepository {
    private Connection connection;
    private final static InvitationRepoImpl invitationRepo = new InvitationRepoImpl();

    private InvitationRepoImpl() {
        try {
            connection = DataSourceFactory.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static InvitationRepoImpl getInstance() {
        return invitationRepo;
    }

    @Override
    public boolean alreadyInvitedMe(String receiverPhoneNumber, String senderPhoneNumber) {
        String query = "select * \n" +
                " from user_invitations \n" +
                " where sender_number = ?  and reciever_number = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, receiverPhoneNumber);
            statement.setString(2, senderPhoneNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteInvitation(String receiverPhoneNumber, String senderPhoneNumber) {
        String query = "DELETE FROM user_invitations \n" +
                "WHERE sender_number= ? and reciever_number= ? ;";
        int row = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, senderPhoneNumber);
            statement.setString(2, receiverPhoneNumber);
            row = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public boolean addInvitation(String receiverPhoneNumber, String senderPhoneNumber, long date) {
        String query = "INSERT INTO user_invitations " +
                "(sender_number, reciever_number, date) VALUES (?, ?, ?);";
        int rowsInserted = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, senderPhoneNumber);
            statement.setString(2, receiverPhoneNumber);
            statement.setDate(3, new Date(date));
            rowsInserted = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted > 0;
    }

    @Override
    public List<InvitationEntity> getAllUserInvitations(String userPhoneNumber) {
        return null;
    }
}
