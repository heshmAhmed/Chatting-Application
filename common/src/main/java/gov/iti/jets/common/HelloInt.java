package gov.iti.jets.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInt extends Remote {
    String sayHello(String name) throws RemoteException;
}