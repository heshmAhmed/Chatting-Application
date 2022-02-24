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
    private final Map<String, HBox> invitationsListMap = new HashMap<>();

    private InvitationsListHelper(){}

    public  static  InvitationsListHelper getInstance(){return invitationsListHelper;}

    public ObservableList<HBox> getInvitationsList(){
        return invitationsList;
    }

    public void removeInvitationCard(InvitationDTO invitationDTO) {
        invitationsList.remove(invitationsListMap.get(invitationDTO.getSenderPhoneNumber()));
    }

    public void loadInvitation(InvitationDTO invitationDTO) {
        InvitationCardControl invitationCardControl = new InvitationCardControl(invitationDTO);
        invitationsList.add(invitationCardControl);
        invitationsListMap.put(invitationDTO.getSenderPhoneNumber(), invitationCardControl);
    }

}
