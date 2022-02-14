package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.StageCoordinator;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private StageCoordinator stageCoordinator ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageCoordinator = StageCoordinator.getInstance();
    }

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
    void handelForgetPasswordAction(ActionEvent event) {

    }

    @FXML
    void handelLoginAction(ActionEvent event) {
//        stageCoordinator.switchToChatScene();
    }

    @FXML
    void handelRegisterAction(ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();
    }

}
