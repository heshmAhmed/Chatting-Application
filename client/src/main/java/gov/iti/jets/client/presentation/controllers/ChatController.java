package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.network.service.ProfileService;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.common.dtos.Status;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    private final StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private final ContactListHelper contactListHelper = ContactListHelper.getInstance();
    private ProfileService profileService;
    private List<String> addedContactsList;
    private MenuItem availableMenuItem;
    private MenuItem busyMenuItem;
    private MenuItem awayMenuItem;
    private MenuItem offlineMenuItem;
    private ContextMenu contextMenu;
    private UserModel userModel;
    @FXML
    private ListView<HBox> contactListView;

    @FXML
    private Button statusButton;

    @FXML
    private Circle statusIcon;

    @FXML
    private Button addNewContactButton;

    @FXML
    private VBox contactListVBox;

    @FXML
    private Button profileButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label userNameLabel;

    @FXML
    private Circle userPhotoCircle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.profileService = ProfileService.getInstance();
        this.userModel = ModelFactory.getInstance().getUserModel();
        statusIcon.fillProperty().bindBidirectional(userModel.statusIconPropertyProperty().get().fillProperty());
        contactListView.setItems(contactListHelper.getContactList());
        this.userPhotoCircle.fillProperty().bindBidirectional(userModel.userImageCircleProperty().get().fillProperty());
        createContextMenu();
        handleEventsOnMenuItems();
    }

    private void createContextMenu() {
        this.contextMenu = new ContextMenu();
        this.availableMenuItem = new MenuItem(Status.AVAILABLE.name());
        this.awayMenuItem = new MenuItem(Status.AWAY.name());
        this.busyMenuItem = new MenuItem(Status.BUSY.name());
        this.offlineMenuItem = new MenuItem(Status.OFFLINE.name());
        this.contextMenu.getItems().add(availableMenuItem);
        this.contextMenu.getItems().add(awayMenuItem);
        this.contextMenu.getItems().add(busyMenuItem);
        this.contextMenu.getItems().add(offlineMenuItem);
    }

    private void handleEventsOnMenuItems() {
        this.availableMenuItem.setOnAction(event -> profileService.changeStatus(Status.AVAILABLE));
        this.awayMenuItem.setOnAction(event -> profileService.changeStatus(Status.AWAY));
        this.busyMenuItem.setOnAction(event -> profileService.changeStatus(Status.BUSY));
        this.offlineMenuItem.setOnAction(event -> profileService.changeStatus(Status.OFFLINE));
    }

    @FXML
    private void handleStatusButton(MouseEvent event) {
        this.contextMenu.show(this.statusButton, event.getScreenX() + 5, event.getScreenY() + 5);
    }
    public void handleAddNewContactIcon(MouseEvent mouseEvent) {
        stageCoordinator.showAddNewContactPopup();
    }

    public void handleProfileIcon(MouseEvent mouseEvent) {
        stageCoordinator.switchToUserProfileScene();
    }

    public void handleStatusIcon(MouseEvent mouseEvent) {
    }


}
