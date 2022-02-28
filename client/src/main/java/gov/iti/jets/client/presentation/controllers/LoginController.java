package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.controllers.custom.PasswordFieldControl;
import gov.iti.jets.client.presentation.util.*;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.File;
import java.rmi.RemoteException;


public class LoginController {
    private SessionManager sessionManager = SessionManager.getInstance();
    private final StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private final LoginService myLoginService = LoginService.getInstance();
    File session = sessionManager.createSession();
    boolean isPasswordFieldOn = true;
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
        skipHyperlink.setTextFill(Color.LIGHTBLUE);
        validateUserLabel.setTextFill(Color.web("#e40808"));
        validatePasswordLabel.setTextFill(Color.web("#e40808"));
        passwordPlaceholderHBox.getChildren().add(validateUserLabel);
        loginButton.setText("next");
        isPasswordFieldOn = false;
        numberField.setOnMouseClicked(event -> {validateUserLabel.setText("");});
//        if(session.exists()){
//            String str = sessionManager.readSession(session);
//            String[] text =  sessionManager.decryption(str);
//            if(text.length ==2){
//                System.out.println(text[0]);
//                System.out.println(text[1]);
//                numberField.setText(text[0]);
//                .setText(text[1]);
//            }
//
//        }
    }


    @FXML
    void loginClicked(ActionEvent event){
            if(!isPasswordFieldOn){
                isPasswordFieldOn = loginHelper.handlePhoneNumberValidation(numberField, validateUserLabel);
            }else{
                try {
                    loginHelper.handlePasswordValidation();
                //    sessionManager.saveSession(session,numberField.getText() , );
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
