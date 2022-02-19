package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.controllers.custom.SentMessageControl;
import gov.iti.jets.common.dtos.MessageDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

import java.util.HashMap;
import java.util.Map;

public class ContactListHelper {
    private static ContactListHelper contactListHelper = new ContactListHelper();
    private static Map<String, ObservableList<HBox> > messageListMap = new HashMap<>();

    private ContactListHelper(){

    }

    public static ContactListHelper getInstance(){
        return  contactListHelper;
    }

    public ObservableList<HBox> createMessageList(String contactId){

        ObservableList<HBox> list;
        if(messageListMap.containsKey(contactId))
        {
            return messageListMap.get(contactId);
        }else {
            list = FXCollections.observableArrayList();
            messageListMap.put(contactId, list);
        }

        return list;
    }


    public void addMessageToList(MessageDTO messageDTO){
        messageListMap.get(messageDTO.getSenderId()).add(new SentMessageControl(messageDTO));
    }

}
