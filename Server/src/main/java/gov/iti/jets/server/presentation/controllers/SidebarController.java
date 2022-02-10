package gov.iti.jets.server.presentation.controllers;

import gov.iti.jets.server.presentation.util.PaneCoordinator;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SidebarController implements Initializable {
    @FXML
    private Button announcementButton;

    @FXML
    private Button logoutButton;

    @FXML
    private MFXToggleButton onOffButton;

    @FXML
    private Button staticsButton;

    @FXML
    private Button usersListButton;

    private PaneCoordinator paneCoordinator;

    @FXML
    void handleAnnouncement(ActionEvent event) {
        paneCoordinator.switchToAnnouncementPane();
    }

    @FXML
    void handleLogout(ActionEvent event) {
    }

    @FXML
    void handleOff(ActionEvent event) {

    }

    @FXML
    void handleOn(ActionEvent event) {

    }

    @FXML
    void handleStaticsButton(ActionEvent event) {
        paneCoordinator.switchToStaticsPane();
    }

    @FXML
    void handleUsersListButton(ActionEvent event) {
        paneCoordinator.switchUsersListPane();
    }

    @FXML
    public void handleOnOffButton(ActionEvent event){ }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.paneCoordinator = PaneCoordinator.getSceneCoordinator();
    }
}
