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
    private StringProperty status = new SimpleStringProperty();
    private StringProperty bio = new SimpleStringProperty();

    @FXML
    private Label contactNameLabel;
    @FXML
    private HBox contactHBox;
    @FXML
    private Label contactMessageLabel;
    @FXML
    private Circle contactPhotoCircle;
    @FXML
    private Circle statusIcon;
    @FXML
    private ImageView image;

    public ContactControl() {

        list = contactListHelper.createMessageList(contactModel.getPhoneNumber());
//      URL url = new URL("");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/contactBoxView/ContactView.fxml"));
//      loader.setLocation();
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initialize(){
        myChatArea = new ChatAreaControl(list);
        contactNameLabel.setText("dummy name");
        contactHBox.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e -> stageCoordinator.setChatScene(myChatArea));
//        contactPhotoCircle.setFill();
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

    public Label getContactMessageLabel() {
        return contactMessageLabel;
    }

    public void setContactMessageLabel(Label contactMessageLabel) {
        this.contactMessageLabel = contactMessageLabel;
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
}
