package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.entity.GroupEntity;
import gov.iti.jets.server.repository.interfaces.IGroupChatRepo;
import gov.iti.jets.server.repository.util.DataSourceFactory;
import gov.iti.jets.server.repository.util.ResultSetMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GroupChatImpl implements IGroupChatRepo {
    private final static GroupChatImpl groupChatImp = new GroupChatImpl();
    private Connection connection;
    private final ResultSetMapper resultSetMapper = ResultSetMapper.getInstance();

    private GroupChatImpl() {
        try {
            this.connection = DataSourceFactory.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static GroupChatImpl getInstance() {
        return groupChatImp;
    }

    @Override
    public List<GroupEntity> getAllGroups() {
        return new ArrayList<>();
    }

    @Override
    public Optional<GroupEntity> findGroup(long groupId) {
        return Optional.empty();
    }

    @Override
    public List<String> getGroupUsers(long groupId) {
        PreparedStatement preparedStatement;
        List<String> ids = new ArrayList<>();
        try {
            preparedStatement =
                    connection.prepareStatement("select user_number from group_users where group_id = ?");
            preparedStatement.setLong(1, groupId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                ids.add(resultSet.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    @Override
    public boolean addUserToGroup(String phoneNumber, long groupId) {
        boolean inserted = false;
        PreparedStatement preparedStatement;
        try {
            preparedStatement =
                    connection.prepareStatement("insert into group_users(group_id, user_number) values(?,?)");
            preparedStatement.setLong(1, groupId);
            preparedStatement.setString(2, phoneNumber);
            inserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inserted;
    }

    @Override
    public long createGroup(GroupEntity groupEntity) {
        PreparedStatement preparedStatement;
        long key = 0;
        try {
            preparedStatement =
                    connection.prepareStatement("insert into chat_groups(group_name, group_img) values(?,?)",
                            Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, groupEntity.getName());
            preparedStatement.setString(2, groupEntity.getImg());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            key = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return key;
    }

    @Override
    public List<GroupEntity> getUserGroups(String phoneNumber) {
        PreparedStatement preparedStatement;
        List<GroupEntity> groupEntities = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select  id, group_name, group_img from \n" +
                    "group_users inner join chat_groups\n" +
                    "on group_id = id\n" +
                    "where user_number = ?;");
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                groupEntities.add(resultSetMapper.mapToGroupEntity(resultSet).orElseThrow());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupEntities;
    }

}
