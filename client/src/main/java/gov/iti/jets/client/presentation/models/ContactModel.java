package gov.iti.jets.client.presentation.models;

import gov.iti.jets.common.dtos.Status;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ContactModel {
    private final StringProperty phoneNumber = new SimpleStringProperty();
    private final ObjectProperty<Image> image = new SimpleObjectProperty<>();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty bio = new SimpleStringProperty();
    private final ObjectProperty<Circle> statusIconProperty= new SimpleObjectProperty<>();

    public ContactModel() {
        this.setStatusIconProperty(new Circle());
        status.addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(Status.AVAILABLE.name()))
                statusIconProperty.get().setFill(Color.valueOf("1AC23C"));
            if(newValue.equals(Status.AWAY.name()))
                statusIconProperty.get().setFill(Color.valueOf("FDF00A"));
            if(newValue.equals(Status.BUSY.name()))
                statusIconProperty.get().setFill(Color.valueOf("E96150"));
            if (newValue.equals(Status.OFFLINE.name()))
                statusIconProperty.get().setFill(Color.valueOf("806A6D"));
        });
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public Image getImage() {
        return image.get();
    }

    public ObjectProperty<Image> imageProperty() {
        return image;
    }

    public void setImage(Image image) {
        this.image.set(image);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getBio() {
        return bio.get();
    }

    public StringProperty bioProperty() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio.set(bio);
    }

    public Circle getStatusIconProperty() {
        return statusIconProperty.get();
    }

    public ObjectProperty<Circle> statusIconPropertyProperty() {
        return statusIconProperty;
    }

    public void setStatusIconProperty(Circle statusIconProperty) {
        this.statusIconProperty.set(statusIconProperty);
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "phoneNumber=" + phoneNumber +
                ", image=" + image +
                ", username=" + username +
                ", status=" + status +
                ", bio=" + bio +
                '}';
    }
}
