package gov.iti.jets.server.services.impls;

import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.ILoginService;

public class LoginServiceImpl implements ILoginService {
    private final IUserRepository iUserRepository = RepoFactory.getUserRepo();


}
