package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.ChatBot;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.server.IRemoteMessageHandler;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

public class SendMessageService {
    private static SendMessageService sendMessageService = new SendMessageService();
    private RegistryFactory registryFactory = RegistryFactory.getInstance();
    private IRemoteMessageHandler iRemoteMessageHandler = registryFactory.getRemoteMessageHandler();
    GroupListHelper groupListHelper = GroupListHelper.getInstance();
    private final ChatBot bot = ChatBot.getInstance();
    private ContactListHelper contactListHelper = ContactListHelper.getInstance();
    private SendMessageService(){}

    public static SendMessageService getInstance(){
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


    public void sendGroupMessage(MessageDTO messageDTO){
        List<String> groupContactsList = groupListHelper.getGroupDtosList().get(messageDTO.getReceiverId()).getContacts();
        groupContactsList.remove(messageDTO.getSenderId());
        try {
            iRemoteMessageHandler.sendGroupMessage(messageDTO,groupContactsList);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public  void sendFile(String senderName ,String receiverPhone,  byte[] sentFileAsBytes , String fileName){
        try {
            iRemoteMessageHandler.sendFile(senderName, receiverPhone, sentFileAsBytes, fileName);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
