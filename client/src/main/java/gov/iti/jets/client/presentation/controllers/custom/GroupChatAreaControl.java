package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.network.service.SendMessageService;
import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.stream.Stream;

public class  GroupChatAreaControl extends BorderPane{

    private final SendMessageService sendMessageService = SendMessageService.getInstance();
    UserModel userModel = ModelFactory.getInstance().getUserModel();

    @FXML
    private final ObservableList<HBox> list;

    @FXML
    private MenuButton attachButton;

    @FXML
    private MenuItem attachMenuItem1;

    @FXML
    private MenuItem attachMenuItem2;

    @FXML
    private ListView<HBox> chatAreaListView;

    @FXML
    private VBox chatAreaVBox;

    public void setCurrentChatName(Label currentChatName) {
        this.currentChatName = currentChatName;
    }

    public Label getCurrentChatName() {
        return currentChatName;
    }

    @FXML
    private Label currentChatName;

    @FXML
    private Circle currentChatPhotoCircle;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button sendMessageButton;

    private String groupId;

    public GroupChatAreaControl(ObservableList<HBox> list, String groupId){
        this.list = list;
        this.groupId = groupId;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/chatareaview/group-chat-area-view.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        chatAreaListView.setItems(list);
    }


//    public void initialize(){
//        sendMessageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (EventHandler<MouseEvent>) e-> {
//            sendMessage();
//        });
//    }
//
//
//    private void sendMessage(){
//        String message = messageTextArea.getText();
//
//        MessageDTO myMessageDTO = new MessageDTO();
//
//        myMessageDTO.setMessageText(message);
//        myMessageDTO.setReceiverId(groupId);
//        myMessageDTO.setSenderId(userModel.getPhoneNumber());
//
//        if(!(message.equals(""))){
//            list.add(new SentMessageControl(myMessageDTO));
//            sendMessageService.sendGroupMessage(myMessageDTO);
//            messageTextArea.setText("");
//        }
//    }


    @FXML
    void handleAddNewContactIcon(MouseEvent event) {

        ObservableList<String> list = FXCollections.observableArrayList();

        ModelFactory.getInstance().getContactModels().stream().forEach(c -> list.add(c.getPhoneNumber()));


        StageCoordinator.getInstance().showAddContactToGroupPopup(list);

    }

}
