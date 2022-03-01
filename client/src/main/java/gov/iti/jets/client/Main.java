package gov.iti.jets.client;

import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) {
        try {
            ClientApplication.main(args);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
