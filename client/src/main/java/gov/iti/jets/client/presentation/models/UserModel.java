package gov.iti.jets.client.presentation.models;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.time.LocalDate;

public class UserModel {
    private StringProperty phoneNumber = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private ObjectProperty<Image> image = new SimpleObjectProperty<>();
    private StringProperty username = new SimpleStringProperty();
    private Property<LocalDate> dob = new SimpleObjectProperty<>();
    private StringProperty gender = new SimpleStringProperty();
    private StringProperty country = new SimpleStringProperty();
    private StringProperty bio = new SimpleStringProperty();
//    add status to userModel

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

    public StringProperty getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio.set(bio);
    }

    public StringProperty bioProperty() {
        return bio;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "phoneNumber=" + phoneNumber +
                ", email=" + email +
                ", image=" + image +
                ", username=" + username +
                ", dob=" + dob +
                ", gender=" + gender +
                ", country=" + country +
                ", bio=" + bio +
                '}';
    }
}
