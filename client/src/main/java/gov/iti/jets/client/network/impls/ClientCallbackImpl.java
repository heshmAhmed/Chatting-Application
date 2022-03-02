package gov.iti.jets.client.network.impls;

import gov.iti.jets.client.network.service.GroupService;
import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.util.*;
import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.dtos.Status;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Optional;

public class ClientCallbackImpl extends UnicastRemoteObject implements IClientCallback, Serializable {
    private final ContactListHelper contactListHelper = ContactListHelper.getInstance();
    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private final InvitationsListHelper invitationsListHelper = InvitationsListHelper.getInstance();
    private final GroupListHelper groupListHelper = GroupListHelper.getInstance();
    private final GroupService groupService = GroupService.getInstance();

    public ClientCallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void receiveMessage(MessageDTO messageDTO) throws RemoteException {
        System.out.println("receiveMessage invoked");
        contactListHelper.addMessageToList(messageDTO);
        Popups.receiveNotification("Message notification","📩 New message from "+ contactListHelper.getNameById(messageDTO.getSenderId()));

    }

    @Override
    public void receiveInvitation(InvitationDTO invitationDTO) throws RemoteException {
        System.out.println("receive invitation invoked");
        invitationsListHelper.loadInvitation(invitationDTO);
        Popups.receiveNotification("Invitation notification","🤝 New invitation received");
    }


    @Override
    public void receiveNewContact(ContactDTO contactDTO) throws RemoteException {
        ContactModel contactModel = modelFactory.mapContactModelToDTO(contactDTO);
        modelFactory.addToContactModels(contactModel);
        contactListHelper.loadContact(contactModel);
        Popups.receiveNotification("Contact notification","🥳 "+ contactDTO.getUsername() + " was added");

    }

    @Override
    public void receiveStatusChange(String phoneNumber, Status status) throws RemoteException {
        contactListHelper.changeContactStatus(phoneNumber, status);
        Popups.receiveNotification("Status notification","🎭 " + contactListHelper.getNameById(phoneNumber) +" changed their status!");

    }
    @Override
    public void receiveGroupMessage(MessageDTO messageDTO) throws RemoteException {
        groupListHelper.addMessageToList(messageDTO);
        Popups.receiveNotification("Message notification","👨‍👩‍👧‍👧 New group message");

    }



    @Override
    public void receiveAnnouncement(String announcement){
        Popups.receiveNotification("Announcement!","📢 "+announcement);
    }

    @Override
    public void receiveNewGroup() throws RemoteException {
        groupListHelper.clearGroups();
        groupService.loadGroups();
    }

    @Override
    public void receiveFile(String senderName, byte[] file, String fileName) throws RemoteException {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Do you want to receive file from " + senderName + " ?");
            alert.setTitle("File Download");
            alert.getButtonTypes().remove(0, 2);
            alert.getButtonTypes().add(0, ButtonType.YES);
            alert.getButtonTypes().add(1, ButtonType.NO);
            Optional<ButtonType> alertActionResult = alert.showAndWait();
            if (alertActionResult.isPresent()) {

                if (alertActionResult.get() == ButtonType.YES) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setInitialFileName(fileName);

                    fileChooser.setTitle("Save file");
                    File chosenFile = fileChooser.showSaveDialog(null);
                    if (chosenFile != null) {
                        try {
                            FileUtils.writeByteArrayToFile(chosenFile , file );
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Nooooooooooooooooooooooooooooooooooooooooooo");
                }
            }
        });
    }

    @Override
    public void serverDisconnected() throws RemoteException {

        System.out.println("server disconnected");
        Platform.runLater(() ->Popups.alert("☠ Server is down!!"));
    }


}
