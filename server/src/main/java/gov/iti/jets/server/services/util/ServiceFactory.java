package gov.iti.jets.server.services.util;

import gov.iti.jets.server.services.impls.*;
import gov.iti.jets.server.services.interfaces.*;

public class ServiceFactory {
    private final static ServiceFactory serviceFactory = new ServiceFactory();

    private ServiceFactory() {}
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
    public IGroupService getGroupService() { return GroupService.getInstance(); }
    public MessageServiceImpl getMessageService() {return MessageServiceImpl.getInstance();}
}
