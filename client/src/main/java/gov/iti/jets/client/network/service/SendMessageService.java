package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.ChatBot;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.server.IRemoteMessageHandler;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class SendMessageService {
    private static final SendMessageService sendMessageService = new SendMessageService();
    private final RegistryFactory registryFactory = RegistryFactory.getInstance();
    private final IRemoteMessageHandler iRemoteMessageHandler = registryFactory.getRemoteMessageHandler();
    private final ContactListHelper contactListHelper = ContactListHelper.getInstance();
   // private final ChatBot bot = ChatBot.getInstance();
   private final ChatBot bot = new ChatBot();
    private SendMessageService() {
    }

    public static SendMessageService getInstance() {
        return sendMessageService;
    }

    public void sendMessage(MessageDTO messageDTO) {
        String status = contactListHelper.getContactStatus(messageDTO.getReceiverId());
        if (status.equals(Status.BUSY.name()) || status.equals(Status.OFFLINE.name())) {
            String response = bot.sendMsgToBots(messageDTO.getMessageText());
            messageDTO.setMessageText(response);
            String temp = messageDTO.getSenderId();
            messageDTO.setSenderId(messageDTO.getReceiverId());
            messageDTO.setReceiverId(temp);
            contactListHelper.addMessageToList(messageDTO);
        } else {

            try {
                iRemoteMessageHandler.sendMessage(messageDTO);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }


}
