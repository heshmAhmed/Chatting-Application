package gov.iti.jets.client.util;

import javafx.scene.control.TextField;



public abstract class Validation{

    private Validation(){

    }

    //add new contact
    //confirm password
    //remove label

    public static boolean validateUserName(TextField userNameField){
        if(userNameField.getText().length() <=2){
            userNameField.setStyle("-fx-background-color: #ff295b");
            //lebel.setText......
            return false;
        }else{
            userNameField.setStyle("-fx-background-color: white");
            return true;
        }

    }


    public static boolean validateEmail(TextField emailField) {
        String email = emailField.getText();
        if (email.length() > 0 && !email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            emailField.setStyle("-fx-background-color: #ff295bv");
            return false;
        } else {
            emailField.setStyle("-fx-background-color: white");
            return true;
        }
    }

    public static boolean validatePassword(TextField passwordField) {
        if (passwordField.getText().length() <= 0 ) {
            passwordField.setStyle("-fx-background-color: #ff295b");
            return false;
        }else {
            passwordField.setStyle("-fx-background-color: white");
            return true;
        }
    }

    public static boolean validatePhoneNumber(TextField phoneField) {
        String phoneNo = phoneField.getText();
        if (!phoneNo.matches("01(0|1|2|5)\\d{8}")) {
            phoneField.setStyle("-fx-background-color: #ff295b");
            return false;
        } else {
            phoneField.setStyle("-fx-background-color: white");
            return true;
             }
        }
}
