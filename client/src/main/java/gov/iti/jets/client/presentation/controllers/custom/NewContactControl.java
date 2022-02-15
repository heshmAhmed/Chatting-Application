package gov.iti.jets.client.presentation.controllers.custom;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.List;

public class NewContactControl extends ScrollPane{

    List<String> addedContactsList;
    @FXML
    private TextField phoneNumberField;
    @FXML
    public VBox vbox;
//  BooleanProperty addedNewContacts = new SimpleBooleanProperty(false);

    public  NewContactControl(List<String> list){
        addedContactsList = list;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/newcontact/NewContactViewControl.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    @FXML
    void handlePlusIcon(MouseEvent event){

    }

    @FXML
    void handlePhoneNumberField(ActionEvent event) {

    }

    @FXML
    public void handleSendButton(ActionEvent actionEvent) {
        if( !(phoneNumberField.getText().equals("") )){

            addedContactsList.add(phoneNumberField.getText());
            phoneNumberField.setText("");

        }
    }

    public void initialize()
    {

    }

}
