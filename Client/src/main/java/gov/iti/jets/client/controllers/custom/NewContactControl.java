package gov.iti.jets.client.controllers.custom;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewContactControl extends ScrollPane{

    List<String> addedContactsList;
//    BooleanProperty addedNewContacts = new SimpleBooleanProperty(false);

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
    private TextField phoneNumberField;
    @FXML
    public VBox vbox;

    @FXML
    void handlePlusIcon(MouseEvent event) {
        try {
            Label label = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/newcontact/contact.fxml")));
            label.setText(phoneNumberField.getText());
            this.vbox.getChildren().add(label);
            phoneNumberField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handlePhoneNumberField(ActionEvent event) {

    }

    @FXML
    public void handleSendButton(ActionEvent actionEvent) {
        if(phoneNumberField.getText() != "")
            addedContactsList.add(phoneNumberField.getText());
    }

    public void initialize()
    {

    }

}
