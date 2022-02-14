package gov.iti.jets.server.presentation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserModel {
    private String Number;
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String State;

    public UserModel(String number, String firstName, String lastName, String email, String country, String state) {
        Number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        State = state;
    }

    public String getNumber() {
        return Number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return State;
    }
}
