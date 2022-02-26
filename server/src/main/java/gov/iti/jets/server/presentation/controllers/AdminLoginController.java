package gov.iti.jets.server.presentation.controllers;

import gov.iti.jets.server.presentation.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private AdminLoginHelper adminLoginHelper = AdminLoginHelper.getInstance();
    private Validation validation = Validation.getInstance();

    @FXML
    private MFXButton loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label validAdminLabel;

    @FXML
    private TextField phoneFiled;

    @FXML
    private Label phoneLabel;

    @FXML
    void handelLoginAction(ActionEvent event) {
        String phoneNumber = phoneFiled.getText().trim();
        String currentPassword = passwordField.getText().trim();
        if(validation.validatePhoneNumber(phoneFiled,phoneLabel) && validation.validatePassword(passwordField,passwordLabel)){
            if(adminLoginHelper.getAdmin(phoneNumber,currentPassword)){
                validAdminLabel.setText("");
            }else{
                validAdminLabel.setText("Admin not exists");
            }
        }else{
            validAdminLabel.setText("Something went wrong");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.stageCoordinator = StageCoordinator.getInstance();
    }

}


