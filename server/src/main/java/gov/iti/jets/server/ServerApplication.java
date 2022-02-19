package gov.iti.jets.server;


import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.network.RemoteContactServiceImpl;
import gov.iti.jets.server.network.RemoteRegistrationServiceImpl;
import gov.iti.jets.server.network.util.RegistryManager;
import gov.iti.jets.server.presentation.util.StageCoordinator;
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
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        registryManager.createRegistry(2000);
        registryManager.publishServices();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) throws RemoteException {
        RemoteRegistrationServiceImpl service=new RemoteRegistrationServiceImpl();
        UserDTO dto = new UserDTO();

        dto.setPassword("123456");
        dto.setEmail("elsisi901@gmail.com");
        dto.setGender("m");
        dto.setPhoneNumber("01095282056");
        dto.setUsername("mohamed elsisi");
        dto.setCountry("Egypt");
        dto.setDob(new Date());

        service.createNewUser(dto);
        launch();


    }
}