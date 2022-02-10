package gov.iti.jets.client.controllers.custom;

import gov.iti.jets.client.dtos.ContactDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class ContactControl extends HBox{

    ContactDTO contactDTO;

    @FXML
    private Label conatctNameLabel;

    @FXML
    private HBox contactHBox;

    @FXML
    private Label contactMessageLabel;

    @FXML
    private Circle contactPhotoCircle;

    public ContactControl(ContactDTO contactDTO){
        this.contactDTO = contactDTO;


//        URL url = new URL("");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/contactBoxView/ContactView.fxml"));
//        loader.setLocation();
        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }


    }


    public void initialize(){
        conatctNameLabel.setText("dummy name");
//        contactPhotoCircle.setFill();
    }


}
