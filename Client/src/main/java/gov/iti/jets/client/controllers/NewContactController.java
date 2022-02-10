package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.StageCoordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NewContactController {

    StageCoordinator stageCoordinator = StageCoordinator.getInstance();

    @FXML
    private TextField phoneNumberField;

    @FXML
    void handlSendButton(ActionEvent event) {
        stageCoordinator.closeAddContactPP();
    }

    @FXML
    void handleAddIcon(MouseEvent event) {

    }

    @FXML
    void handlePhoneNumberField(ActionEvent event) {

    }

}
