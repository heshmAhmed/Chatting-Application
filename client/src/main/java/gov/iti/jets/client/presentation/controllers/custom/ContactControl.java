package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.presentation.dtos.ContactDTO;
import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

//import java.awt.event.ActionEvent;

import java.io.IOException;

public class ContactControl extends HBox{
    StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    ContactModel contactModel;
    ChatAreaControl myChatArea;

    @FXML
    private Label conatctNameLabel;

    @FXML
    private HBox contactHBox;

    @FXML
    private Label contactMessageLabel;

    @FXML
    private Circle contactPhotoCircle;


    public ContactControl(ContactModel contactModel) {
        this.contactModel = contactModel;

//      URL url = new URL("");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/contactBoxView/ContactView.fxml"));
//      loader.setLocation();
        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void initialize(){

        myChatArea = new ChatAreaControl();

        conatctNameLabel.setText("dummy name");

        contactHBox.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e -> stageCoordinator.setChatScene(myChatArea));
//        contactPhotoCircle.setFill();
    }
}
