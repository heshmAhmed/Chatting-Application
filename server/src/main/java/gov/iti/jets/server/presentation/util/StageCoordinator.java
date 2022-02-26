package gov.iti.jets.server.presentation.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StageCoordinator {
    private static final StageCoordinator stageCoordinator = new StageCoordinator();
    private PaneCoordinator paneCoordinator;
    private Stage stage;
    private final String SIDEBAR_VIEW_PATH = "/views/dashboard/sidebar/SidebarView.fxml";
    private Scene sideBarScene;
    private Scene loginScene;
    private final Map<String, Scene> sceneMap = new HashMap<>();
    private final String CHANGE_PASSWORD_SCENE = "CHANGE_PASSWORD_SCENE";
    private final String CHANGE_PASSWORD_PATH = "/views/login/ChangePasswordView.fxml";

    private StageCoordinator() {
    }

    public static StageCoordinator getInstance() {
        return stageCoordinator;
    }

    public void init(Stage stage, Scene loginScene) {
        this.stage = stage;
        this.loginScene = loginScene;
        this.paneCoordinator = PaneCoordinator.getPaneCoordinator();
    }

    public void switchToLoginScene() {
        this.stage.setScene(loginScene);
    }

    public void switchToDashboardScene() {
        if(sideBarScene == null) {
            try {
                BorderPane borderPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(SIDEBAR_VIEW_PATH)));
                sideBarScene = new Scene(borderPane);
                this.paneCoordinator.init(borderPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.paneCoordinator.switchToStaticsPane();
        this.stage.setScene(sideBarScene);
    }

    public void switchToChangePasswordScene(){
        Scene changePasswordScene = sceneMap.get(CHANGE_PASSWORD_SCENE);
        if (changePasswordScene == null){
            try {
                Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(CHANGE_PASSWORD_PATH)));
                changePasswordScene = new Scene(root);
                sceneMap.put(CHANGE_PASSWORD_SCENE, changePasswordScene);
            } catch (IOException e) {
                e.printStackTrace();
            }     }
        stage.setScene(changePasswordScene);
    }

}