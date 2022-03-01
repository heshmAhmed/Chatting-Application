package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.server.services.interfaces.IMessageService;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.RemoteException;
import java.util.List;

public class MessageServiceImpl implements IMessageService {
    private final static MessageServiceImpl messageService = new MessageServiceImpl();
    private final ServerUtil serverUtil = ServerUtil.getInstance();

    private MessageServiceImpl() {
    }

    public static MessageServiceImpl getInstance() {
        return messageService;
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) {
        try {
            serverUtil.onlineUsers.get(messageDTO.getReceiverId()).receiveMessage(messageDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMsgToGroup(MessageDTO messageDTO, List<String> contacts) {
        contacts.forEach(contact -> {
            IClientCallback iClientCallback = serverUtil.onlineUsers.get(contact);
            if (iClientCallback != null) {
                try {
                    iClientCallback.receiveGroupMessage(messageDTO);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void sendFileService(String senderName, String receiverPhone, byte[] sentFileAsBytes, String fileName) {
        if (serverUtil.onlineUsers.containsKey(receiverPhone)) {
            try {
                serverUtil.onlineUsers.get(receiverPhone).receiveFile(senderName, sentFileAsBytes, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
