package gov.iti.jets.server;

import gov.iti.jets.server.presentation.util.PaneCoordinator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ServerApplication extends Application {
    PaneCoordinator paneCoordinator = PaneCoordinator.getSceneCoordinator();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader sidebarLoader = new FXMLLoader(ServerApplication.class.getResource("/views/sidebar/SidebarView.fxml"));
        BorderPane borderPane = sidebarLoader.load();
        Scene scene = new Scene(borderPane);
        paneCoordinator.init(borderPane);
        paneCoordinator.switchToStaticsPane();

        stage.setMinWidth(600);
        stage.setMinHeight(600);
        stage.setTitle("Hello Admin!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}