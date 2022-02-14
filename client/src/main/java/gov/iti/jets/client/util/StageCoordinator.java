package gov.iti.jets.client.util;

import gov.iti.jets.client.controllers.custom.ChatAreaControl;
import gov.iti.jets.client.controllers.custom.NewContactControl;
import gov.iti.jets.client.models.ContactDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;

import javafx.scene.layout.Pane;
import java.io.IOException;

public class StageCoordinator {
    private static final StageCoordinator stageCoordinator = new StageCoordinator();
    private PaneCoordinator paneCoordinator;
    private Stage primaryStage;
    private final Map<String, Scene> sceneMap = new HashMap<>();
    private final String LEFT_SIDE_SCENE = "LEFT_SIDE_SCENE";
    private final String LEFT_SIDE_SCENE_PATH = "/views/userProfile/LeftSideView.fxml";
    private final String LOGIN_SCENE = "LOGIN_SCENE";
    private final String LOGIN_SCENE_PATH = "/views/login/LoginView.fxml";
    private final String REGISTRATION_SCENE = "REGISTRATION_SCENE";
    private final String REGISTRATION_SCENE_PATH = "/views/registration/RegistrationView.fxml";
    private final String CHAT_SCENE = "CHAT_SCENE";
    private final String CHAT_SCENE_PATH = "/views/chatWindow/ChatView.fxml";
//    private final String ADD_NEW_CONTACT = "ADD_NEW_CONTACT";
    private final String ADD_NEW_CONTACT_PATH = "/views/newcontact/NewContactView.fxml";

    private StageCoordinator(){
    }

    public static StageCoordinator getInstance(){
        return stageCoordinator;
    }

    public void init(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.paneCoordinator = PaneCoordinator.getInstance();

    }

    public void switchToUserProfileScene() {
        Scene leftSideScene = sceneMap.get(LEFT_SIDE_SCENE);
        if(leftSideScene == null) {
            try {
                BorderPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(LEFT_SIDE_SCENE_PATH)));
                leftSideScene = new Scene(root);
                paneCoordinator.init(root);
                sceneMap.put(LEFT_SIDE_SCENE, leftSideScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        paneCoordinator.switchToUserInfoPane();
        primaryStage.setScene(leftSideScene);
    }

    public void switchToLoginScene(){
      Scene loginScene = sceneMap.get(LOGIN_SCENE);
     if (loginScene == null){
           try {
              Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(LOGIN_SCENE_PATH)));
              loginScene = new Scene(root);
              sceneMap.put(LOGIN_SCENE, loginScene);
          } catch (IOException e) {
              e.printStackTrace();
          }     }
         primaryStage.setScene(loginScene);
    }

    public void switchToRegistrationScene(){
       Scene registrationScene = sceneMap.get(REGISTRATION_SCENE);
        if (registrationScene == null){
            try {
                Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(REGISTRATION_SCENE_PATH)));
                registrationScene = new Scene(root);
                sceneMap.put(REGISTRATION_SCENE, registrationScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        primaryStage.setScene(registrationScene);
    }

    public void switchToChatScene(){
        Scene chatScene = sceneMap.get(CHAT_SCENE);
        if (chatScene == null){
            try {
                Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(CHAT_SCENE_PATH)));
                chatScene = new Scene(root);
                sceneMap.put(CHAT_SCENE, chatScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        primaryStage.setScene(chatScene);
    }

    public void showAddNewContactPopup(List<String> addedNewContacts) {

        ScrollPane pane = new NewContactControl(addedNewContacts);

        Stage popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Add new content");

        Scene scene = new Scene(pane);
        popupWindow.setScene(scene);
        popupWindow.showAndWait();

    }

    public void showContactProfilePopup() {
        Stage popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Profile");
        try {
            Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/contactProfile/ContactProfileView.fxml"))));
            popupWindow.setScene(scene);
            popupWindow.setResizable(true);
            popupWindow.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    ////////////this is a pane coordinator task will be modified later////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setChatScene(){
        Scene chatScene = sceneMap.get(CHAT_SCENE);
        BorderPane bp = (BorderPane) chatScene.getRoot();
        ChatAreaControl chatAreaControl = new ChatAreaControl(new ContactDTO());
        bp.setCenter(chatAreaControl);
    }


}