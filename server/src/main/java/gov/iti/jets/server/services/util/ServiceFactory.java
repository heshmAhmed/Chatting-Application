package gov.iti.jets.server.services.util;

import gov.iti.jets.server.services.impls.ContactServiceImpl;
import gov.iti.jets.server.services.impls.LoginServiceImpl;
import gov.iti.jets.server.services.impls.ProfileServiceImpl;
import gov.iti.jets.server.services.impls.RegistrationServiceImpl;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.interfaces.ILoginService;
import gov.iti.jets.server.services.interfaces.IProfileService;
import gov.iti.jets.server.services.interfaces.IRegistrationService;

public class ServiceFactory {
    private final static ServiceFactory serviceFactory = new ServiceFactory();

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    public IContactService getContactService() {
        return ContactServiceImpl.getInstance();
    }
    public IRegistrationService registrationService() {
        return RegistrationServiceImpl.getInstance();
    }
    public ILoginService loginService(){
        return  LoginServiceImpl.getInstance();
    }
    public IProfileService getProfileService() { return ProfileServiceImpl.getInstance(); }

}
