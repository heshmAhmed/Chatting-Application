package gov.iti.jets.client;

import gov.iti.jets.client.network.service.LoginService;
import gov.iti.jets.client.network.service.ProfileService;
import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.SessionManager;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.server.IRemoteProfileService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

/* folders & packages start with small letter
 *  naming camelCase functions/variables/.......
 *  Files(java - fxml) PascalCase  => start with capital => same like classes names
 *  files(html - css) kabab-case  ex:profile-picture
 *  no push
 *  views files must end with View
 *  Controllers naming => subj+Controller no view with it ex: LoginController not LoginViewController
 */

public class ClientApplication extends Application {
    private LoginService loginService = LoginService.getInstance();
    private final StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private SessionManager sessionManager = SessionManager.getInstance();
    private ProfileService profileService = ProfileService.getInstance();

    File session = sessionManager.createSession();

    @Override
    public void start(Stage primaryStage) throws IOException {
        stageCoordinator.init(primaryStage);
        String str = sessionManager.readSession(session);
        String[] text = sessionManager.decryption(str);
        if(text.length == 2){
            loginService.submitLogin(text[0]);
            stageCoordinator.switchToChatScene();
        }else{
            stageCoordinator.switchToLoginScene();
        }
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(1130);
        primaryStage.show();

        Notifications.create()
                .title("Notification")
                .text("👻 hello")
                .threshold(3, Notifications.create().title("Collapsed Notification"))
                .show();


    }


    @Override
    public void stop() throws Exception {
        super.stop();

        if(ModelFactory.getInstance().getUserModel().getPhoneNumber() !=  null){
            profileService.changeStatus(Status.OFFLINE);
            profileService.logout();
        }
        System.out.println("stop called");

        System.exit(0);

    }
    public static void main(String[] args) throws RemoteException {
        launch();
    }
}

