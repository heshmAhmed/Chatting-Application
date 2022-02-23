package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;

import java.rmi.RemoteException;
import java.util.List;

public interface IContactService {
    public List<ContactDTO> getAllUserContacts(String userId);
    boolean sendInvitation(InvitationDTO invitationDTO)throws RemoteException;
    void acceptInvitation(InvitationDTO  invitationDTO)throws RemoteException;
    void  ignoreInvitation (InvitationDTO invitationDTO)throws RemoteException;
    List<InvitationDTO> getAllUserInvitation(String userId)throws RemoteException;

}

