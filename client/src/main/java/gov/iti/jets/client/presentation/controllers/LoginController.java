package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.controllers.custom.PasswordFieldControl;
import gov.iti.jets.client.presentation.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

import java.io.File;
import java.rmi.RemoteException;
import static javafx.stage.WindowEvent.WINDOW_SHOWN;


public class LoginController {
    private EventType<WindowEvent> window = new EventType<>(WINDOW_SHOWN);
    private SessionManager sessionManager = SessionManager.getInstance();
    private final StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private final LoginService myLoginService = LoginService.getInstance();
    File session = sessionManager.createSession();
    boolean isPasswordFieldOn;
    private PasswordFieldControl passwordFieldControl;
    private LoginHelper loginHelper;

    @FXML
    private Label loginLabel;

    @FXML
    public Label validatePasswordLabel;

    @FXML
    private TextField numberField;

    @FXML
    private MFXButton forgetPasswordButton;

    @FXML
    private MFXButton loginButton;

    @FXML
    private MFXButton registerButton;

    @FXML
    private HBox passwordPlaceholderHBox;

    @FXML
    private Hyperlink skipHyperlink;

    @FXML
    void handleSkipHyperLink(ActionEvent event) {
        stageCoordinator.closePrimaryStage();
    }
    private Label validateUserLabel = new Label("");

    public void initialize() {
        loginHelper = new LoginHelper(passwordPlaceholderHBox, validatePasswordLabel,loginButton);
        passwordFieldControl = new PasswordFieldControl(validatePasswordLabel);
        skipHyperlink.setTextFill(Color.LIGHTBLUE);
        validateUserLabel.setTextFill(Color.web("#e40808"));
        validatePasswordLabel.setTextFill(Color.web("#e40808"));
        passwordPlaceholderHBox.getChildren().add(validateUserLabel);
        loginButton.setText("next");
        isPasswordFieldOn=false;
        numberField.setOnMouseClicked(event -> {validateUserLabel.setText("");

            if(isPasswordFieldOn){
                passwordPlaceholderHBox.getChildren().clear();
                passwordPlaceholderHBox.getChildren().add(validateUserLabel);
                isPasswordFieldOn = false;
                loginButton.setText("next");
            }


        });
    }

    @FXML
    void loginClicked(ActionEvent event){
        handelLoginAction();
    }

    private void handelLoginAction(){
        String phoneNumber = numberField.getText().trim();
        if(!isPasswordFieldOn){
            isPasswordFieldOn = loginHelper.handlePhoneNumberValidation(numberField, validateUserLabel);
            sessionManager.saveSession(session, phoneNumber, "");
        }else{
            try {
                loginHelper.handlePasswordValidation();

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void registerClicked(ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();
    }

}
