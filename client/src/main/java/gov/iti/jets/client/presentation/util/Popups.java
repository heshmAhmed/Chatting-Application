package gov.iti.jets.client.presentation.util;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.controlsfx.control.Notifications;

public class Popups {

    public static void receiveNotification(String title,String body){
        Platform.runLater( () -> Notifications.create()
                .title(title)
                .text(body)
                .threshold(3, Notifications.create().title("Collapsed Notification"))
               .show() );
    }

    public static void alert(String alertBody){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(alertBody);
            alert.setTitle("☠");
            alert.setHeaderText("Server says");
            alert.showAndWait()
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> System.exit(0));
        }

}
