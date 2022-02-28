package gov.iti.jets.server.network.util;

import gov.iti.jets.common.server.*;
import gov.iti.jets.server.network.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryManager {
    private final static RegistryManager registryManager = new RegistryManager();
    private Registry registry;
    private RegistryManager() {}

    public static RegistryManager getInstance() {
        return registryManager;
    }

    public void createRegistry(int port) {
        try {
            registry = LocateRegistry.createRegistry(port);
        } catch (RemoteException e) {
            try {
                registry = LocateRegistry.getRegistry(port);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void publishServices() {
        try {

            IRemoteLoginService iRemoteLoginService = new RemoteLoginServiceImpl();
            IRemoteRegistrationService iRemoteRegistrationService = new RemoteRegistrationServiceImpl();
            IRemoteMessageHandler iRemoteMessageHandler = new RemoteMessageHandelImpl();
            IRemoteProfileService iRemoteProfileService = new RemoteProfileServiceImpl();
            IRemoteContactService iRemoteContactService = new RemoteContactServiceImpl();
            IRemoteGroupService iRemoteGroupService = new RemoteGroupServiceImpl();

            registry.rebind("RemoteLoginService", iRemoteLoginService);
            registry.rebind("RemoteRegistrationService", iRemoteRegistrationService);
            registry.rebind("RemoteMessageHandler", iRemoteMessageHandler);
            registry.rebind("RemoteProfileService", iRemoteProfileService);
            registry.rebind("RemoteContactService", iRemoteContactService);
            registry.rebind("RemoteGroupService", iRemoteGroupService);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
