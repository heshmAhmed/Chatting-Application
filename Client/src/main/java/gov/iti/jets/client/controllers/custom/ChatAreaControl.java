package gov.iti.jets.client.controllers.custom;

import gov.iti.jets.client.dtos.ContactDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class ChatAreaControl extends BorderPane {

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

    public ChatAreaControl(ContactDTO contactDTO){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/chatareaview/chat-area-view.fxml"));

        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public void initialize(){

    }
}
