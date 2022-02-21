package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.controllers.custom.ContactControl;
import gov.iti.jets.client.presentation.controllers.custom.ReceivedMessageControl;
import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.common.dtos.MessageDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;

import java.util.HashMap;
import java.util.Map;

public class ContactListHelper {
    private static final ContactListHelper contactListHelper = new ContactListHelper();
    private final Map<String, ObservableList<HBox> > messageListMap = new HashMap<>();
    //private final ObservableList<HBox> observableList= new ObservableList<>;
    private final Map<String, ContactControl> contactControlMap = new HashMap<>();
    private final UserModel userModel = ModelFactory.getInstance().getUserModel();

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
        } else {
            list = FXCollections.observableArrayList();
            messageListMap.put(contactId, list);
        }
        return list;
    }

    public void addMessageToList(MessageDTO messageDTO){
        messageListMap.get(messageDTO.getSenderId()).add(new ReceivedMessageControl(messageDTO));
    }

    public void addNewContact(ContactModel contactModel) {
        ContactControl contactControl = new ContactControl();
        contactControl.getContactNameLabel().textProperty().bindBidirectional(contactModel.usernameProperty());
        contactControl.getImageView().imageProperty().bindBidirectional(contactModel.imageProperty());
        // testing
        contactControl.statusProperty().bindBidirectional(contactModel.statusProperty());
        contactControl.bioProperty().bindBidirectional(contactModel.bioProperty());
        userModel.getContactModels().add(contactModel);
    }

}
