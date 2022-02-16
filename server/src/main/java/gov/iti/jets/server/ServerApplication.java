package gov.iti.jets.server;

import gov.iti.jets.common.server.IRemoteLoginService;
import gov.iti.jets.server.network.RemoteLoginServiceImpl;
import gov.iti.jets.server.presentation.util.StageCoordinator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerApplication extends Application {
    static Registry  registry;
    StageCoordinator sceneCoordinator = StageCoordinator.getInstance();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loginViewLoader = new FXMLLoader(ServerApplication.class.getResource("/views/login/LoginView.fxml"));
        Pane loginPane = loginViewLoader.load();
        Scene scene = new Scene(loginPane);
        sceneCoordinator.init(stage, scene);
        stage.setMinWidth(1000);
        stage.setMinHeight(600);
        stage.setTitle("Hello Admin!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) throws RemoteException {
        launch();
        Registry registry = LocateRegistry.createRegistry(3000);

        IRemoteLoginService iRemoteLoginService = (IRemoteLoginService) new RemoteLoginServiceImpl();
        registry.rebind("RemoteLoginService", iRemoteLoginService);

    }


}