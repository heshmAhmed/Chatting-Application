package gov.iti.jets.server.presentation.controllers;

import gov.iti.jets.server.presentation.util.AdminLoginHelper;
import gov.iti.jets.server.presentation.util.StageCoordinator;
import gov.iti.jets.server.presentation.util.Validation;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangePasswordController implements Initializable {
    private AdminLoginHelper adminLoginHelper = AdminLoginHelper.getInstance();
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private Validation validation = Validation.getInstance();
    private String phone;

    @FXML
    private MFXButton changePasswordBtn;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    void changePassword(ActionEvent event) {
        String currentPassword = passwordField.getText().trim();
        if(validation.validatePassword(passwordField,passwordLabel) &&
           validation.validateConfirmPassword(passwordField,confirmPasswordField,confirmPasswordLabel)){
            passwordField.setText("");
            confirmPasswordField.setText("");
            adminLoginHelper.changeAdminPassword(currentPassword);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.stageCoordinator = StageCoordinator.getInstance();
    }

}

