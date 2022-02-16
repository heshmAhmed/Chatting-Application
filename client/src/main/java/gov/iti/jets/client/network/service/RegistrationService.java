package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;

import gov.iti.jets.common.server.IRemoteRegistrationService;

import java.rmi.RemoteException;

public class RegistrationService {

    private static RegistrationService registrationService;
    private static RegistryFactory registryFactory = RegistryFactory.getInstance();
    private IRemoteRegistrationService remoteRegistrationService = registryFactory.getRemoteRegistrationService();

    private RegistrationService() {
    }

    public static RegistrationService getInstance() {
        if (registrationService == null)
            registrationService = new RegistrationService();
        return registrationService;
    }

    public boolean checkPhoneNumber(String userPhoneNumber) {
        boolean founded = false;
        try {
            founded = remoteRegistrationService.isPhoneRegistered(userPhoneNumber);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return founded;
    }


}
