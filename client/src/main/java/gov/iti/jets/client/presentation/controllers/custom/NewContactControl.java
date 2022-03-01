package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.network.service.ContactService;
import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.client.presentation.util.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class NewContactControl extends ToolBar {
    private StageCoordinator stageCoordinator;
    private List<String> contactList;
    private Validation validation;
    private UserModel userModel;
    private ContactListHelper contactListHelper;
    private LoginService loginService;
    private ContactService contactService;
    @FXML
    private TextField phoneNumberField;
    @FXML
    public VBox vbox;
    @FXML
    private Label phoneNumberLabel;
    @FXML
    private Button sendButton;

    public NewContactControl() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/newcontact/NewContactViewControl.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initialize() {
        this.stageCoordinator = StageCoordinator.getInstance();
        this.contactList = new ArrayList<>();
        this.validation = Validation.getInstance();
        this.userModel = ModelFactory.getInstance().getUserModel();
        this.contactListHelper = ContactListHelper.getInstance();
        this.loginService = LoginService.getInstance();
        this.contactService = ContactService.getInstance();
        this.sendButton.setDisable(true);
    }

    @FXML
    void handleCloseIcon() {
        stageCoordinator.closeAddNewContactPopup();
    }

    @FXML
    void handlePlusIcon(MouseEvent event) throws RemoteException {
        //validate phone as regex & same phone case
        if(!validation.validatePhoneNumber(userModel.getPhoneNumber(), phoneNumberField, phoneNumberLabel))
            return;
        // check if phone already exist in the contact list
        else if(contactListHelper.checkIfPhoneExist(phoneNumberField.getText())){
            phoneNumberLabel.setText("Contact already exist!");
            return;
        }
        // check if phone number is in the system
        else if(loginService.validatePhoneNumber(phoneNumberField.getText())) {
            if(!this.contactList.contains(phoneNumberField.getText())) {
                this.contactList.add(phoneNumberField.getText());
                this.sendButton.setDisable(false);
                this.addPhoneNumberToVbox();
            }
            this.phoneNumberField.setText("");
        } else {
            this.phoneNumberLabel.setText("Phone number does not exist!");
        }
    }

    @FXML
    void handlePhoneNumberField(ActionEvent event) {

    }

    @FXML
    public void handleSendButton(ActionEvent actionEvent) {
        contactService.sendInvitations(contactList);
        stageCoordinator.closeAddNewContactPopup();
    }

    @FXML
    public void  handleOnMouseDragged(MouseEvent mouseEvent) {

    }

    @FXML
    public void handleOnMousePressed(MouseEvent mouseEvent) {

    }

    private void validateAddedPhoneNumber() {
        if(validation.validatePhoneNumber(userModel.getPhoneNumber(), phoneNumberField, phoneNumberLabel)
                && contactListHelper.checkIfPhoneExist(phoneNumberField.getText())) {
            phoneNumberLabel.setText("Contact already exist!");
        }
    }

    private void addPhoneNumberToVbox() {
        Label label = new Label(phoneNumberField.getText());
        label.setStyle("-fx-background-color: white");
        this.vbox.getChildren().add(label);
    }


}
