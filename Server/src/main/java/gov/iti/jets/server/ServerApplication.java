package gov.iti.jets.server;

import gov.iti.jets.server.presentation.util.SceneCoordinator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ServerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(ServerApplication.class.getResource("/views/userslist/UsersListView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        SceneCoordinator.getSceneCoordinator().init(scene);
        stage.setTitle("Hello Server!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}