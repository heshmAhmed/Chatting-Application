package gov.iti.jets.client.network.impls;

import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.util.*;
import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.dtos.Status;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCallbackImpl extends UnicastRemoteObject implements IClientCallback, Serializable {
    ContactListHelper contactListHelper = ContactListHelper.getInstance();
    ModelFactory modelFactory = ModelFactory.getInstance();
    InvitationsListHelper invitationsListHelper = InvitationsListHelper.getInstance();
    GroupListHelper groupListHelper = GroupListHelper.getInstance();

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
        ContactModel contactModel = modelFactory.mapContactModelToDTO(contactDTO);
        modelFactory.addToContactModels(contactModel);
        contactListHelper.loadContact(contactModel);
    }

    @Override
    public void receiveStatusChange(String phoneNumber, Status status) throws RemoteException {
        System.out.println("status changed for user " + phoneNumber + " with status " + status);
        contactListHelper.changeContactStatus(phoneNumber, status);
    }
    @Override
    public void receiveGroupMessage(MessageDTO messageDTO) throws RemoteException {
        System.out.println(messageDTO);
        groupListHelper.addMessageToList(messageDTO);

    }

    @Override
    public void receiveAnnouncement(String announcement){
        Popups.receiveNotification(announcement);
    }


}
