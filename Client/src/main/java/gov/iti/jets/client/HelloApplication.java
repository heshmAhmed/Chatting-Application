package gov.iti.jets.client;

import gov.iti.jets.client.util.StageCoordinator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/views/Login/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stageCoordinator.initStage(primaryStage);
        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}