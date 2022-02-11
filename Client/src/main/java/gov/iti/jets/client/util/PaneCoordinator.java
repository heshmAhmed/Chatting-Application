package gov.iti.jets.client.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PaneCoordinator {
    private static final PaneCoordinator paneCoordinator = new PaneCoordinator();
    private BorderPane borderPane;
    private Map<String, Pane> map;
    private final String USER_INFO_PANE = "USER_INFO_SCENE";
    private final String USER_INFO_PANE_PATH = "/views/userProfile/UserInfoView.fxml";

    private final String NOTIFICATIONS_LIST_PANE = "NOTIFICATIONS_LIST_PANE";
    private final String NOTIFICATIONS_LIST_PATH = "/views/notifications/NotificationsListView.fxml";

    private final String INVITATIONS_LIST_PANE = "INVITATIONS_LIST_PANE";
    private final String INVITATIONS_LIST_PATH = "/views/invitations/InvitationsListView.fxml";

    private PaneCoordinator() {
    }

    public static PaneCoordinator getInstance() {
        return paneCoordinator;
    }

    public void init(BorderPane borderPane) {
        this.borderPane = borderPane;
        this.map = new HashMap<>();
    }

    public void switchToUserInfoPane() {
        Pane pane = map.get(USER_INFO_PANE);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(USER_INFO_PANE_PATH)));
                map.put(USER_INFO_PANE, pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.borderPane.setCenter(pane);
    }

    public void switchToNotificationsPane() {
        Pane pane = map.get(NOTIFICATIONS_LIST_PANE);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(NOTIFICATIONS_LIST_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(NOTIFICATIONS_LIST_PANE, pane);
        }
        this.borderPane.setCenter(pane);
    }

    public void switchToInvitationsPane() {
        Pane pane = map.get(INVITATIONS_LIST_PANE);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(INVITATIONS_LIST_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(INVITATIONS_LIST_PANE, pane);
        }
        this.borderPane.setCenter(pane);
    }
}
