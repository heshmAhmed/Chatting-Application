package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.RegistrationService;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.client.presentation.util.Validation;
import gov.iti.jets.common.dtos.UserDTO;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class RegistrationController implements Initializable {
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private RegistrationService service;

    @FXML
    private DatePicker datePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderBox.getItems().addAll("Male", "Female");
        countryBox.getItems().addAll("Egypt", "Iran", "Syria");
        service = RegistrationService.getInstance();
    }



    @FXML
    private ComboBox genderBox , countryBox;


    @FXML
    private PasswordField passwordField , confirmPasswordField;

    @FXML
    private TextField phoneField , nameField , emailField ;

    @FXML
    private MFXButton register , haveAccountLink;

    @FXML
    private Label countryLabel ,genderLabel , dateLabel , phoneLabel , nameLabel , emailLabel , confirmPasswordLabel , passwordLabel ;


    @FXML
    void handelRegisterAction(ActionEvent event) {
        if (Validation.validateUserName(nameField, nameLabel) &&
            Validation.validatePhoneNumber(phoneField, phoneLabel) &&
            Validation.validateEmail(emailField, emailLabel) && Validation.validatePassword(passwordField, passwordLabel) &&
            Validation.validateConfirmPassword(confirmPasswordField, passwordField, confirmPasswordLabel)) {
            System.out.println(service.checkPhoneNumber(phoneField.getText()));
            System.out.println(service.checkPhoneNumber(emailField.getText()));

            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(nameField.getText());
            userDTO.setPhoneNumber(phoneField.getText());
            userDTO.setEmail(emailField.getText());
            userDTO.setPassword(passwordField.getText());
            userDTO.setCountry(countryBox.getValue().toString());
            userDTO.setCountry(genderBox.getValue().toString());

            //userDTO.setDob(datePicker.);
            System.out.println(countryBox.getValue().toString());
            System.out.println(genderBox.getValue().toString());
            //System.out.println(datePicker.getValue().toString());
            boolean check = service.createNewUser(userDTO);
            System.out.println(check);
            stageCoordinator.switchToLoginScene();
        }
    }


    @FXML
    void handelHaveAccountAction(ActionEvent event) {
        stageCoordinator.switchToLoginScene();
    }
}
