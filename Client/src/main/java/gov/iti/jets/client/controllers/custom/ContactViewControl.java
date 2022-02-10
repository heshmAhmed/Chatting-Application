package gov.iti.jets.client.controllers.custom;

import gov.iti.jets.client.dtos.ContactDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;

public class ContactViewControl extends HBox{

    ContactDTO contactDTO;

    @FXML
    private Label conatctNameLabel;

    @FXML
    private HBox contactHBox;

    @FXML
    private Label contactMessageLabel;

    @FXML
    private Circle contactPhotoCircle;

    public ContactViewControl(ContactDTO contactDTO){
        this.contactDTO = contactDTO;


//        URL url = new URL("");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/contactBoxView/contactView.fxml"));
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
