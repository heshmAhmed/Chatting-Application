package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.controllers.custom.PasswordFieldControl;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.client.presentation.util.Validation;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.rmi.RemoteException;


public class LoginController{
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    LoginService myLoginService = LoginService.getInstance();

    boolean isPasswordkFieldOn;

    PasswordFieldControl passwordFieldControl;

    @FXML
    private Label loginLabel;

    @FXML
    private Label passwordLabel;


    @FXML
    private TextField numberField;

    @FXML
    private MFXButton forgetPasswordButton;

    @FXML
    private MFXButton loginButton;

    @FXML
    private MFXButton registerButton;

    @FXML
    private HBox PasswordPlaceholderHBox;

    @FXML
    private Hyperlink skipHyperlink;

    @FXML
    void handleSkipHyperLink(ActionEvent event) {
        System.out.println("skip");
    }

    private Label notValidLabel = new Label("");



    public void initialize(){

        skipHyperlink.setTextFill(Color.LIGHTBLUE);
        notValidLabel.setTextFill(Color.web("#ffffff"));
        passwordLabel.setTextFill(Color.web("#ffffff"));
        PasswordPlaceholderHBox.getChildren().add(notValidLabel);
        loginButton.setText("next");
        isPasswordkFieldOn = false;
        numberField.setOnMouseClicked(event -> {notValidLabel.setText("");});
    }


    @FXML
    void loginClicked(ActionEvent event) throws RemoteException {
        String phoneNumber = null;

        if(!isPasswordkFieldOn){
            phoneNumber = numberField.getText();

            if (Validation.validatePhoneNumber(numberField,notValidLabel)) {
                    checkPhoneNumberValidity(phoneNumber);
            }

        }else{

            if(myLoginService.validatePassword(phoneNumber,passwordFieldControl.getPasswordFieldText())){
                stageCoordinator.switchToChatScene();
            }
            else
            {
                passwordLabel.setText("Wrong Password");
            }

        }
    }

    private void checkPhoneNumberValidity(String phoneNumber) throws RemoteException {

        if (myLoginService.validatePhoneNumber(phoneNumber)) {

            passwordFieldControl = new PasswordFieldControl(passwordLabel);
            PasswordPlaceholderHBox.getChildren().add(passwordFieldControl);
            numberField.setDisable(true);
            loginButton.setText("login");
            isPasswordkFieldOn = true;

        } else {
            notValidLabel.setText("Phone number not registered!!");
        }
    }


    @FXML
    void registerClicked(ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();
    }

}
