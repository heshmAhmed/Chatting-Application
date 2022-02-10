package gov.iti.jets.server.presentation.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SceneCoordinator {
    private static final SceneCoordinator sceneCoordinator = new SceneCoordinator();
    private Scene scene;
    private Map<String, Pane> map;
    private final String ANNOUNCEMENT_VIEW = "ANNOUNCEMENT_VIEW";
    private final String USERSLIST_VIEW = "USERSLIST_VIEW";
    private final String STATICS_VIEW = "STATICS_VIEW";
    private final String ANNOUNCEMENT_VIEW_PATH = "";
    private final String USERSLIST_VIEW_PATH = "";
    private final String STATICS_VIEW_PATH = "";

    private SceneCoordinator() {
    }

    public static SceneCoordinator getSceneCoordinator() {
        return sceneCoordinator;
    }

    public void init(Scene scene) {
        this.scene = scene;
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
        this.scene.setRoot(pane);
    }

    public void switchUsersListPane() {
        Pane pane = map.get(ANNOUNCEMENT_VIEW);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(USERSLIST_VIEW_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(ANNOUNCEMENT_VIEW, pane);
        }
        this.scene.setRoot(pane);
    }

    public void switchToStaticsPane() {
        Pane pane = map.get(ANNOUNCEMENT_VIEW);
        if (pane == null) {
            try {
                pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(STATICS_VIEW_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(ANNOUNCEMENT_VIEW, pane);
        }
        this.scene.setRoot(pane);
    }
}
