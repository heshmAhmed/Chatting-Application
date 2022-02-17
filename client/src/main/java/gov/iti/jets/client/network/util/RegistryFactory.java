package gov.iti.jets.client.network.util;

import gov.iti.jets.common.server.IRemoteLoginService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistryFactory {
    private static Registry registry;
    private static RegistryFactory registryFactory = new RegistryFactory();

    private RegistryFactory(){
        try {
            registry = LocateRegistry.getRegistry(5000);
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
//            System.out.println("lookup exeption");
            e.printStackTrace();
        }
        return remoteLoginService;
    }


}
