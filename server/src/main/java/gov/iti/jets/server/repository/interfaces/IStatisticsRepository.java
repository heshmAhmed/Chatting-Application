package gov.iti.jets.server.repository.interfaces;

import java.util.Map;

public interface IStatisticsRepository {

    Map<String,Integer> getUsersByGender();
    Map<String,Integer> getUsersByStatus();
    Map<String,Integer>getUserByCounty();

}
