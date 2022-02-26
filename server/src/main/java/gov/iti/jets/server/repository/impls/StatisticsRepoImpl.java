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
    private Connection connection;
    private final static StatisticsRepoImpl statisticsRepo = new StatisticsRepoImpl();

    private StatisticsRepoImpl() {
        try {
            connection = DataSourceFactory.getInstance().getConnection();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public static StatisticsRepoImpl getInstance() {
        return statisticsRepo;
    }

    @Override
    public Map<String, Integer> getUsersByGender() {
        Map<String,Integer>usersNumByGenderMap = new HashMap<>();
        String query = "select gender ,count(phone_number)  \n" +
                "from users \n" +
                "group by  (gender);";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
               usersNumByGenderMap.put(resultSet.getString(1),resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                try {
                    connection.close();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
        }
        return usersNumByGenderMap;
    }


    @Override
    public Map<String, Integer> getUsersByStatus() {
        Map<String,Integer>usersStatusMap = new HashMap<>();
        String query = "SELECT user_status ,COUNT(*)\n" +
                "FROM users\n" +
                "GROUP BY user_status ;";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usersStatusMap.put(resultSet.getString(1),resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return usersStatusMap;
    }

    @Override
    public Map<String, Integer> getUserByCounty() {

        Map<String,Integer>usersCountyMap = new HashMap<>();
        String query = "SELECT country ,COUNT(*)\n" +
                "FROM users\n" +
                "GROUP BY country;";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usersCountyMap.put(resultSet.getString(1),resultSet.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return usersCountyMap;

    }

}

