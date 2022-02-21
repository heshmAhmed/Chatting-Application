package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.presentation.controllers.custom.ContactControl;
import gov.iti.jets.client.presentation.dtos.ContactDTO;
import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.StageCoordinator;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    private StageCoordinator stageCoordinator;
    private UserModel userModel;

    List<String> addedContactsList;

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
        stageCoordinator = StageCoordinator.getInstance();
//        userPhotoCircle.addEventHandler(MouseEvent mouseEvent);
        userModel = ModelFactory.getInstance().getUserModel();
        /////////testing sending message
        ContactControl contactControl = new ContactControl();
        contactListVBox.getChildren().add(contactControl);

    }

    public void handleAddNewContactIcon(MouseEvent mouseEvent) {

        addedContactsList = new ArrayList<>();
        stageCoordinator.showAddNewContactPopup(addedContactsList);

        if(addedContactsList.size() > 0)
        {
            for(var newContact:addedContactsList){
                ContactControl contactControl = new ContactControl();
                contactListVBox.getChildren().add(contactControl);
            }
        }


    }

    public void handleProfileIcon(MouseEvent mouseEvent) {
        stageCoordinator.switchToUserProfileScene();
    }
}
