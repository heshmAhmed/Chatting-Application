package gov.iti.jets.client.presentation.models;

import gov.iti.jets.common.dtos.Status;
import javafx.beans.property.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.time.LocalDate;

public class UserModel {
    private final StringProperty phoneNumber = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final SimpleObjectProperty<Circle> userImageCircle = new SimpleObjectProperty<>();
    private final StringProperty username = new SimpleStringProperty();
    private final Property<LocalDate> dob = new SimpleObjectProperty<>();
    private final StringProperty gender = new SimpleStringProperty();
    private final StringProperty country = new SimpleStringProperty();
    private final StringProperty bio = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final SimpleObjectProperty<Circle> statusIconProperty = new SimpleObjectProperty<>();

    public UserModel() {
        this.setStatusIconProperty(new Circle());
        this.setUserImageCircle(new Circle());
        addListenerToStatus();
    }

    private void addListenerToStatus() {
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

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public Circle getUserImageCircle() {
        return userImageCircle.get();
    }

    public SimpleObjectProperty<Circle> userImageCircleProperty() {
        return userImageCircle;
    }

    public void setUserImageCircle(Circle userImageCircle) {
        this.userImageCircle.set(userImageCircle);
    }

    public String getUsername() {
        return username.get();
    }

    public Circle getStatusIconProperty() {
        return statusIconProperty.get();
    }

    public SimpleObjectProperty<Circle> statusIconPropertyProperty() {
        return statusIconProperty;
    }

    public void setStatusIconProperty(Circle statusIconProperty) {
        this.statusIconProperty.set(statusIconProperty);
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public LocalDate getDob() {
        return dob.getValue();
    }

    public Property<LocalDate> dobProperty() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob.setValue(dob);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }


    public String getBio() {
        return bio.get();
    }

    public void setBio(String bio) {
        this.bio.set(bio);
    }

    public StringProperty bioProperty() {
        return bio;
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
    @Override
    public String toString() {
        return "UserModel{" +
                "phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", username=" + username +
                ", dob=" + dob +
                ", gender=" + gender +
                ", country=" + country +
                ", bio=" + bio +
                '}';
    }
}
