package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.RegistrationService;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.client.presentation.util.Validation;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class RegistrationController implements Initializable {
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    RegistrationService service ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderBox.getItems().addAll("Male", "Female");
        countryBox.getItems().addAll("Egypt", "Iran", "Syria");
         service=RegistrationService.getInstance();

    }

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private ComboBox countryBox;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField emailField;

    @FXML
    private Label emailLabel;

    @FXML
    private ComboBox genderBox;

    @FXML
    private MFXButton haveAccountLink;

    @FXML
    private TextField nameField;

    @FXML
    private Label nameLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField phoneField;

    @FXML
    private Label phoneLabel;

    @FXML
    private MFXButton register;

    @FXML
    void handelRegisterAction(ActionEvent event) {

        /*if (Validation.validateUserName(nameField, nameLabel) &&
                Validation.validatePhoneNumber(phoneField, phoneLabel) &&
                Validation.validateEmail(emailField, emailLabel) && Validation.validatePassword(passwordField, passwordLabel) &&
                Validation.validateConfirmPassword(confirmPasswordField, passwordField, confirmPasswordLabel)) {*/



                System.out.println(service.checkPhoneNumber(phoneField.getText()));
                System.out.println(service.checkPhoneNumber(emailField.getText()));

            stageCoordinator.switchToChatScene();
        }
   // }


    @FXML
    void handelHaveAccountAction(ActionEvent event) {
        stageCoordinator.switchToLoginScene();
    }
}
