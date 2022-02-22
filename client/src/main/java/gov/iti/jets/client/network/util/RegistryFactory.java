package gov.iti.jets.client.network.util;

import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import gov.iti.jets.common.server.IRemoteProfileService;
import gov.iti.jets.common.server.IRemoteRegistrationService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryFactory {
    private Registry registry;
    private static final RegistryFactory registryFactory = new RegistryFactory();

    private RegistryFactory(){
        try {
            registry = LocateRegistry.getRegistry(2025);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static RegistryFactory getInstance() {
        return registryFactory;
    }

    public IRemoteLoginService getRemoteLoginService() {
        IRemoteLoginService remoteLoginService = null;
        try {
            remoteLoginService = (IRemoteLoginService) registry.lookup("RemoteLoginService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return remoteLoginService;
    }

    public IRemoteRegistrationService getRemoteRegistrationService() {
        IRemoteRegistrationService remoteRegistrationService = null;
        try {
             remoteRegistrationService = (IRemoteRegistrationService) registry.lookup("RemoteRegistrationService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return remoteRegistrationService;
    }


    public IRemoteMessageHandler getRemoteMessageHandler() {
        IRemoteMessageHandler remoteMessageHandler = null;
        try {
            remoteMessageHandler = (IRemoteMessageHandler) registry.lookup("RemoteMessageHandler");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return remoteMessageHandler;
    }

    public IRemoteProfileService getRemoteProfileService() {
        IRemoteProfileService iRemoteProfileService = null;
        try {
            iRemoteProfileService = (IRemoteProfileService) registry.lookup("RemoteProfileService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return iRemoteProfileService;
    }

}
