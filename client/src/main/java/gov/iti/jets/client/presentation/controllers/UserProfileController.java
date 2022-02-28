package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.ProfileService;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.common.dtos.Country;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserProfileController implements Initializable {
    private ProfileService profileService;
    private UserModel userModel;
    private ValidationSupport validationSupport;
    @FXML
    public TextField usernameField;
    @FXML
    public TextField emailField;
    @FXML
    public TextArea bioTextArea;
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
        this.countryField.getItems().addAll(Stream.of(Country.values()).map(Enum::name).collect(Collectors.toList()));
        this.emailField.setDisable(true);
        this.phoneField.setDisable(true);
        this.validationSupport = new ValidationSupport();
        this.profileService = ProfileService.getInstance();
        this.userModel = ModelFactory.getInstance().getUserModel();
        this.usernameField.textProperty().bindBidirectional(userModel.usernameProperty());
        this.bioTextArea.textProperty().bindBidirectional(userModel.bioProperty());
        this.countryField.valueProperty().bindBidirectional(userModel.countryProperty());
        this.emailField.textProperty().bindBidirectional(userModel.emailProperty());
        this.phoneField.textProperty().bindBidirectional(userModel.phoneNumberProperty());
        this.dateField.valueProperty().bindBidirectional(userModel.dobProperty());
        dateField.setValue(LocalDate.of(2011,10,1));
        dateField.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.of(2011,10,1)) > 0 );
            }
        });
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
        String errorMsg = "4 characters at least";
        if(!validationSupport.
                registerValidator(usernameField, Validator.createPredicateValidator(s->usernameField.getText().length()>3,errorMsg)))
        {
            profileService.updateProfile();
            Notifications.create()
                .title("Feedback")
                .text("Updated")
                .show();
        }
    }
}
