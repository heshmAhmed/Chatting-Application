package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class SendMessageService {
    private static SendMessageService sendMessageService = new SendMessageService();
    private RegistryFactory registryFactory = RegistryFactory.getInstance();
    private IRemoteMessageHandler iRemoteMessageHandler = registryFactory.getRemoteMessageHandler();
    GroupListHelper groupListHelper = GroupListHelper.getInstance();
    private SendMessageService(){}

    public static SendMessageService getInstance(){
        return sendMessageService;
    }

    public void sendMessage(MessageDTO messageDTO){
        try {
            iRemoteMessageHandler.sendMessage(messageDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void sendGroupMessage(MessageDTO messageDTO){

        ////get list


        List<String> groupContactsList = groupListHelper.getGroupDtosList().get(messageDTO.getReceiverId()).getContacts();

        groupContactsList.remove(messageDTO.getSenderId());

        try {
            iRemoteMessageHandler.sendGroupMessage(messageDTO,groupContactsList);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
