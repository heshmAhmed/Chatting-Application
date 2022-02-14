package gov.iti.jets.server.presentation.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable {

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private Button sendButton;

    @FXML
    private Label maleLabel;

    @FXML
    void handleSend(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
