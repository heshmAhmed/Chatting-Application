package gov.iti.jets.client;

import gov.iti.jets.client.util.PaneCoordinator;
import gov.iti.jets.client.util.StageCoordinator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientApplication extends Application {

    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private PaneCoordinator paneCoordinator = PaneCoordinator.getSceneCoordinator();

    @Override
    public void start(Stage primaryStage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("/views/userProfile/LeftSideView.fxml"));
        FXMLLoader leftSide = new FXMLLoader(ClientApplication.class.getResource("/views/userProfile/LeftSideView.fxml"));
        BorderPane borderPane = leftSide.load();
        Scene scene = new Scene(borderPane);
        paneCoordinator.init(borderPane);
        paneCoordinator.switchToInformationPane();

        stageCoordinator.initStage(primaryStage);
        primaryStage.setTitle("Hello Client");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

/* folders & packages start with small letter
*  naming camelCase functions/variables/.......
*  Files(java - fxml) PascalCase  => start with capital => same like classes names
*  files(html - css) kabab-case  ex:profile-picture
*  no push
*  views files must end with View
*  Controllers naming => subj+Controller no view with it ex: LoginController not LoginViewController
*/