package gov.iti.jets.client.presentation.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContactModel {

    private StringProperty contactId = new SimpleStringProperty();

    public String getContactId() {
        return contactId.get();
    }

    public StringProperty contactIdProperty() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId.set(contactId);
    }


}
