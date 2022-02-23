package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.controllers.custom.InvitationCardControl;
import gov.iti.jets.common.dtos.InvitationDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import java.util.HashMap;
import java.util.Map;

public class InvitationsListHelper {
    public static final InvitationsListHelper invitationsListHelper = new InvitationsListHelper();
    private final ObservableList<HBox> invitationsList = FXCollections.observableArrayList();
    private final Map<String, ObservableList<HBox> > invitationsListMap = new HashMap<>();
    private final Map<String, InvitationCardControl> contactControlMap = new HashMap<>();


    private InvitationsListHelper(){}

    public  static  InvitationsListHelper getInstance(){return invitationsListHelper;}

    public ObservableList<HBox> getInvitationsList(){
        return invitationsList;
    }

    public ObservableList<HBox> createInvitationList(String senderPhoneNumber){
        ObservableList<HBox> list;
        if(invitationsListMap.containsKey(senderPhoneNumber))
        {
            list = invitationsListMap.get(senderPhoneNumber);
        } else {
            list = FXCollections.observableArrayList();
            invitationsListMap.put(senderPhoneNumber, list);
        }
        return list;
    }

    public void addInvitationToList(InvitationDTO invitationDTO){
        InvitationCardControl card = new InvitationCardControl(invitationDTO);
        invitationsList.add(card);
    }

    public void denyInvitationFromList(InvitationDTO invitationDTO ,InvitationCardControl invitationCardControl){
        invitationsListMap.get(invitationDTO.getSenderName()).remove(invitationCardControl);
    }

    public void loadInvitation(InvitationDTO invitationDTO) {
        InvitationCardControl invitationCardControl = new InvitationCardControl(invitationDTO);
       // invitationCardControl.getInvitationBody().setText(invitationDTO.getSenderName()+": Sent an invitation");
        // invitationCardControl.getInvitationTime().setText(invitationDTO.getDate()+"");
        invitationsList.add(invitationCardControl);
        contactControlMap.put(invitationDTO.getSenderPhoneNumber(), invitationCardControl);
    }

}
