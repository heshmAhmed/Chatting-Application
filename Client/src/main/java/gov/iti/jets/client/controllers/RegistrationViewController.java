package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.StageCoordinator;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class RegistrationViewController implements Initializable {

    private StageCoordinator stageCoordinator ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageCoordinator = StageCoordinator.getInstance();

    }

    @FXML
    private TextField confermationPassword;

    @FXML
    private TextField country;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField enterYourEmail;

    @FXML
    private TextField enterYourName;

    @FXML
    private TextField enterYourNumber;

    @FXML
    private TextField enterYourPassword;

    @FXML
    private MenuButton gender;

    @FXML
    private MFXButton haveAccount;

    @FXML
    private MFXButton register;


    @FXML
    void handelHaveAccountAction(ActionEvent event) {
        stageCoordinator.switchToLoginScene();
    }

    @FXML

    void handelRegisterAction(ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();

    }

}
