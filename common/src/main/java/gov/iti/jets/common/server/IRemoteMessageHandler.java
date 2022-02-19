package gov.iti.jets.common.server;

import gov.iti.jets.common.dtos.MessageDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteMessageHandler extends Remote {

    public void sendMessage (MessageDTO messageDTO) throws RemoteException;

}
