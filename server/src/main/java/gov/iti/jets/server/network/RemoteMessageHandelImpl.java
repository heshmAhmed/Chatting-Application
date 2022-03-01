package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import gov.iti.jets.server.services.impls.MessageServiceImpl;
import gov.iti.jets.server.services.util.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteMessageHandelImpl extends UnicastRemoteObject implements IRemoteMessageHandler {
    private final MessageServiceImpl messageService = ServiceFactory.getInstance().getMessageService();

    public RemoteMessageHandelImpl() throws RemoteException {
        super();
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) throws RemoteException {
        messageService.sendMessage(messageDTO);
    }

    @Override
    public void sendGroupMessage(MessageDTO messageDTO, List<String> groupContacts) {
        System.out.println("message to group is here" + messageDTO.getMessageText() + messageDTO.getSenderId());
        messageService.sendMsgToGroup(messageDTO, groupContacts);
    }

    @Override
    public void sendFile(String senderName, String receiverPhone, byte[] sentFileAsBytes, String fileName) {
        messageService.sendFileService(senderName, receiverPhone, sentFileAsBytes, fileName);

    }
}
