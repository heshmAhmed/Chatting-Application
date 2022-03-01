package gov.iti.jets.server;


import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteProfileService;
import gov.iti.jets.server.network.RemoteContactServiceImpl;
import gov.iti.jets.server.network.RemoteLoginServiceImpl;
import gov.iti.jets.server.network.RemoteProfileServiceImpl;
import gov.iti.jets.server.network.RemoteRegistrationServiceImpl;
import gov.iti.jets.server.network.util.RegistryManager;
import gov.iti.jets.server.presentation.util.StageCoordinator;
import gov.iti.jets.server.services.impls.LoginServiceImpl;
import gov.iti.jets.server.services.impls.ProfileServiceImpl;
import gov.iti.jets.server.services.interfaces.ILoginService;
import gov.iti.jets.server.services.interfaces.IProfileService;
import gov.iti.jets.server.services.util.ServiceFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Date;


public class ServerApplication extends Application {
    private StageCoordinator sceneCoordinator = StageCoordinator.getInstance();
    private final RegistryManager registryManager = RegistryManager.getInstance();

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
        stage.setMinWidth(1140);
        stage.setMinHeight(720);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        registryManager.startServer();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        registryManager.stopServer();
    }

    public static void main(String[] args) throws RemoteException {
        launch();
    }
}