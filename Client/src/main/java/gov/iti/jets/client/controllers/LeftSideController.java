package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.PaneCoordinator;
import gov.iti.jets.client.util.StageCoordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

public class LeftSideController implements Initializable {
    private PaneCoordinator paneCoordinator  = PaneCoordinator.getInstance();
    private StageCoordinator stageCoordinator ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageCoordinator = StageCoordinator.getInstance();
    }

    @FXML
    private HBox information;

    @FXML
    private HBox invitations;

    @FXML
    private HBox logout;

    @FXML
    private HBox chat;

    @FXML
    private HBox notifications;

    @FXML
    private Button update;

    @FXML
    void logoutClicked(MouseEvent event) {
        stageCoordinator.switchToLoginScene();
    }

    @FXML
    void onClick(ActionEvent event){
        Notifications.create()
                .title("Feedback")
                .text("Updated")
                .darkStyle().show();
    }

    @FXML
    void showInformation(MouseEvent event) {
        paneCoordinator.switchToUserInfoPane();
    }

    @FXML
    void showInvitations(MouseEvent event) {
        paneCoordinator.switchToInvitationsPane();
    }

    @FXML
    void backToChat(MouseEvent event) {
        stageCoordinator.switchToChatScene();
    }

    @FXML
    void showNotification(MouseEvent event) {
        paneCoordinator.switchToNotificationsPane();
    }

}
