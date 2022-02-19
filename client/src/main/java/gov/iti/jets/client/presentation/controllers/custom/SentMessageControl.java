package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.common.dtos.MessageDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

public class SentMessageControl extends HBox {
    MessageDTO messageDTO;

    @FXML
    private VBox messageBox;

    @FXML
    private Text textOfMessage;

    @FXML
    private Label nameLabel;

    @FXML
    private TextFlow textWrapperTextFlow;

    @FXML
    private Label timeLabel;

    public SentMessageControl(MessageDTO messageDTO){
        this.messageDTO = messageDTO;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/chatareaview/sentmessageview/SentMessageView.fxml"));

        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }


    public void initialize(){

        textOfMessage.setText(messageDTO.getMessageText());
        nameLabel.setText(messageDTO.getSenderId());
        timeLabel.setText("1-1-1999");


    }

}
