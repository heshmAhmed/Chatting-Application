package gov.iti.jets.client.presentation.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class InvitationController implements Initializable {

    @FXML
    private MFXButton addButton;

    @FXML
    private Circle circle;

    @FXML
    private Label countryLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private MFXButton removeButton;

    @FXML
    private Label timeLabel;

    @FXML
    void handelAddButton(ActionEvent event) {

    }

    @FXML
    void handelRemoveButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
