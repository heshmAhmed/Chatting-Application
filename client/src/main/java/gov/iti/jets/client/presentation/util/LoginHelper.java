package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.controllers.custom.PasswordFieldControl;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import java.rmi.RemoteException;

public class LoginHelper{

    HBox passwordPlaceHolderHBox;
    Label validatePasswordLabel;
    Label validateUserLabel;
    TextField numberField;
    Button loginButton;

    PasswordFieldControl passwordFieldControl;
    Validation validation = Validation.getInstance();
    ModelFactory modelFactory = ModelFactory.getInstance();
    LoginService myLoginService = LoginService.getInstance();
    StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private static int COUNTER = 0 ;

    public LoginHelper(HBox passwordPlaceHolderHBox, Label validatePasswordLabel, Button loginButton){
        this.passwordPlaceHolderHBox = passwordPlaceHolderHBox;
        this.validatePasswordLabel = validatePasswordLabel;
        this.loginButton = loginButton;
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
            while (COUNTER <= 0){
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
            stageCoordinator.switchToChatScene();
            passwordFieldControl.setPasswordFieldText("");
        }
        else {
            validatePasswordLabel.setText("Wrong Password");
        }
    }

}
