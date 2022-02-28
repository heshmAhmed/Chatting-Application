package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.ProfileService;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.PaneCoordinator;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LeftSideController implements Initializable {
    private UserModel userModel;
    private PaneCoordinator paneCoordinator;
    private StageCoordinator stageCoordinator ;
    private FileChooser fileChooser;
    private ProfileService profileService;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label bioLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private HBox information;
    @FXML
    private HBox invitations;
    @FXML
    private HBox logout;
    @FXML
    private HBox chat;
    @FXML
    private HBox notifications;
    @FXML
    private Button update;
    @FXML
    public Circle userPhotoCircle;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageCoordinator = StageCoordinator.getInstance();
        paneCoordinator = PaneCoordinator.getInstance();
        this.userModel = ModelFactory.getInstance().getUserModel();
        this.usernameLabel.textProperty().bindBidirectional(userModel.usernameProperty());
        this.phoneLabel.textProperty().bindBidirectional(userModel.phoneNumberProperty());
        this.bioLabel.textProperty().bindBidirectional(userModel.bioProperty());
        this.userPhotoCircle.fillProperty().bindBidirectional(userModel.userImageCircleProperty().get().fillProperty());
        this.profileService = ProfileService.getInstance();
        initFileChooser();
    }

    @FXML
    void logoutClicked(MouseEvent event) {
        stageCoordinator.switchToLoginScene();
    }

    @FXML
    void onClick(ActionEvent event){
        Notifications.create()
                .title("Feedback")
                .text("Updated")
                .darkStyle().show();
    }

    @FXML
    void showInformation(MouseEvent event) {
        paneCoordinator.switchToUserInfoPane();
    }

    @FXML
    void showInvitations(MouseEvent event) {
        paneCoordinator.switchToInvitationsPane();
    }

    @FXML
    void backToChat(MouseEvent event) {
        stageCoordinator.switchToChatScene();
    }

    @FXML
    void showNotification(MouseEvent event) {
        paneCoordinator.switchToNotificationsPane();
    }

    @FXML
    public void handleChangeProfilePictureIcon(MouseEvent mouseClicked) {
        Optional<File> fileOptional = Optional.ofNullable(fileChooser.showOpenDialog(stageCoordinator.getPrimaryStage()));
        fileOptional.ifPresent(file -> {
            if(file.length() <= 3000000)
                profileService.updateProfilePicture(file, file.getName());
        });
    }
    private void initFileChooser() {
        this.fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg"));
    }
}
