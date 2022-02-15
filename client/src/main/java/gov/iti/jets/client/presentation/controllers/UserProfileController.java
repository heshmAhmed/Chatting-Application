package gov.iti.jets.client.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {
    ValidationSupport validationSupport;

    @FXML
    private HBox information;

    @FXML
    private HBox logout;

    @FXML
    private HBox msg;

    @FXML
    private HBox notifications;

    @FXML
    private Button update;

    @FXML
    private TextField userName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validationSupport = new ValidationSupport();
    }

    @FXML
    void logoutClicked(MouseEvent event) {

    }

    @FXML
    void onClick(ActionEvent event){
        validationSupport.registerValidator(userName, Validator.createPredicateValidator(s->userName.getText().length()>3,"4 characters at least"));
        Notifications.create()
                .title("Feedback")
                .text("Updated")
                .darkStyle().show();
    }


    @FXML
    void showInformation(MouseEvent event) {

    }

    @FXML
    void showMsg(MouseEvent event) {

    }

    @FXML
    void showNotification(MouseEvent event) {

    }


}
