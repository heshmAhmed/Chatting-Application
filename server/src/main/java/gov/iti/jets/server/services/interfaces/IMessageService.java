package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.MessageDTO;
import java.util.List;

public interface IMessageService {
    public void sendMessage (MessageDTO messageDTO);
    public void sendMsgToGroup(MessageDTO messageDTO,  List<String> groupContacts);
}
