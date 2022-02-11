package gov.iti.jets.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.Objects;

public class NewContactController {
    @FXML
    private TextField phoneNumberField;
    @FXML
    public VBox vbox;

    @FXML
    void handlePlusIcon(MouseEvent event) {
        try {
            Label label = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/newcontact/contact.fxml")));
            label.setText(phoneNumberField.getText());
            this.vbox.getChildren().add(label);
            phoneNumberField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handlePhoneNumberField(ActionEvent event) {

    }

    @FXML
    public void handleSendButton(ActionEvent actionEvent) {
    }
}
