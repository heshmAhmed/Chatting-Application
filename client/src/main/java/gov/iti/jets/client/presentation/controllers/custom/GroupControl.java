package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class GroupControl extends HBox{

    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private GroupListHelper groupListHelper = GroupListHelper.getInstance();
    private GroupChatAreaControl myChatArea;
    private ObservableList<HBox> list;


    @FXML
    private HBox groupHBox;

    public Label getGroupNameLabel() {
        return groupNameLabel;
    }

    @FXML
    private Label groupNameLabel;

    @FXML
    private Circle groupPhotoCircle;

    private String groupId;

    public GroupControl(String groupId){
        this.groupId = groupId;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/groupBoxView/GroupView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void initialize(){

        list = groupListHelper.createMessageList(groupId);
        myChatArea = new GroupChatAreaControl(list, groupId);
        myChatArea.getCurrentChatName().textProperty().bind(groupNameLabel.textProperty());
        myChatArea.getCurrentChatPhotoCircle().fillProperty().bindBidirectional(groupPhotoCircle.fillProperty());
        groupHBox.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e -> stageCoordinator.setChatScene(myChatArea));
    }

    @FXML
    void handleGroupBox(MouseEvent event) {

    }

    public Circle getGroupPhotoCircle() {
        return groupPhotoCircle;
    }

    public void setGroupPhotoCircle(Circle groupPhotoCircle) {
        this.groupPhotoCircle = groupPhotoCircle;
    }
}
