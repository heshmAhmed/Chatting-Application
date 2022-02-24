package gov.iti.jets.client.network.impls;

import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.InvitationsListHelper;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.common.dtos.MessageDTO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCallbackImpl extends UnicastRemoteObject implements IClientCallback, Serializable {

    ContactListHelper contactListHelper = ContactListHelper.getInstance();
    ModelFactory modelFactory = ModelFactory.getInstance();
    InvitationsListHelper invitationsListHelper = InvitationsListHelper.getInstance();

    public ClientCallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void receiveMessage(MessageDTO messageDTO) throws RemoteException {
        System.out.println("receiveMessage invoked");
        contactListHelper.addMessageToList(messageDTO);
    }

    @Override
    public void receiveInvitation(InvitationDTO invitationDTO) throws RemoteException {
        System.out.println("receive invitation invoked");
        invitationsListHelper.loadInvitation(invitationDTO);
    }

    @Override
    public void receiveNewContact(ContactDTO contactDTO) throws RemoteException {
        System.out.println("recieved new contact");
       contactListHelper.loadContact(modelFactory.mapUserModelToDTO(contactDTO));
    }


}
