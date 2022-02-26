package gov.iti.jets.server.services.interfaces;

import java.util.Map;

public interface IStaticsService {

    Map<String,Integer> getGenderStatistic();
    Map<String,Integer> getStatusStatistic();
    Map<String,Integer>getCountryStatistic();
}
