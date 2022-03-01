package gov.iti.jets.server;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        try {
            ServerApplication.main(args);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
