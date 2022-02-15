package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.StageCoordinator;
import gov.iti.jets.client.util.Validation;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.util.ResourceBundle;


public class RegistrationController implements Initializable {
    private StageCoordinator stageCoordinator ;
    private ValidationSupport validationSupport;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validationSupport = new ValidationSupport();
        validationSupport.setErrorDecorationEnabled(true);
        stageCoordinator = StageCoordinator.getInstance();
        genderField.getItems().addAll("Male", "Female");
        countryField.getItems().addAll("Egypt", "Iran","Syria");

    }

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private ComboBox countryField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField emailField;

    @FXML
    private ComboBox genderField;

    @FXML
    private MFXButton haveAccountLink;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private MFXButton register;




    @FXML
    void handelRegisterAction(ActionEvent event){
        System.out.println(Validation.validatePassword(passwordField));
        System.out.println(Validation.validatePhoneNumber(phoneField));
        System.out.println(Validation.validateEmail(emailField));
        System.out.println(Validation.validateUserName(nameField));
//          System.out.println(confirmPassword());
      //  System.out.println(validPhone());
//            if(validation.checkName(nameField)){
//                stageCoordinator.switchToChatScene();
//            }
    }

    private boolean validUserName(){
        validationSupport.registerValidator(nameField, Validator.createEmptyValidator("name is required"));
        validationSupport.registerValidator(nameField,Validator.createPredicateValidator(s->nameField.getText().length()<=2 ,
                "name should be 3 characters at least"));
        System.out.println(validationSupport.isInvalid());
        return validationSupport.isInvalid();
    }

    private boolean validPassword(){
        validationSupport.registerValidator(passwordField, Validator.createEmptyValidator("password is required"));
        validationSupport.registerValidator(passwordField,Validator.createPredicateValidator(s->passwordField.getText().length()<=5 ,
                "password should be 5 characters at least"));
        return validationSupport.isInvalid();
    }

    private boolean confirmPassword(){
        validationSupport.registerValidator(confirmPasswordField,Validator.createPredicateValidator(s -> confirmPasswordField.getText().equals(passwordField.getText())
                ,"password does not match password field"));
        return validationSupport.isInvalid();
    }

    //"01(0|1|2|5)\\d{8}"
    private boolean validPhone(){
      validationSupport.registerValidator(phoneField,Validator.createRegexValidator("Enter only number","01(0|1|2|5)\\d{8}", Severity.ERROR));
      return validationSupport.isInvalid();
    }

















    @FXML
    void handelHaveAccountAction(ActionEvent event) {
        stageCoordinator.switchToLoginScene();
    }
}
