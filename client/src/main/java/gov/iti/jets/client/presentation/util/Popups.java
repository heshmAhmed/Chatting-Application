package gov.iti.jets.client.presentation.util;

import javafx.application.Platform;
import org.controlsfx.control.Notifications;

public class Popups {

    public static void receiveNotification(String title,String body){

        System.out.println("notification received:" + body);
       Platform.runLater( () -> Notifications.create()
                .title(title)
                .text(body)
                .threshold(3, Notifications.create().title("Collapsed Notification"))
                .show() );
    }
}
