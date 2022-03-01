package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.util.DateHandler;
import gov.iti.jets.common.dtos.MessageDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.time.LocalDate;

public class ReceivedMessageControl extends HBox {
        ContactListHelper contactListHelper = ContactListHelper.getInstance();
        DateHandler dateHandler;
        MessageDTO messageDTO;

        @FXML
        private VBox messageBox;

        @FXML
        private Label messageTimeLabel;

        @FXML
        private Label nameLabel;

        @FXML
        private Text textOfMessage;

        @FXML
        private TextFlow textWrapperTextFlow;

        public ReceivedMessageControl(MessageDTO messageDTO){
                this.messageDTO = messageDTO;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/chatareaview/receivedmessageview/receivedMessageView.fxml"));
                loader.setRoot(this);
                loader.setController(this);
                try{
                        loader.load();
                }catch(IOException ex){
                        ex.printStackTrace();
                }
        }

        public void initialize(){
                this.dateHandler = DateHandler.getInstance();
                textOfMessage.setText(messageDTO.getMessageText());
                textOfMessage.setStyle(messageDTO.getMessageStyle());
                nameLabel.setText(contactListHelper.getNameById(messageDTO.getSenderId()));
                messageTimeLabel.setText(DateHandler.getInstance().getCurrentTime());
        }
}
