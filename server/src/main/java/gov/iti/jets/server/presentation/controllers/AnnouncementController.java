package gov.iti.jets.server.presentation.controllers;

import gov.iti.jets.server.services.util.ServerUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.util.ResourceBundle;

public class AnnouncementController implements Initializable {
    ServerUtil servetUtil = ServerUtil.getInstance();

    @FXML
    private TextArea announcementArea;

    @FXML
    private Button sendButton;

    @FXML
    private Label maleLabel;


    @FXML
    void handleSend(ActionEvent event) {
       String announcement = announcementArea.getText();
       if(!announcement.equals("")){
//           System.out.println("announcement test from announcement controller : " + announcement);
           servetUtil.sendAnnouncement(announcement);
           announcementArea.setText("");
       }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
