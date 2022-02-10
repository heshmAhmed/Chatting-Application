package gov.iti.jets.client.controllers;

import gov.iti.jets.client.controllers.custom.ContactControl;
import gov.iti.jets.client.dtos.ContactDTO;
import gov.iti.jets.client.util.StageCoordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    private StageCoordinator stageCoordinator ;

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
    void profileButtonPressed(ActionEvent event) {
        stageCoordinator.switchToProfileScene();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageCoordinator = StageCoordinator.getInstance();
    }

}
