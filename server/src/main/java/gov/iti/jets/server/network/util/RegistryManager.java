package gov.iti.jets.server.network.util;

import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.server.network.RemoteLoginServiceImpl;
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
            IRemoteLoginService iRemoteLoginService = (IRemoteLoginService) new RemoteLoginServiceImpl();
            registry.rebind("RemoteLoginService", iRemoteLoginService);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
