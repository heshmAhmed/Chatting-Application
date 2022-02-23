package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.common.server.IRemoteContactService;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.util.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteContactServiceImpl extends UnicastRemoteObject implements IRemoteContactService {
    private final IContactService contactService = ServiceFactory.getInstance().getContactService();

    public RemoteContactServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ContactDTO> getAllUserContacts(String phoneNumber) throws RemoteException {
        return contactService.getAllUserContacts(phoneNumber);
    }

    @Override
    public boolean sendInvitation(InvitationDTO invitationDTO) throws RemoteException {
        return contactService.sendInvitation(invitationDTO);
    }

    @Override
    public void acceptInvitation(InvitationDTO invitationDTO) throws RemoteException {

        contactService.acceptInvitation(invitationDTO);
    }

    @Override
    public void ignoreInvitation(InvitationDTO invitationDTO) throws RemoteException {
        contactService.ignoreInvitation(invitationDTO);

    }

    @Override
    public List<InvitationDTO> getAllUserInvitation(String userNumber) throws RemoteException {
        List<InvitationDTO> invitationList = new ArrayList<>();
        invitationList = contactService.getAllUserInvitation(userNumber);

        return invitationList;
    }



}
