package gov.iti.jets.server.repository.util;

import gov.iti.jets.server.repository.impls.ContactRepoImpl;
import gov.iti.jets.server.repository.impls.InvitationRepoImpl;
import gov.iti.jets.server.repository.impls.StatisticsRepoImpl;
import gov.iti.jets.server.repository.impls.UserRepoImpl;
import gov.iti.jets.server.repository.interfaces.IContactRepository;
import gov.iti.jets.server.repository.interfaces.IInvitationRepository;
import gov.iti.jets.server.repository.interfaces.IStatisticsRepository;
import gov.iti.jets.server.repository.interfaces.IUserRepository;

public class RepoFactory {
    private final static RepoFactory repoFactory = new RepoFactory();

    private RepoFactory() {}

    public static RepoFactory getInstance() {
        return repoFactory;
    }
    
    public  IUserRepository getUserRepo() {
        return UserRepoImpl.getInstance();
    }

    public IContactRepository getContactRepo(){


        return ContactRepoImpl.getInstance();
    }

    public IInvitationRepository getInvitationRepo() {
        return InvitationRepoImpl.getInstance();
    }

    public IStatisticsRepository getStatisticsRepo(){
        return StatisticsRepoImpl.getInstance();
    }
}
