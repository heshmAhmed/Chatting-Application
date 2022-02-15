package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.presentation.util.StageCoordinator;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginController{
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    @FXML
    private Label loginLabel;

    @FXML
    private TextField numberField;

    @FXML
    private TextField passwordField;

    @FXML
    private MFXButton forgetPasswordButton;

    @FXML
    private MFXButton loginButton;

    @FXML
    private MFXButton registerButton;

    @FXML
    void handelForgetPasswordAction(ActionEvent event) { }

    @FXML
    void loginClicked(ActionEvent event) {stageCoordinator.switchToChatScene();}

    @FXML
    void registerClicked (ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();
    }

}
