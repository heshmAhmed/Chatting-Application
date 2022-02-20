package gov.iti.jets.server.services.util;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.server.repository.entity.ContactEntity;
import gov.iti.jets.server.services.interfaces.IContactService;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServerUtil {
    /*holds online users map and all its functions*/

    private static ServerUtil serverUtil = new ServerUtil();
    private final IContactService contactService = ServiceFactory.getInstance().getContactService();
    public Map<String, IClientCallback> onlineUsers = new ConcurrentHashMap<>();


    private ServerUtil() {

    }

    public static ServerUtil getInstance() {
        return serverUtil;
    }

    public void addUserToOnline(String phoneNumber, IClientCallback callback) {
        onlineUsers.put(phoneNumber, callback);

        //////test remove later////////////////////

//        try {
//            callback.receiveMessage(new MessageDTO());
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

        ///////////////////////////////////////////////
        for (Map.Entry<String, IClientCallback> entry : onlineUsers.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public void removeUserFromOnline(String phoneNumber) {
        onlineUsers.remove(phoneNumber);
    }

    public void sendNotificationToList(String senderPhoneNumber) {
        List<ContactDTO> userContacts = contactService.getAllUserContacts(senderPhoneNumber);
        System.out.println(userContacts);
        try {
            for (ContactDTO contact : userContacts) {
                if (onlineUsers.containsKey(contact.getPhoneNumber()))
                    onlineUsers.get(contact.getPhoneNumber()).receiveNotification("Your Friend is " + contact.getStatus());

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    public void sendMessageToUser(MessageDTO messageDTO) {
        try {
            onlineUsers.get(messageDTO.getReceiverId()).receiveMessage(messageDTO);
            onlineUsers.get(messageDTO.getReceiverId()).receiveNotification("New Message From" + messageDTO.getSenderId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
