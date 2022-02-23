package gov.iti.jets.client.presentation.models;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InvitationModel{
    private StringProperty senderPhoneNumber = new SimpleStringProperty();
    private StringProperty recieverPhoneNumber = new SimpleStringProperty();
    private StringProperty senderName = new SimpleStringProperty();
    private StringProperty recieverName = new SimpleStringProperty();
    private LongProperty date = new SimpleLongProperty();

    public String getSenderPhoneNumber() {
        return senderPhoneNumber.get();
    }

    public StringProperty senderPhoneNumberProperty() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber.set(senderPhoneNumber);
    }

    public String getRecieverPhoneNumber() {
        return recieverPhoneNumber.get();
    }

    public StringProperty recieverPhoneNumberProperty() {
        return recieverPhoneNumber;
    }

    public void setRecieverPhoneNumber(String recieverPhoneNumber) {
        this.recieverPhoneNumber.set(recieverPhoneNumber);
    }

    public String getSenderName() {
        return senderName.get();
    }

    public StringProperty senderNameProperty() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName.set(senderName);
    }

    public String getRecieverName() {
        return recieverName.get();
    }

    public StringProperty recieverNameProperty() {
        return recieverName;
    }

    public void setRecieverName(String recieverName) {
        this.recieverName.set(recieverName);
    }

    public long getDate() {
        return date.get();
    }

    public LongProperty dateProperty() {
        return date;
    }

    public void setDate(long date) {
        this.date.set(date);
    }
}
