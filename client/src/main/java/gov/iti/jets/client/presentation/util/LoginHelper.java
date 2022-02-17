package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.controllers.custom.PasswordFieldControl;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.w3c.dom.Text;

import java.rmi.RemoteException;

public class LoginHelper{

    ModelFactory modelFactory = ModelFactory.getInstance();

    HBox passwordPlaceHolderHBox;
    Label validatePasswordLabel;
    Label validateUserLabel;
    Button loginButton;
    TextField numberField;
    PasswordFieldControl passwordFieldControl;
    StageCoordinator stageCoordinator = StageCoordinator.getInstance();

    LoginService myLoginService = LoginService.getInstance();

    public LoginHelper(HBox passwordPlaceHolderHBox, Label validatePasswordLabel, Button loginButton){
        this.passwordPlaceHolderHBox = passwordPlaceHolderHBox;
        this.validatePasswordLabel = validatePasswordLabel;
        this.loginButton = loginButton;
    }


    public boolean handlePhoneNumberValidation(TextField numberField, Label validateUserLabel){
        this.validateUserLabel = validateUserLabel;
        this.numberField = numberField;
        if (Validation.validatePhoneNumber(numberField,validateUserLabel)) {
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
            numberField.setDisable(true);
            loginButton.setText("login");
            return true;
        } else {
            validateUserLabel.setText("Phone number not registered!!");
            return false;
        }
    }



    public void handlePasswordValidation() throws RemoteException {

        if(myLoginService.validatePassword(numberField.getText(),passwordFieldControl.getPasswordFieldText())){
//                password validated

            myLoginService.submitLogin(numberField.getText());
            stageCoordinator.switchToChatScene();
        }
        else
        {
            validatePasswordLabel.setText("Wrong Password");
        }
    }

}
