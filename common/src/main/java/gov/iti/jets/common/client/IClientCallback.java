package gov.iti.jets.common.client;

import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.dtos.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientCallback extends Remote {
    void receiveMessage(MessageDTO messageDTO) throws RemoteException;
    void receiveInvitation(InvitationDTO invitationDTO)throws RemoteException;
    void receiveNewContact(ContactDTO contactDTO) throws RemoteException;
    void receiveStatusChange(String phoneNumber, Status status) throws RemoteException;
    void receiveGroupMessage(MessageDTO messageDTO) throws RemoteException;

}
