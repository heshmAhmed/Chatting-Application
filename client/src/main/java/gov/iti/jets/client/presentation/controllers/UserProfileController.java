package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.ProfileService;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.common.dtos.Country;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {
    private ProfileService profileService;
    private UserModel userModel;
    private ValidationSupport validationSupport;
    @FXML
    public TextField usernameField;
    @FXML
    public TextField emailField;
    @FXML
    public TextField bioField;
    @FXML
    public TextField phoneField;
    @FXML
    public ChoiceBox countryField;
    @FXML
    public DatePicker dateField;
    @FXML
    public MFXButton saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.countryField.getItems().addAll(Country.values());
        this.emailField.setDisable(true);
        this.phoneField.setDisable(true);
        validationSupport = new ValidationSupport();
        this.profileService = ProfileService.getInstance();
        this.userModel = ModelFactory.getInstance().getUserModel();
        this.usernameField.textProperty().bindBidirectional(userModel.usernameProperty());
        this.bioField.textProperty().bindBidirectional(userModel.bioProperty());
        this.countryField.valueProperty().bindBidirectional(userModel.countryProperty());
        this.emailField.textProperty().bindBidirectional(userModel.emailProperty());
        this.phoneField.textProperty().bindBidirectional(userModel.phoneNumberProperty());
        this.dateField.valueProperty().bindBidirectional(userModel.dobProperty());
    }

    

    @FXML
    void onClick(ActionEvent event){
        validationSupport.registerValidator(usernameField, Validator.createPredicateValidator(s->usernameField.getText().length()>3,"4 characters at least"));
        Notifications.create()
                .title("Feedback")
                .text("Updated")
                .darkStyle().show();
    }


    @FXML
    void showInformation(MouseEvent event) {

    }

    @FXML
    void showMsg(MouseEvent event) {

    }

    @FXML
    void showNotification(MouseEvent event) {

    }

    @FXML
    public void handleSaveButton(ActionEvent actionEvent) {
        profileService.updateProfile();
    }
}
