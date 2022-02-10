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
    private Label Login;

    @FXML
    private TextField enterYourNumber;

    @FXML
    private TextField enterYourPsaaword;

    @FXML
    private MFXButton forgetPassword;

    @FXML
    private MFXButton login;

    @FXML
    private MFXButton register;

    @FXML
    void handelForgetPasswordAction(ActionEvent event) {

    }

    @FXML
    void handelLoginAction(ActionEvent event) {
        stageCoordinator.switchToLoginScene();
    }

    @FXML
    void handelRegisterAction(ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();
    }

}
