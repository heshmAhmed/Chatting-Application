package gov.iti.jets.client.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PaneCoordinator {
    private static final PaneCoordinator PANE_COORDINATOR = new PaneCoordinator();
    private BorderPane borderPane;
    private Map<String, Pane> map;
    private final String USER_INFO = "USER_INFO";
    private final String USER_INFO_PATH = "/views/userProfile/UserInfoView.fxml";
    private final String NOTIFICATIONSLIST = "NOTIFICATIONSLIST";
    private final String NOTIFICATIONSLIST_PATH = "/views/notifications/NotificationsListView.fxml";

    private PaneCoordinator() {
    }

    public static PaneCoordinator getSceneCoordinator() {
        return PANE_COORDINATOR;
    }

    public void init(BorderPane borderPane) {
        this.borderPane = borderPane;
        this.map = new HashMap<>();
    }

    public void switchToInformationPane() {
        Pane pane = map.get(USER_INFO);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(USER_INFO_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(USER_INFO, pane);
        }
        this.borderPane.setCenter(pane);
    }

    public void switchToNotificationsPane() {
        Pane pane = map.get(NOTIFICATIONSLIST);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(NOTIFICATIONSLIST_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(NOTIFICATIONSLIST, pane);
        }
        this.borderPane.setCenter(pane);
    }
}
