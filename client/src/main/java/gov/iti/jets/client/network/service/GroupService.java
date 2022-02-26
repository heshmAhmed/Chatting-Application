package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.common.server.IRemoteGroupService;

import java.rmi.RemoteException;
import java.util.List;

public class GroupService {

    IRemoteGroupService iRemoteGroupService = RegistryFactory.getInstance().getRemoteGroupService();
    GroupListHelper groupListHelper = GroupListHelper.getInstance();

    private static final GroupService groupService = new GroupService();

    private GroupService(){}

    public static GroupService getInstance() {
        return groupService;
    }

    public void addContactToGroup(String groupId, List<String> selectedContacts){

        System.out.println(selectedContacts + " group ");
        try {
            iRemoteGroupService.addContactsToGroup(groupId, selectedContacts);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        groupListHelper.addContactsToGroup(groupId, selectedContacts);

    }

}
