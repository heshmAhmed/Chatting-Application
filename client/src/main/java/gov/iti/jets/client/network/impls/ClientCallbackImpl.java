package gov.iti.jets.client.network.impls;

import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.MessageDTO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCallbackImpl extends UnicastRemoteObject implements IClientCallback, Serializable {

    ContactListHelper contactListHelper = ContactListHelper.getInstance();

    public ClientCallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void receiveMessage(MessageDTO messageDTO) throws RemoteException {
        System.out.println("receiveMessage invoked");
        contactListHelper.addMessageToList(messageDTO);
    }


}
