package gov.iti.jets.common.client;

import gov.iti.jets.common.dtos.MessageDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientCallback extends Remote {

    public void receiveMessage(MessageDTO messageDTO) throws RemoteException;







    public void serverDisconnected()throws RemoteException;

}
