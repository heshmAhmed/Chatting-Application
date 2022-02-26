package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.controllers.custom.GroupControl;
import gov.iti.jets.client.presentation.controllers.custom.ReceivedMessageControl;
import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.common.server.IRemoteGroupService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupListHelper {
    IRemoteGroupService groupService = RegistryFactory.getInstance().getRemoteGroupService();
    private static final GroupListHelper groupListHelper = new GroupListHelper();
    private final Map<String, ObservableList<HBox>> messageListMap = new HashMap<>();
    private final ObservableList<HBox> groupList = FXCollections.observableArrayList();
    private final Map<String, GroupControl> groupControlMap = new HashMap<>();

    public Map<String, GroupDTO> getGroupDtosList() {
        return groupDtosList;
    }

    private final Map<String, GroupDTO> groupDtosList = new HashMap<>();

    private GroupListHelper(){
    }

    public static GroupListHelper getInstance(){
        return  groupListHelper;
    }

    public ObservableList<HBox> getGroupList(){
        return groupList;
    }

    public ObservableList<HBox> createMessageList(String groupId){
        ObservableList<HBox> list;

        if(messageListMap.containsKey(groupId))
        {
            list = messageListMap.get(groupId);
        } else {
            list = FXCollections.observableArrayList();
            messageListMap.put(groupId, list);
        }
        return list;
    }



    public void createNewGroup(String name, Image image){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName(name);

        /////////////////////// Image ///////////////////
        groupDTO.setImg(new String("encodedImage"));

        try {

            groupDTO.setId(groupService.createGroup(groupDTO));
            appenndGroup(groupDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public void appenndGroup(GroupDTO groupDTO){
        GroupControl groupControl = new GroupControl(groupDTO.getId());
        groupControl.getGroupNameLabel().setText(groupDTO.getName());

        groupList.add(groupControl);
//        groupDtosList.put(groupDTO.getId(),groupDTO);
        groupControlMap.put(groupDTO.getId(), groupControl);

    }

    public void addContactsToGroup(String groupId, List<String> contacts){
        groupDtosList.get(groupId).getContacts().addAll(contacts);
    }



    /*

    public void addMessageToList(MessageDTO messageDTO) {
        Platform.runLater(()-> messageListMap.get(messageDTO.getSenderId()).add(new ReceivedMessageControl(messageDTO)));
    }




    public void loadContact(ContactModel contactModel) {
        ContactControl contactControl = new ContactControl(contactModel.getPhoneNumber());
        contactControl.getContactNameLabel().textProperty().bindBidirectional(contactModel.usernameProperty());
        contactControl.getImageView().imageProperty().bindBidirectional(contactModel.imageProperty());
        // testing
        contactControl.statusProperty().bindBidirectional(contactModel.statusProperty());
        contactControl.bioProperty().bindBidirectional(contactModel.bioProperty());
        Platform.runLater(() -> {
            contactList.add(contactControl);
            contactControlMap.put(contactModel.getPhoneNumber(), contactControl);
        });
    }
*/

}
