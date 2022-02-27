package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.network.service.GroupService;
import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.controllers.custom.GroupControl;
import gov.iti.jets.client.presentation.controllers.custom.ReceivedMessageControl;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.common.dtos.MessageDTO;
import gov.iti.jets.common.server.IRemoteGroupService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import org.controlsfx.control.PropertySheet;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupListHelper {
//    private final GroupService groupService = GroupService.getInstance();
    IRemoteGroupService groupService = RegistryFactory.getInstance().getRemoteGroupService();
    private static final GroupListHelper groupListHelper = new GroupListHelper();
    private final Map<String, ObservableList<HBox>> messageListMap = new HashMap<>();
    private final ObservableList<HBox> groupList = FXCollections.observableArrayList();
    private final Map<String, GroupControl> groupControlMap = new HashMap<>();
    UserModel userModel = ModelFactory.getInstance().getUserModel();

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

        groupDTO.getContacts().add(userModel.getPhoneNumber());

        /////////////////////// Image ///////////////////
        groupDTO.setImg(new String("encodedImage"));

        try {
            groupDTO.setId(groupService.createGroup(groupDTO));
            groupService.addContactsToGroup(groupDTO.getId(), List.of(userModel.getPhoneNumber()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        appenndGroup(groupDTO);

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


    public void addMessageToList(MessageDTO messageDTO) {

        Platform.runLater(()-> messageListMap.get(messageDTO.getReceiverId()).add(new ReceivedMessageControl(messageDTO)));

    }

}
