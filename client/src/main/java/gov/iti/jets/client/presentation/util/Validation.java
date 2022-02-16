package gov.iti.jets.client.presentation.util;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public abstract class Validation{

    private Validation(){

    }

    //add new contact

    public static boolean validateUserName(TextField userNameField , Label label){
        if(userNameField.getText().trim().length() <=2){
            label.setText("Name at least 3 characters");
            return false;
        }else{
            label.setText("");
            return true;
        }

    }


    public static boolean validateEmail(TextField emailField , Label label) {
        String email = emailField.getText();
        if (email.length()<0 || email.length() > 0 && !email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            label.setText("Enter a valid Email");
            return false;
        } else {
            label.setText("");
            return true;
        }
    }

    public static boolean validatePassword(PasswordField passwordField , Label label) {
        if (passwordField.getText().trim().length() <=1 ) {
            label.setText("password should be 2 characters at least");
            return false;
        }else {
            label.setText("");
            return true;
        }
    }

    public static boolean validatePhoneNumber(TextField phoneField,Label label) {
        if (!phoneField.getText().trim().matches("\\d{11,15}")) {
            label.setText("Enter a valid number");
            return false;
        } else {
            label.setText("");
            return true;
             }
        }

    public static boolean validateConfirmPassword(PasswordField passwordField ,PasswordField confirmPasswordField, Label label) {
        if (!passwordField.getText().trim().equals(confirmPasswordField.getText())) {
            label.setText("Not matching the password field");
            return false;
        }else {
            label.setText("");
            return true;
        }
    }

}
