package gov.iti.jets.client.controllers;

import gov.iti.jets.client.controllers.custom.ContactControl;
import gov.iti.jets.client.dtos.ContactDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class ChatController {

    @FXML
    private Button addNewContactButton;

    @FXML
    private VBox contactListVBox;

    @FXML
    private Button profileButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label userNameLabel;

    @FXML
    private Circle userPhotoCircle;

    @FXML
    void addNewContactButtonPressed(ActionEvent event) {
        ContactDTO contactDTO = new ContactDTO();

        Pane pane = new ContactControl(contactDTO);

        contactListVBox.getChildren().add(pane);
    }

    @FXML
    void profleButtonPressed(ActionEvent event) {

    }

}
