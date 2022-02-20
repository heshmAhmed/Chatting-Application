package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.server.IRemoteMessageHandler;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class SendMessageService {
    private static SendMessageService sendMessageService = new SendMessageService();
    private RegistryFactory registryFactory = RegistryFactory.getInstance();
    private IRemoteMessageHandler iRemoteMessageHandler = registryFactory.getRemoteMessageHandler();

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

}
