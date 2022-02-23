package gov.iti.jets.client.presentation.controllers;

import gov.iti.jets.client.presentation.util.InvitationsListHelper;
import gov.iti.jets.common.dtos.InvitationDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class InvitationsListController implements Initializable {
    public final static InvitationsListHelper invitationsListHelper = InvitationsListHelper.getInstance();
    private InvitationDTO invitationDTO = new InvitationDTO() ;

    @FXML
    private ObservableList<HBox> list = invitationsListHelper.getInvitationsList();

    @FXML
    private ListView<HBox> listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //invitationDTO.setSenderName("Hossam");
        //invitationDTO.setSenderPhoneNumber("01097961674");
        //invitationDTO.setSenderPhoneNumber("");

        //invitationsListHelper.addInvitationToList(invitationDTO);
        listView.setItems(list);
    }
}
