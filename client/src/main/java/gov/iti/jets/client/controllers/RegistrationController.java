package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.StageCoordinator;
import gov.iti.jets.client.util.Validation;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class RegistrationController implements Initializable {
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderBox.getItems().addAll("Male", "Female");
        countryBox.getItems().addAll("Egypt", "Iran","Syria");

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
    void handelRegisterAction(ActionEvent event){
       if(Validation.validateUserName(nameField,nameLabel) &&
           Validation.validatePhoneNumber(phoneField,phoneLabel)&&
           Validation.validateEmail(emailField,emailLabel) && Validation.validatePassword(passwordField,passwordLabel)&&
           Validation.validateConfirmPassword(confirmPasswordField,passwordField,confirmPasswordLabel)){
           stageCoordinator.switchToChatScene();
       }
    }


















    @FXML
    void handelHaveAccountAction(ActionEvent event) {
        stageCoordinator.switchToLoginScene();
    }
}
