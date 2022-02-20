package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.RegistrationService;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.client.presentation.util.Validation;
import gov.iti.jets.common.dtos.UserDTO;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class RegistrationController implements Initializable {
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private Validation validation = Validation.getInstance();
    private RegistrationService service;
    private UserModel userModel = new UserModel();
    UserDTO user = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderBox.getItems().addAll("Male", "Female");
        countryBox.getItems().addAll("Egypt", "Iran", "Syria");
        service = RegistrationService.getInstance();
        datePicker.setValue(LocalDate.of(2011,10,1));
        datePicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.of(2011,10,1)) > 0 );
            }
        });
    }

    @FXML
    private ComboBox genderBox , countryBox;

    @FXML
    private PasswordField passwordField , confirmPasswordField;

    @FXML
    private TextField phoneField , nameField , emailField ;

    @FXML
    private MFXButton register , haveAccountLink;

    @FXML
    private Label validateLabel , countryLabel ,genderLabel , dateLabel , phoneLabel , nameLabel , emailLabel , confirmPasswordLabel , passwordLabel ;

    @FXML
    private DatePicker datePicker;


    @FXML
    void handelRegisterAction(ActionEvent event) {
        boolean check = false;
        if (validation.validateUserName(nameField, nameLabel) &&
                validation.validatePhoneNumber(phoneField, phoneLabel) &&
                validation.validateEmail(emailField, emailLabel) &&
                validation.validatePassword(passwordField, passwordLabel) &&
                validation.validateConfirmPassword(confirmPasswordField, passwordField, confirmPasswordLabel) &&
                validation.validateGenderBox(genderBox,genderLabel) &&
                validation.validateDateOfBirth(datePicker,dateLabel) &&
                validation.validateCountryBox(countryBox,countryLabel)){

            String name = nameField.getText();
            String phone = phoneField.getText();
            String password = passwordField.getText();
            String confirmedPassword = confirmPasswordField.getText();
            String email = emailField.getText();
            String country = (String) countryBox.getValue();
            String gender = (String) genderBox.getValue();
            LocalDate dob =  datePicker.getValue().minusYears(10);
            Long dobLong = dob.toEpochDay();

            user = new UserDTO(phone,email,name,password,gender,dobLong,country);

            check = service.createNewUser(user);
            System.out.println(check);
            if(check){
                System.err.println("Succissful reg");
                stageCoordinator.switchToLoginScene();
            }else{
                System.err.println("not succissful");
                validateLabel.setText("Already exists");
            }
        }else{
            System.out.println(check);
        }
    }


    @FXML
    void handelHaveAccountAction(ActionEvent event) {
        stageCoordinator.switchToLoginScene();
    }
}
