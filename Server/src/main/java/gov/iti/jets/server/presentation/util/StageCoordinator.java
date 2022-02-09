package gov.iti.jets.server.presentation.util;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StageCoordinator {
    private static final StageCoordinator stageCoordinator = new StageCoordinator();
    private Stage primaryStage;
    private final Map<String, Scene> sceneMap = new HashMap<>();

    private StageCoordinator() {
    }

    public static StageCoordinator getInstance() {
        return stageCoordinator;
    }

    public void initStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }


}