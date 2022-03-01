package gov.iti.jets.server.repository.impls;

import gov.iti.jets.server.repository.interfaces.IStatisticsRepository;
import gov.iti.jets.server.repository.util.DataSourceFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StatisticsRepoImpl implements IStatisticsRepository  {
    private final static StatisticsRepoImpl statisticsRepo = new StatisticsRepoImpl();

    private StatisticsRepoImpl() {}

    public static StatisticsRepoImpl getInstance() {
        return statisticsRepo;
    }

    @Override
    public Map<String, Integer> getUsersByGender() {
        Map<String,Integer>usersNumByGenderMap = new HashMap<>();
        String query = "select gender ,count(phone_number)  \n" +
                "from users \n" +
                "group by  (gender);";

        try (Connection connection = DataSourceFactory.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
               usersNumByGenderMap.put(resultSet.getString(1),resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersNumByGenderMap;
    }


    @Override
    public Map<String, Integer> getUsersByStatus() {
        Map<String,Integer>usersStatusMap = new HashMap<>();
        String query = "SELECT user_status ,COUNT(*)\n" +
                "FROM users\n" +
                "GROUP BY user_status ;";

        try (Connection connection = DataSourceFactory.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usersStatusMap.put(resultSet.getString(1),resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersStatusMap;
    }

    @Override
    public Map<String, Integer> getUserByCounty() {
        Map<String,Integer>usersCountyMap = new HashMap<>();
        String query = "SELECT country ,COUNT(*)\n" +
                "FROM users\n" +
                "GROUP BY country;";

        try (Connection connection = DataSourceFactory.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usersCountyMap.put(resultSet.getString(1),resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersCountyMap;
    }

}

