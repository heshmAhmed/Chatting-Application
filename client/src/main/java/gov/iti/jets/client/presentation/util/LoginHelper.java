package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.controllers.custom.PasswordFieldControl;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.io.File;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class LoginHelper implements Initializable {

    HBox passwordPlaceHolderHBox;
    Label validatePasswordLabel;
    Label validateUserLabel;
    TextField numberField;
    Button loginButton;

    private PasswordFieldControl passwordFieldControl;
    Validation validation = Validation.getInstance();
    ModelFactory modelFactory = ModelFactory.getInstance();
    LoginService myLoginService = LoginService.getInstance();
    StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private SessionManager sessionManager = SessionManager.getInstance();
    File session = sessionManager.createSession();
    private static int COUNTER = 0 ;

    public LoginHelper(HBox passwordPlaceHolderHBox, Label validatePasswordLabel, Button loginButton){
        this.passwordPlaceHolderHBox = passwordPlaceHolderHBox;
        this.validatePasswordLabel = validatePasswordLabel;
        this.loginButton = loginButton;
    }

    public PasswordFieldControl getPasswordFieldControl(){
        return passwordFieldControl;
    }


    public boolean handlePhoneNumberValidation(TextField numberField, Label validateUserLabel){
        this.validateUserLabel = validateUserLabel;
        this.numberField = numberField;
        if (validation.validatePhoneNumber(numberField,validateUserLabel)) {
            try {
               return checkPhoneNumberValidity(numberField);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkPhoneNumberValidity(TextField numberField) throws RemoteException {
        String phoneNumber = numberField.getText();
        if (myLoginService.validatePhoneNumber(phoneNumber)) {
            passwordFieldControl = new PasswordFieldControl(validatePasswordLabel);
            passwordPlaceHolderHBox.getChildren().add(passwordFieldControl);
            if (COUNTER <= 0){
                numberField.setDisable(true);
                COUNTER++;
            }
            loginButton.setText("login");
            return true;
        } else {
            validateUserLabel.setText("Phone number not registered!!");
            return false;
        }
    }

    public void handlePasswordValidation() throws RemoteException {
        if(myLoginService.validatePassword(numberField.getText(),passwordFieldControl.getPasswordFieldText())){
            myLoginService.submitLogin(numberField.getText());
            sessionManager.saveSession(session, numberField.getText(), passwordFieldControl.getPasswordFieldText());
            stageCoordinator.switchToChatScene();
            passwordFieldControl.setPasswordFieldText("");
        }
        else {
            validatePasswordLabel.setText("Wrong Password");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
