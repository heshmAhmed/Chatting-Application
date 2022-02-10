package gov.iti.jets.server.presentation.util;

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
    private final String ANNOUNCEMENT_VIEW = "ANNOUNCEMENT_VIEW";
    private final String USERS_LIST_VIEW = "USERS_LIST_VIEW";
    private final String STATICS_VIEW = "STATICS_VIEW";
    private final String ANNOUNCEMENT_VIEW_PATH = "/views/announcement/AnnouncementView.fxml";
    private final String USERS_LIST_VIEW_PATH = "/views/usersList/UsersListView.fxml";
    private final String STATICS_VIEW_PATH = "/views/statics/StaticsView.fxml";

    private PaneCoordinator() {
    }

    public static PaneCoordinator getSceneCoordinator() {
        return PANE_COORDINATOR;
    }

    public void init(BorderPane borderPane) {
        this.borderPane = borderPane;
        this.map = new HashMap<>();
    }

    public void switchToAnnouncementPane() {
        Pane pane = map.get(ANNOUNCEMENT_VIEW);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(ANNOUNCEMENT_VIEW_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(ANNOUNCEMENT_VIEW, pane);
        }
        this.borderPane.setCenter(pane);
    }

    public void switchUsersListPane() {
        Pane pane = map.get(USERS_LIST_VIEW);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(USERS_LIST_VIEW_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(USERS_LIST_VIEW, pane);
        }
        this.borderPane.setCenter(pane);
    }

    public void switchToStaticsPane() {
        Pane pane = map.get(STATICS_VIEW);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(STATICS_VIEW_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(STATICS_VIEW, pane);
        }
        this.borderPane.setCenter(pane);
    }
}
