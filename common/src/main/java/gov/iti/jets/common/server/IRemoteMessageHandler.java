package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.MessageDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IRemoteMessageHandler extends Remote {
    void sendMessage (MessageDTO messageDTO) throws RemoteException;
    void sendGroupMessage(MessageDTO messageDTO, List<String> groupContacts) throws RemoteException;
    void sendFile(String senderName ,String receiverPhone,byte [] sentFileAsBytes ,String fileName)throws RemoteException;
}
