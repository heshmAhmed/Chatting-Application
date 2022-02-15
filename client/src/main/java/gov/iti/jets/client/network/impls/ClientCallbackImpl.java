package gov.iti.jets.client.network.impls;

import gov.iti.jets.common.client.IClientCallback;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCallbackImpl extends UnicastRemoteObject implements IClientCallback, Serializable {
    public ClientCallbackImpl() throws RemoteException {
        super();
    }

}
