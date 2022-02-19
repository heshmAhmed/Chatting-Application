package gov.iti.jets.server.services.util;

import gov.iti.jets.server.services.impls.ContactServiceImpl;
import gov.iti.jets.server.services.impls.LoginServiceImpl;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.interfaces.ILoginService;

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
}
