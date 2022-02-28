package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.util.ContactListHelper;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

public class ContactControl extends HBox{
    private StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private ContactListHelper contactListHelper = ContactListHelper.getInstance();
    private ContactModel contactModel;
    private ChatAreaControl myChatArea;
    private ObservableList<HBox> list;
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty bio = new SimpleStringProperty();

    @FXML
    private Label contactNameLabel;
    @FXML
    private HBox contactHBox;

    public Label getContactNumberLabel() {
        return contactNumberLabel;
    }

    public void setContactNumberLabel(Label contactNumberLabel) {
        this.contactNumberLabel = contactNumberLabel;
    }

    @FXML
    private Label contactNumberLabel;
    @FXML
    private Circle contactPhotoCircle;
    @FXML
    private Circle statusIcon;
    @FXML
    private ImageView image;
    private String contactId;

    public ContactControl(String phoneNumber) {
        list = contactListHelper.createMessageList(phoneNumber);
        contactId = phoneNumber;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/contactBoxView/ContactView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initialize(){
        myChatArea = new ChatAreaControl(list, contactId);
        contactHBox.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e -> stageCoordinator.setChatScene(myChatArea));
//        contactPhotoCircle.setFill();
        this.image = new ImageView();
    }















    ///////////////////////////////////////////////////////////////////////clean up
    public ChatAreaControl getChatArea (){
        return myChatArea;
    }

    public StageCoordinator getStageCoordinator() {
        return stageCoordinator;
    }

    public void setStageCoordinator(StageCoordinator stageCoordinator) {
        this.stageCoordinator = stageCoordinator;
    }

    public ContactListHelper getContactListHelper() {
        return contactListHelper;
    }

    public void setContactListHelper(ContactListHelper contactListHelper) {
        this.contactListHelper = contactListHelper;
    }

    public ContactModel getContactModel() {
        return contactModel;
    }

    public void setContactModel(ContactModel contactModel) {
        this.contactModel = contactModel;
    }

    public ChatAreaControl getMyChatArea() {
        return myChatArea;
    }

    public void setMyChatArea(ChatAreaControl myChatArea) {
        this.myChatArea = myChatArea;
    }

    public ObservableList<HBox> getList() {
        return list;
    }

    public void setList(ObservableList<HBox> list) {
        this.list = list;
    }

    public Label getContactNameLabel() {
        return contactNameLabel;
    }

    public void setContactNameLabel(Label contactNameLabel) {
        this.contactNameLabel = contactNameLabel;
    }

    public HBox getContactHBox() {
        return contactHBox;
    }

    public void setContactHBox(HBox contactHBox) {
        this.contactHBox = contactHBox;
    }

    public Circle getContactPhotoCircle() {
        return contactPhotoCircle;
    }

    public void setContactPhotoCircle(Circle contactPhotoCircle) {
        this.contactPhotoCircle = contactPhotoCircle;
    }

    public Circle getStatusIcon() {
        return statusIcon;
    }

    public void setStatusIcon(Circle statusIcon) {
        this.statusIcon = statusIcon;
    }

    public ImageView getImageView() {
        return image;
    }

    public void setImageView(ImageView image) {
        this.image = image;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getBio() {
        return bio.get();
    }

    public StringProperty bioProperty() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio.set(bio);
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }


    @Override
    public String toString() {
        return "ContactControl{" +
                "stageCoordinator=" + stageCoordinator +
                ", contactListHelper=" + contactListHelper +
                ", contactModel=" + contactModel +
                ", myChatArea=" + myChatArea +
                ", list=" + list +
                ", status=" + status +
                ", bio=" + bio +
                ", contactNameLabel=" + contactNameLabel +
                ", contactHBox=" + contactHBox +
                ", contactMessageLabel=" + contactNameLabel +
                ", contactPhotoCircle=" + contactPhotoCircle +
                ", statusIcon=" + statusIcon +
                ", image=" + image +
                '}';
    }
}
