package gov.iti.jets.client.presentation.controllers.custom;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AddNewContactToGroupControl extends VBox{

    @FXML
    private Button addButton;

    @FXML
    private ListView<String> contactsList ;

    ObservableList<String> list;

    public AddNewContactToGroupControl(ObservableList<String> list){
        this.list=list;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/chatWindow/groupBoxView/add-new-contact-view.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void initialize(){
        contactsList.setItems(list);
    }

    @FXML
    void handleAddButton(ActionEvent event) {

    }


}
