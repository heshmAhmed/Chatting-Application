package gov.iti.jets.server.network;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import gov.iti.jets.server.services.impls.MessageServiceImpl;
import gov.iti.jets.server.services.impls.RegistrationServiceImpl;
import gov.iti.jets.server.services.interfaces.IMessageService;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageHandelImpl extends UnicastRemoteObject implements IRemoteMessageHandler {
    ServerUtil serverUtil = ServerUtil.getInstance();
    MessageServiceImpl service = new MessageServiceImpl();

    public RemoteMessageHandelImpl() throws RemoteException {
        super();
    }

    @Override
    public void sendMessage(MessageDTO messageDTO) throws RemoteException {
        service.sendMessage(messageDTO);
    }
}
