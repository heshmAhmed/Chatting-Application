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
    String message;

    @FXML
    private VBox messageBox;

    @FXML
    private Text textOfMessage;

    @FXML
    private TextFlow textWrapperTextFlow;

    @FXML
    private Label timeLabel;

    public SentMessageControl(MessageDTO messageDTO){
        this.message = messageDTO.getMessageText();

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
        textOfMessage.setText(message);
    }

}
