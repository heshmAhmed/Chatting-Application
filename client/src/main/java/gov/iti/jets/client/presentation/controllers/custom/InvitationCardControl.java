package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.presentation.util.InvitationsListHelper;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InvitationCardControl extends HBox {
    public final static InvitationsListHelper invitationsListHelper = InvitationsListHelper.getInstance();

    public InvitationCardControl(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/invitations/InvitationCardView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @FXML
    private MFXButton acceptBtn;

    @FXML
    private MFXButton denyBtn;

    @FXML
    private Label invitationBody;

    @FXML
    private Label invitationTime;


    public void initialize(URL location, ResourceBundle resources) {
//        acceptBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,
//        (EventHandler<MouseEvent>) e -> stageCoordinator.setChatScene(myChatArea));
        }
//      denyBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, (EventHandler<MouseEvent>) e -> stageCoordinator.setChatScene(myChatArea));

}
