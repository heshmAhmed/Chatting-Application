package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.MessageDTO;

public interface IMessageService {
    public void sendMessage (MessageDTO messageDTO);
}
