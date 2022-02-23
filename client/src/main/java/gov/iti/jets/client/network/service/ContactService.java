package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.common.server.IRemoteContactService;

import java.rmi.RemoteException;
import java.util.List;

public class ContactService {
    private final static ContactService contactService = new ContactService();
    private final static IRemoteContactService remoteContactService = RegistryFactory.getInstance().getRemoteContactService();
    private final UserModel userModel = ModelFactory.getInstance().getUserModel();

    private ContactService() {}

    public static ContactService getInstance() {
        return contactService;
    }

    public void sendInvitations(List<String> list) {
        for(String phone: list) {
            try {
                InvitationDTO invitationDTO = new InvitationDTO();
                invitationDTO.setSenderPhoneNumber(userModel.getPhoneNumber());
                invitationDTO.setReceiverPhoneNumber(phone);
                invitationDTO.setSenderName(userModel.getUsername());
                remoteContactService.sendInvitation(invitationDTO);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
