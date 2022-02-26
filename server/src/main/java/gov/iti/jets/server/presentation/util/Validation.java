package gov.iti.jets.server.presentation.util;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Validation {
    private final static Validation validation = new Validation();

    private Validation(){}

    public static Validation getInstance() {
        return validation;
    }



    public boolean validatePhoneNumber(TextField phoneField, Label label) {
        if (!phoneField.getText().trim().matches("\\d{11,15}")) {
            label.setText("Enter a valid phone number");
            return false;
        } else {
            label.setText("");
            return true;
        }
    }


    public boolean validatePassword(PasswordField passwordField , Label label) {
        if (passwordField.getText().trim().length() <=1 ) {
            label.setText("password should be 2 characters at least");
            return false;
        }else {
            label.setText("");
            return true;
        }
    }

    public boolean validateConfirmPassword(PasswordField passwordField , PasswordField confirmPasswordField, Label label) {
        if (!passwordField.getText().trim().equals(confirmPasswordField.getText())) {
            label.setText("Not matching the password field");
            return false;
        }else {
            label.setText("");
            return true;
        }
    }
}
