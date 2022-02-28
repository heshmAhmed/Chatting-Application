package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.controllers.custom.ContactControl;
import gov.iti.jets.client.presentation.controllers.custom.ReceivedMessageControl;
import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.dtos.Status;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import java.util.HashMap;
import java.util.Map;

public class ContactListHelper {
    private static final ContactListHelper contactListHelper = new ContactListHelper();
    private final Map<String, ObservableList<HBox> > messageListMap = new HashMap<>();
    private final ObservableList<HBox> contactList = FXCollections.observableArrayList();
    private final Map<String, ContactControl> contactControlMap = new HashMap<>();

    private ContactListHelper(){
    }

    public static ContactListHelper getInstance(){
        return  contactListHelper;
    }

    public ObservableList<HBox> getContactList(){
        return contactList;
    }

    public ObservableList<HBox> createMessageList(String contactId){
        ObservableList<HBox> list;
        if(messageListMap.containsKey(contactId))
        {
            list = messageListMap.get(contactId);
        } else {
            list = FXCollections.observableArrayList();
            messageListMap.put(contactId, list);
        }
        return list;
    }

    public void addMessageToList(MessageDTO messageDTO) {
        Platform.runLater(()-> messageListMap.get(messageDTO.getSenderId()).add(new ReceivedMessageControl(messageDTO)));
    }

    public void loadContact(ContactModel contactModel) {
        ContactControl contactControl = new ContactControl(contactModel.getPhoneNumber());
        contactControl.getContactNameLabel().textProperty().bindBidirectional(contactModel.usernameProperty());
        contactControl.getContactPhotoCircle().fillProperty().bindBidirectional(contactModel.imageCircleProperty().get().fillProperty());
        contactControl.getStatusIcon().fillProperty().bindBidirectional(contactModel.statusIconPropertyProperty().get().fillProperty());
        contactControl.getContactNumberLabel().textProperty().bindBidirectional(contactModel.phoneNumberProperty());
        contactControl.statusProperty().bindBidirectional(contactModel.statusProperty());
        contactControl.bioProperty().bindBidirectional(contactModel.bioProperty());
        Platform.runLater(() -> {
            contactList.add(contactControl);
            contactControlMap.put(contactModel.getPhoneNumber(), contactControl);
        });
    }

    public boolean checkIfPhoneExist(String phoneNumber) {
        return this.contactControlMap.containsKey(phoneNumber);
    }

    public void changeContactStatus(String phoneNumber, Status status) {
        this.contactControlMap.get(phoneNumber).setStatus(status.name());
    }

    public String getContactStatus(String phoneNumber) {
        if (checkIfPhoneExist(phoneNumber)) {
            return this.contactControlMap.get(phoneNumber).getStatus();
        } else {
            return "not Found";
        }
    }
}
