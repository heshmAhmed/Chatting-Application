package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.network.service.GroupService;
import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import gov.iti.jets.common.server.IRemoteGroupService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class AddNewContactToGroupControl extends VBox{

    GroupService groupService = GroupService.getInstance();
    @FXML
    private Button addButton;

    @FXML
    private ListView<String> contactsList ;

    public ObservableList<String> list;
    public String id;

    public AddNewContactToGroupControl(String id,ObservableList<String> list){
        this.list=list;
        this.id = id;
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
        contactsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        contactsList.setItems(list);
    }

    @FXML
    void handleAddButton(ActionEvent event){
        List<String> selected = new ArrayList<>();

        contactsList.getSelectionModel().getSelectedItems().forEach(selected::add);

        StageCoordinator.getInstance().closeAddContactToGroupPopup();

        if(selected.size() > 0){
            groupService.addContactToGroup(id, selected);
        }



    }


}
