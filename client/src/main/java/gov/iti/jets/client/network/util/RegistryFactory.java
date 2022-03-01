package gov.iti.jets.client.network.util;

import gov.iti.jets.client.presentation.util.Popups;
import gov.iti.jets.common.server.*;
import io.github.palexdev.materialfx.controls.MFXIconWrapper;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.Scanner;

public class RegistryFactory {
    private Registry registry;
    private final static String configFilePath = System.getProperty("user.dir") + "/network.properties";
    private static final RegistryFactory registryFactory = new RegistryFactory();

    public static RegistryFactory getInstance() {
        return registryFactory;
    }

    private Properties readNetworkProperties() {
        Properties properties = new Properties();
        try (InputStream fileInputStream = new FileInputStream(configFilePath);) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private RegistryFactory(){
        Properties properties = readNetworkProperties();
        String host = properties.getProperty("host");
        int port = Integer.parseInt(properties.getProperty("port"));
        try {
            registry = LocateRegistry.getRegistry(host, port);
        } catch (RemoteException e) {

            e.printStackTrace();
        }
    }

    public IRemoteLoginService getRemoteLoginService() {
        IRemoteLoginService remoteLoginService = null;
        try {
            remoteLoginService = (IRemoteLoginService) registry.lookup("RemoteLoginService");
        } catch (RemoteException | NotBoundException e) {

            Popups.alert(" 😴 Server is DOWN!!!");
//            Thread.sleep();
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

    public IRemoteContactService getRemoteContactService() {
        IRemoteContactService iRemoteContactService = null;
        try {
            iRemoteContactService = (IRemoteContactService) registry.lookup("RemoteContactService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return iRemoteContactService;
    }

    public IRemoteGroupService getRemoteGroupService() {
        IRemoteGroupService iRemoteGroupService = null;
        try {
            iRemoteGroupService = (IRemoteGroupService) registry.lookup("RemoteGroupService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return iRemoteGroupService;
    }
}
