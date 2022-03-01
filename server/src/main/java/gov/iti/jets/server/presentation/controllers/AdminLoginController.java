package gov.iti.jets.server.presentation.controllers;

import gov.iti.jets.server.presentation.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.stage.WindowEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.stage.WindowEvent.WINDOW_SHOWN;

public class AdminLoginController implements Initializable {
    private SessionManager sessionManager = SessionManager.getInstance();
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private AdminLoginHelper adminLoginHelper = AdminLoginHelper.getInstance();
    private Validation validation = Validation.getInstance();
    File session = sessionManager.createSession();
    private EventType<WindowEvent> window = new EventType<>(WINDOW_SHOWN);
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
        handelLoginAction();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.stageCoordinator = StageCoordinator.getInstance();
        if (session.exists()) {
            String str = sessionManager.readSession(session);
            setAdminInfo(str);
        }
    }

    private void handelLoginAction() {
        String phoneNumber = phoneFiled.getText().trim();
        String currentPassword = passwordField.getText().trim();
        if (validation.validatePhoneNumber(phoneFiled, phoneLabel) && validation.validatePassword(passwordField, passwordLabel)) {
            if (adminLoginHelper.getAdmin(phoneNumber, currentPassword)) {
                validAdminLabel.setText("");
                passwordField.setText("");
                sessionManager.saveSession(session, phoneNumber, currentPassword);
            } else {
                validAdminLabel.setText("Admin not exists");
            }
        } else {
            validAdminLabel.setText("Something went wrong");
        }
    }

    private void login(){
        if (window.getSuperType() == WINDOW_SHOWN) {
            System.out.println("WINDOW_SHOWN");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    handelLoginAction();
                }
            });
        }
    }

    private void setAdminInfo(String string){
        String[] text = sessionManager.decryption(string);
        if (text.length == 2) {
            phoneFiled.setText(text[0]);
            passwordField.setText(text[1]);
            login();
        }
    }

}



