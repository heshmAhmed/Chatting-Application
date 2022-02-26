package gov.iti.jets.server.services.impls;

import gov.iti.jets.server.repository.interfaces.IStatisticsRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IStaticsService;
import java.util.Map;

public class StatisticServiceImpl implements IStaticsService {
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IStatisticsRepository statisticsRepo = repoFactory.getStatisticsRepo();

    private final static StatisticServiceImpl statisticService =  new StatisticServiceImpl();

    private StatisticServiceImpl(){

    }

    public static StatisticServiceImpl getInstance() {
        return statisticService;
    }


    @Override
    public Map<String, Integer> getGenderStatistic() {
        return statisticsRepo.getUsersByGender();
    }

    @Override
    public Map<String, Integer> getStatusStatistic() {
        return statisticsRepo.getUsersByStatus();
    }

    @Override
    public Map<String, Integer> getCountryStatistic() {
        return statisticsRepo.getUserByCounty();
    }

}
