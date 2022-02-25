package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.InvitationsListHelper;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.util.DateHandler;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.common.server.IRemoteContactService;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

public class ContactService {
    private final static ContactService contactService = new ContactService();
    private final static IRemoteContactService remoteContactService = RegistryFactory.getInstance().getRemoteContactService();
    private final UserModel userModel = ModelFactory.getInstance().getUserModel();
    private final InvitationsListHelper invitationsListHelper = InvitationsListHelper.getInstance();
    private final DateHandler dateHandler = DateHandler.getInstance();

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
                invitationDTO.setDate(dateHandler.localDateToMillis(LocalDate.now()));
                remoteContactService.sendInvitation(invitationDTO);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void acceptInvitation(InvitationDTO invitationDTO){
        try{
            remoteContactService.acceptInvitation(invitationDTO);
            invitationsListHelper.removeInvitationCard(invitationDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void denyInvitation(InvitationDTO invitationDTO){
        try{
            remoteContactService.ignoreInvitation(invitationDTO);
            invitationsListHelper.removeInvitationCard(invitationDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void loadUserInvitations() throws RemoteException {
        List<InvitationDTO> invitationDTOS = remoteContactService.getAllUserInvitation(userModel.getPhoneNumber());
        invitationDTOS.forEach(invitationsListHelper::loadInvitation);
    }
}
