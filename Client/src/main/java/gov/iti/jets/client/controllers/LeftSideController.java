package gov.iti.jets.client.controllers;

import gov.iti.jets.client.util.PaneCoordinator;
import gov.iti.jets.client.util.StageCoordinator;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

public class LeftSideController implements Initializable {
    private BorderPane borderPane = new BorderPane();
    private PaneCoordinator paneCoordinator  = PaneCoordinator.getSceneCoordinator();

    private StageCoordinator stageCoordinator ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageCoordinator = StageCoordinator.getInstance();
    }

    @FXML
    private HBox information;

    @FXML
    private HBox logout;

    @FXML
    private HBox msg;

    @FXML
    private HBox notifications;

    @FXML
    private Button update;

    @FXML
    void logoutClicked(MouseEvent event) {
        stageCoordinator.switchToLoginScene();
    }

    @FXML
    void onClick(ActionEvent event){
        Notifications.create()
                .title("Feedback")
                .text("Updated")
                .darkStyle().show();
    }


    @FXML
    void showInformation(MouseEvent event) throws Exception{
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                paneCoordinator.switchToInformationPane();
                System.out.println("gg");
            }
        });
        Thread.sleep(100);
    }

    @FXML
    void showMsg(MouseEvent event) {

    }

    @FXML
    void showNotification(MouseEvent event) throws Exception{
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                paneCoordinator.switchToNotificationsPane();
                System.out.println("nn");
            }
        });
        Thread.sleep(100);
    }

}
