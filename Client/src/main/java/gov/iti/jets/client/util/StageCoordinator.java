package gov.iti.jets.client.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.Pane;
import java.io.IOException;

public class StageCoordinator {
    private static final StageCoordinator stageCoordinator = new StageCoordinator();
    private Stage primaryStage;
    private final Map<String, Scene> sceneMap = new HashMap<>();
    private StageCoordinator(){

    }

    public static StageCoordinator getInstance(){
        return stageCoordinator;
    }

    public void initStage(Stage primaryStage){
        this.primaryStage = primaryStage;

    }

    public void switchToLoginScene(){
      Scene loginScene = sceneMap.get("loginView");
     if (loginScene == null){
           try {
              Pane root = FXMLLoader.load(getClass().getResource("/views/login/LoginView.fxml"));
              loginScene = new Scene(root);
              sceneMap.put("loginScene", loginScene);
          } catch (IOException e) {
              e.printStackTrace();
          }     }

       primaryStage.setScene(loginScene);
}



    public void switchToRegistrationScene(){
       Scene registrationScene = sceneMap.get("registrationScene");
        if (registrationScene == null){
            try {
                Pane root = FXMLLoader.load(getClass().getResource("/views/registration/RegistrationView.fxml"));
                registrationScene = new Scene(root);
                sceneMap.put("registrationScene", registrationScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        primaryStage.setScene(registrationScene);
    }



  //  public void switchToProfileScene(){


  //  }


}