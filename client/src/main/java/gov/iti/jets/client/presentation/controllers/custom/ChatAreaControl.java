package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.network.service.SendMessageService;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.common.dtos.MessageDTO;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ChatAreaControl extends BorderPane {
    private final SendMessageService sendMessageService = SendMessageService.getInstance();
    UserModel userModel = ModelFactory.getInstance().getUserModel();
    @FXML
    private final ObservableList<HBox> list;

    @FXML
    private Button attachButton;

    @FXML
    private MenuItem attachMenuItem1;

    @FXML
    private MenuItem attachMenuItem2;

    @FXML
    private MenuItem blockContactAction;

    @FXML
    private VBox chatAreaVBox;

    @FXML
    private Circle chatStatusCircle;

    private FileChooser fileChooser;

    public Label getCurrentChatName() {
        return currentChatName;
    }

    public void setCurrentChatName(Label currentChatName) {
        this.currentChatName = currentChatName;
    }

    public Circle getCurrentChatPhotoCircle() {
        return currentChatPhotoCircle;
    }

    public void setCurrentChatPhotoCircle(Circle currentChatPhotoCircle) {
        this.currentChatPhotoCircle = currentChatPhotoCircle;
    }

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

    @FXML
    private ComboBox<String> fonSizeBox;

    @FXML
    private ComboBox<String> fontFamilyLBox;

    @FXML
    private ToggleButton boldButton;

    @FXML
    private ColorPicker colorPicker;


    private String contactId;
    private String color = "white";
    private String weight = "NORMAL";
    private String fontFamily = "Verdana ";
    private String fontSize = "18 px ";
    private String messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
            "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";

    public ChatAreaControl(ObservableList<HBox> list, String contactId) {
        this.list = list;
        this.contactId = contactId;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/chatareaview/chat-area-view.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        chatAreaListView.setItems(list);
    }

    public void initialize() {
        ObservableList<String> familyList = FXCollections.observableArrayList("Verdana", "Courier New", "Georgia ", "Times New Roman",
                "Helvetica", "Comic Sans MS", "Impact", "Trebuchet MS", "Tahoma");
        fontFamilyLBox.setItems(familyList);
        ObservableList<String> sizeList = FXCollections.observableArrayList("16 px", "18 px", "20 px", "22 px", "24 px", "26 px");
        fonSizeBox.setItems(sizeList);
        sendMessageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (EventHandler<MouseEvent>) e -> {
            sendMessage();
        });


        messageTextArea.addEventFilter(KeyEvent.KEY_PRESSED,  new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {


                if (e.getCode() == KeyCode.ENTER) {
                    if(e.isShiftDown())
                    {
                        messageTextArea.appendText("\n");
                        return;
                    }
                    sendMessage();
                    e.consume();
                }
            }
        });


    }

public void scrollList(){

}
    public void sendMessage() {
        String message = messageTextArea.getText();
            if (!(message.equals(""))) {
                MessageDTO myMessageDTO = new MessageDTO();
                myMessageDTO.setMessageText(message);
                myMessageDTO.setReceiverId(contactId);
                myMessageDTO.setSenderId(userModel.getPhoneNumber());
                myMessageDTO.setMessageStyle(messageStyle);

            list.add(new SentMessageControl(myMessageDTO));
            chatAreaListView.scrollTo(chatAreaListView.getItems().size() - 1);
            sendMessageService.sendMessage(myMessageDTO);
            messageTextArea.setText("");
        }
    }


    @FXML
    public void handleSendFile(ActionEvent e){
        fileChooser = new FileChooser();
        fileChooser.setTitle("Choose File to Send");
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("All Files",
                        "*.txt","*.png","*.jpeg","*.jpg","*.doc","*.docx","*.pdf","*.java","*.css","*.html"),
                new FileChooser.ExtensionFilter("Videos","*.mp4"),
                new FileChooser.ExtensionFilter("Audios",".mp3",".wav")
        );
        File chosenFileToSend = fileChooser.showOpenDialog(null);
        if (chosenFileToSend != null){
            try {
                String senderName = userModel.getUsername();
                String receiverPhone = contactId;
                byte[] sentFileAsBytes = Files.readAllBytes(chosenFileToSend.toPath());
                String fileName = chosenFileToSend.getName();
                sendMessageService.sendFile( senderName , receiverPhone, sentFileAsBytes , fileName);
            } catch (IOException a) {
                a.printStackTrace();
            }
        }
        System.out.println("handleSendFile>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " );
    }



    public Circle getChatStatusCircle() {
        return chatStatusCircle;
    }

    public void setChatStatusCircle(Circle chatStatusCircle) {
        this.chatStatusCircle = chatStatusCircle;
    }

    @FXML
    void handleColor(ActionEvent event) {
        color = toHexString(colorPicker.getValue());
        messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
                "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";
        messageTextArea.setStyle(messageStyle);
    }

    @FXML
    void handleFontFamily(ActionEvent event) {
        fontFamily = fontFamilyLBox.getSelectionModel().getSelectedItem().toString();
        messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
                "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";
        messageTextArea.setStyle(messageStyle);
    }

    @FXML
    void handleFontSize(ActionEvent event) {
        fontSize = fonSizeBox.getSelectionModel().getSelectedItem().toString();
        messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
                "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";
        messageTextArea.setStyle(messageStyle);
    }

    @FXML
    void handleBoldButton(ActionEvent event) {
        if (boldButton.isSelected()) {
            weight = "BOLD";
            messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
                    "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";
            messageTextArea.setStyle(messageStyle);
            System.out.println(messageStyle);
        } else {
            weight = "NORMAL";
            messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
                    "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";
            messageTextArea.setStyle(messageStyle);
            System.out.println(messageStyle);
        }
    }

    private static String toHexString(Color color) {
        int r = ((int) Math.round(color.getRed() * 255)) << 24;
        int g = ((int) Math.round(color.getGreen() * 255)) << 16;
        int b = ((int) Math.round(color.getBlue() * 255)) << 8;
        int a = ((int) Math.round(color.getOpacity() * 255));

        return String.format("#%08X", (r + g + b + a));
    }

}
