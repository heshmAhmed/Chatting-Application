package gov.iti.jets.client.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import org.controlsfx.control.Notifications;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class UserProfileController {

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
    void logoutClicked(MouseEvent event) {

    }

    @FXML
    void onClick(ActionEvent event , Scene scene){
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
