package gov.iti.jets.client;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/* folders & packages start with small letter
 *  naming camelCase functions/variables/.......
 *  Files(java - fxml) PascalCase  => start with capital => same like classes names
 *  files(html - css) kabab-case  ex:profile-picture
 *  no push
 *  views files must end with View
 *  Controllers naming => subj+Controller no view with it ex: LoginController not LoginViewController
 */

public class ClientApplication extends Application {
    private final StageCoordinator stageCoordinator = StageCoordinator.getInstance();

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loginViewLoader = new FXMLLoader(ClientApplication.class.getResource("/views/login/LoginView.fxml"));
        Scene scene = new Scene(loginViewLoader.load());
        stageCoordinator.init(primaryStage);
        primaryStage.setTitle("Hello Client");
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(950);
        primaryStage.setMinHeight(630);
        primaryStage.show();
    }

    public static void main(String[] args) throws RemoteException {
        launch();
    }
}

