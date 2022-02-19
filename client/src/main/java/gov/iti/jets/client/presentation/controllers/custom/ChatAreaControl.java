package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.network.service.SendMessageService;
import gov.iti.jets.common.dtos.MessageDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class ChatAreaControl extends BorderPane {

    SendMessageService sendMessageService = SendMessageService.getInstance();

    @FXML
    private final ObservableList<HBox> list;


    @FXML
    private MenuButton attachButton;

    @FXML
    private MenuItem attachMenuItem1;

    @FXML
    private MenuItem attachMenuItem2;

    @FXML
    private MenuItem blockContactAction;

    @FXML
    private VBox chatAreaVBox;

    @FXML
    private Label currentChatName;

    @FXML
    private MenuButton currentChatOptionsMenuButton;

    @FXML
    private Circle currentChatPhotoCircle;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button sendMessageButton;

    @FXML
    private ListView<HBox> chatAreaListView;

    public ChatAreaControl(ObservableList<HBox> list){
        this.list = list;


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/chatareaview/chat-area-view.fxml"));

        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        chatAreaListView.setItems(list);
    }

    public void initialize(){
        sendMessageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (EventHandler<MouseEvent>) e-> {
            String message = messageTextArea.getText();
            MessageDTO myMessageDTO = new MessageDTO();

            myMessageDTO.setMessageText(message);
            myMessageDTO.setReceiverId("12345123456");
            myMessageDTO.setSenderId("11111111111");


            if(!(message.equals(""))){
                list.add(new SentMessageControl(myMessageDTO));
                sendMessageService.sendMessage(myMessageDTO);
                messageTextArea.setText("");
            }
        });
    }


    public void addMessageToArea(MessageDTO messageDTO){

        chatAreaVBox.getChildren().add( (Pane)new SentMessageControl(messageDTO));
    }



}
