package gov.iti.jets.common.client;

import java.rmi.Remote;

public interface IClientCallback extends Remote {

    public void receiveMessage(MessageDTO messageDTO);
}
