package gov.iti.jets.server.repository.util;

import gov.iti.jets.server.repository.impls.UserRepoImpl;
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
}
