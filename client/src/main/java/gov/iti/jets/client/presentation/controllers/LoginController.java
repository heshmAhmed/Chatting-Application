package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.controllers.custom.PasswordFieldControl;
import gov.iti.jets.client.presentation.util.LoginHelper;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.rmi.RemoteException;


public class LoginController {
    private final StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private final LoginService myLoginService = LoginService.getInstance();
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
        skipHyperlink.setTextFill(Color.LIGHTBLUE);
        validateUserLabel.setTextFill(Color.web("#e40808"));
        validatePasswordLabel.setTextFill(Color.web("#e40808"));
        passwordPlaceholderHBox.getChildren().add(validateUserLabel);
        loginButton.setText("next");
        isPasswordFieldOn = false;
        numberField.setOnMouseClicked(event -> {validateUserLabel.setText("");});
    }

    @FXML
    void loginClicked(ActionEvent event) throws RemoteException {
        Platform.runLater(()->{
            if(!isPasswordFieldOn){
                isPasswordFieldOn = loginHelper.handlePhoneNumberValidation(numberField, validateUserLabel);
            }else{
                try {
                    loginHelper.handlePasswordValidation();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @FXML
    void registerClicked(ActionEvent event) {
        stageCoordinator.switchToRegistrationScene();
    }
}
