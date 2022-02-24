package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteContactService extends Remote {
    List<ContactDTO> getAllUserContacts(String userId) throws RemoteException;

    boolean sendInvitation(InvitationDTO invitationDTO) throws RemoteException;

    void acceptInvitation(InvitationDTO invitationDTO) throws RemoteException;

    void ignoreInvitation(InvitationDTO invitationDTO) throws RemoteException;

    List<InvitationDTO> getAllUserInvitation(String userNumber) throws RemoteException;


}
