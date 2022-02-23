package gov.iti.jets.common.client;

import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.dtos.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientCallback extends Remote {

    public void receiveMessage(MessageDTO messageDTO) throws RemoteException;
    public void receiveInvitation(InvitationDTO invitationDTO)throws RemoteException;
    public  void receiveNewContact(ContactDTO contactDTO)throws RemoteException;

}
