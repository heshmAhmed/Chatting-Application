package gov.iti.jets.server.network.util;

import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import gov.iti.jets.common.server.IRemoteRegistrationService;
import gov.iti.jets.server.network.RemoteLoginServiceImpl;
import gov.iti.jets.server.network.RemoteMessageHandelImpl;
import gov.iti.jets.server.network.RemoteRegistrationServiceImpl;

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

            registry.rebind("RemoteLoginService", iRemoteLoginService);
            registry.rebind("RemoteRegistrationService", iRemoteRegistrationService);
            registry.rebind("RemoteMessageHandler", iRemoteMessageHandler);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
