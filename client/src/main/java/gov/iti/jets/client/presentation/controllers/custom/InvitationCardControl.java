package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.network.service.ContactService;
import gov.iti.jets.client.presentation.util.InvitationsListHelper;
import gov.iti.jets.common.dtos.InvitationDTO;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;


public class InvitationCardControl extends HBox {
    private final ContactService contactService = ContactService.getInstance();
    private InvitationDTO invitationDTO;

    @FXML
    private MFXButton acceptBtn;

    @FXML
    private MFXButton denyBtn;

    @FXML
    private Label invitationBody;

    public Label getInvitationBody() {
        return invitationBody;
    }

    public void setInvitationBody(Label invitationBody) {
        this.invitationBody = invitationBody;
    }

    public Label getInvitationTime() {
        return invitationTime;
    }

    public void setInvitationTime(Label invitationTime) {
        this.invitationTime = invitationTime;
    }

    @FXML
    private Label invitationTime;

    public InvitationCardControl(InvitationDTO invitationDTO) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/invitations/InvitationCardView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
            this.invitationDTO = invitationDTO;
            this.getInvitationBody().setText(invitationDTO.getSenderName()+": Sent an invitation");
            this.getInvitationTime().setText(invitationDTO.getDate()+"");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initialize() {
        acceptBtn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,
                e -> contactService.acceptInvitation(invitationDTO));
        denyBtn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,
                e -> contactService.denyInvitation(invitationDTO));
    }
}
