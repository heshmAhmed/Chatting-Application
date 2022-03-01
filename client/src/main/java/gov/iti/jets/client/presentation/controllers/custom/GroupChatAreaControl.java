package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.network.service.SendMessageService;
import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.server.IRemoteMessageHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.io.IOException;
import java.util.stream.Stream;

public class  GroupChatAreaControl extends BorderPane{
    private final SendMessageService sendMessageService = SendMessageService.getInstance();
    private final UserModel userModel = ModelFactory.getInstance().getUserModel();
    private final GroupListHelper groupListHelper = GroupListHelper.getInstance();
    private final ContactListHelper contactListHelper = ContactListHelper.getInstance();
    private String contactId;
    private String color = "white";
    private String weight = "NORMAL";
    private String fontFamily = "Verdana ";
    private String fontSize = "18 px ";
    private String messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
            "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";
    private String groupId;
    @FXML
    private ImageView showGroupMembers;
    @FXML
    private Label currentChatName;
    @FXML
    private Circle currentChatPhotoCircle;
    @FXML
    private TextArea messageTextArea;
    @FXML
    private Button sendMessageButton;
    @FXML
    private ComboBox<String> fonSizeBox;
    @FXML
    private ComboBox<String> fontFamilyLBox;
    @FXML
    private ToggleButton boldButton;
    @FXML
    private ColorPicker colorPicker;
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

    @FXML
    private void handleShowGroupMembers(MouseEvent event){
        ContextMenu contextMenu = new ContextMenu();
        GroupDTO groupDTO = groupListHelper.getGroupDtosList().get(groupId);
        groupDTO.getContacts().forEach(c -> {
            if(userModel.getPhoneNumber().equals(c))
                contextMenu.getItems().add(new MenuItem("me"));
            else
             contextMenu.getItems().add(new MenuItem(contactListHelper.getNameById(c))) ;
        });
        contextMenu.show(this.showGroupMembers, event.getScreenX() + 5, event.getScreenY() + 5);
    }

    @FXML
    void handleAddNewContactIcon(MouseEvent event) {
        GroupDTO groupDTO = groupListHelper.getGroupDtosList().get(groupId);
        ObservableList<String> list = FXCollections.observableArrayList();
        ModelFactory.getInstance().getContactModels().forEach(c -> {
//            System.out.println((groupDTO.getContacts()));
            if(!(groupDTO.getContacts().contains(c.getPhoneNumber())))
            {
                list.add(c.getPhoneNumber());
            }
        });
        StageCoordinator.getInstance().showAddContactToGroupPopup(groupId , list);
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
        } else {
            weight = "NORMAL";
            messageStyle = "-fx-text-fill : " + color +"; -fx-fill:" + color + "; -fx-font-family : " + fontFamily + ";" +
                    "-fx-font-weight:" + weight + ";-fx-font-size:" + fontSize + ";";
            messageTextArea.setStyle(messageStyle);
        }

    }

    public void setCurrentChatName(Label currentChatName) {
        this.currentChatName = currentChatName;
    }

    public Label getCurrentChatName() {
        return currentChatName;
    }

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

    public void initialize(){
        sendMessageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (EventHandler<MouseEvent>) e-> {
            sendMessage();
        });
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

    private void sendMessage(){
        String message = messageTextArea.getText();
        if(!(message.equals(""))){

            MessageDTO myMessageDTO = new MessageDTO();
            myMessageDTO.setMessageText(message);
            myMessageDTO.setMessageStyle(messageStyle);
            myMessageDTO.setReceiverId(groupId);
            myMessageDTO.setSenderId(userModel.getPhoneNumber());
            list.add(new SentMessageControl(myMessageDTO));
            sendMessageService.sendGroupMessage(myMessageDTO);
            messageTextArea.setText("");
        }
    }

    private static String toHexString(Color color) {
        int r = ((int) Math.round(color.getRed() * 255)) << 24;
        int g = ((int) Math.round(color.getGreen() * 255)) << 16;
        int b = ((int) Math.round(color.getBlue() * 255)) << 8;
        int a = ((int) Math.round(color.getOpacity() * 255));

        return String.format("#%08X", (r + g + b + a));
    }

    public Circle getCurrentChatPhotoCircle() {
        return currentChatPhotoCircle;
    }

    public void setCurrentChatPhotoCircle(Circle currentChatPhotoCircle) {
        this.currentChatPhotoCircle = currentChatPhotoCircle;
    }
}
