package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.presentation.controllers.custom.GroupControl;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private final GroupListHelper groupListHelper = GroupListHelper.getInstance();

    private UserModel userModel;

    private List<String> addedContactsList;

    @FXML
    private ListView<HBox> groupListView;

    @FXML
    private ListView<HBox> contactListView;

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
//      userPhotoCircle.addEventHandler(MouseEvent mouseEvent);
        /////////testing sending message
        contactListView.setItems(contactListHelper.getContactList());
        groupListView.setItems(groupListHelper.getGroupList());
        this.userModel = ModelFactory.getInstance().getUserModel();
        this.userNameLabel.textProperty().bindBidirectional(userModel.usernameProperty());
    }

    public void handleAddNewContactIcon(MouseEvent mouseEvent) {
        stageCoordinator.showAddNewContactPopup();
    }

    public void handleProfileIcon(MouseEvent mouseEvent) {
        stageCoordinator.switchToUserProfileScene();
    }

    public void handleAddNewGroupIcon(MouseEvent mouseEvent) {

        stageCoordinator.showAddNewGroupPopup();

//        ObservableList<HBox> list = FXCollections.observableArrayList();
//        list.add(new GroupControl("hello"));
//        groupListView.setItems(list);
    }
}
