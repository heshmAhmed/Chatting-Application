package gov.iti.jets.server.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBoardController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private Button announcementButton;

    @FXML
    private BarChart<?, ?> countryChart;

    @FXML
    private Label femaleLabel;

    @FXML
    private Button logoutButton;

    @FXML
    private Label maleLabel;

    @FXML
    private Label ofFlineButton;

    @FXML
    private Button offButton;

    @FXML
    private Button onButton;

    @FXML
    private Label onlineLabel;

    @FXML
    private Button overViewButton;

    @FXML
    private Button usersButton;

    @FXML
    void handleAnnouncement(ActionEvent event) {

    }

    @FXML
    void handleLogout(ActionEvent event) {

    }

    @FXML
    void handleOff(ActionEvent event) {

    }

    @FXML
    void handleOn(ActionEvent event) {

    }

    @FXML
    void handleOverView(ActionEvent event) {

    }

    @FXML
    void handleUsers(ActionEvent event) {

    }


}
