package gov.iti.jets.server.network.util;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.server.*;
import gov.iti.jets.server.network.*;
import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import gov.iti.jets.common.server.IRemoteProfileService;
import gov.iti.jets.common.server.IRemoteRegistrationService;
import gov.iti.jets.server.network.RemoteLoginServiceImpl;
import gov.iti.jets.server.network.RemoteMessageHandelImpl;
import gov.iti.jets.server.network.RemoteProfileServiceImpl;
import gov.iti.jets.server.network.RemoteRegistrationServiceImpl;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class RegistryManager {
    private final static RegistryManager registryManager = new RegistryManager();
    private Registry registry;
    private ServerUtil serverUtil = ServerUtil.getInstance();
    private IRemoteLoginService iRemoteLoginService;
    private IRemoteRegistrationService iRemoteRegistrationService;
    private IRemoteMessageHandler iRemoteMessageHandler;
    private IRemoteProfileService iRemoteProfileService;
    private IRemoteContactService iRemoteContactService;
    private IRemoteGroupService iRemoteGroupService;
    private final int port = 6000;

    private RegistryManager() {}

    public static RegistryManager getInstance() {
        return registryManager;
    }

    public void startServer() {
        createRegistry();
        publishServices();
        System.out.println("server is up");
    }

    private void createRegistry() {
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

    public void stopServer() {
        try {
            unPublishServices();
            unExportRemoteServices();
           // UnicastRemoteObject.unexportObject(registry, true);
           // registry = null;
            System.out.println("Server is down");
        } catch (NoSuchObjectException e) {
            e.printStackTrace();
        }
    }

    private void publishServices() {
        try {
            iRemoteLoginService = new RemoteLoginServiceImpl();
            iRemoteRegistrationService = new RemoteRegistrationServiceImpl();
            iRemoteMessageHandler = new RemoteMessageHandelImpl();
            iRemoteProfileService = new RemoteProfileServiceImpl();
            iRemoteContactService = new RemoteContactServiceImpl();
            iRemoteGroupService = new RemoteGroupServiceImpl();
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

    private void unPublishServices() {
        if (registry != null) {
            try {
                String[] services = registry.list();
                for (String name : services) {
                    System.out.println(name);
                }
                for (String service : services) {
                    this.registry.unbind(service);
                   System.out.println("================== RMI Registry Service " + service + " Unbounded ============");
                }
                for (Map.Entry<String, IClientCallback> entry : serverUtil.onlineUsers.entrySet())
                    entry.getValue().serverDisconnected();
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("===================RMI Registry Connection Already Stopped=============");
        }
        serverUtil.clearMap();
    }

    private void unExportRemoteServices() throws NoSuchObjectException {
        UnicastRemoteObject.unexportObject(iRemoteContactService,true);
        UnicastRemoteObject.unexportObject(iRemoteGroupService, true);
        UnicastRemoteObject.unexportObject(iRemoteLoginService,true);
        UnicastRemoteObject.unexportObject(iRemoteProfileService, true);
        UnicastRemoteObject.unexportObject(iRemoteRegistrationService,true);
        UnicastRemoteObject.unexportObject(iRemoteMessageHandler, true);
    }

}
