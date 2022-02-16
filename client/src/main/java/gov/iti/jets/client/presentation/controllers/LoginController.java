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
    private MFXButton forgetPassword;

    @FXML
    private MFXButton login;

    @FXML
    private TextField numberField;

    @FXML
    private Label numberLabel;

    @FXML
    private TextField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private MFXButton register;

    public LoginController() {
    }

    @FXML
    void handelForgetPasswordAction(ActionEvent event) { }

    @FXML
    void loginClicked(ActionEvent event) {stageCoordinator.switchToChatScene();}

    @FXML
    void registerClicked (ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();
    }

}
