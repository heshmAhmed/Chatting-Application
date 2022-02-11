package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.StageCoordinator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    private StageCoordinator stageCoordinator;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageCoordinator = StageCoordinator.getInstance();
//        userPhotoCircle.addEventHandler(MouseEvent mouseEvent);
    }

    public void handleAddNewContactIcon(MouseEvent mouseEvent) {
        stageCoordinator.showAddNewContactPopup();
    }

    public void handleProfileIcon(MouseEvent mouseEvent) {
        stageCoordinator.switchToUserProfileScene();
    }
}
