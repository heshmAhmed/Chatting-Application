package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.server.repository.entity.ContactEntity;
import gov.iti.jets.server.repository.interfaces.IContactRepository;
import gov.iti.jets.server.repository.interfaces.IInvitationRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.mapper.ContactDtoMapper;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements IContactService {
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IContactRepository contactRepository = repoFactory.getContactRepo();
    private final IInvitationRepository iInvitationRepository = repoFactory.getInvitationRepo();
    private final static ContactServiceImpl contactService = new ContactServiceImpl();
    private final ServerUtil serverUtil = ServerUtil.getInstance();

    private ContactServiceImpl() {

    }

    public static ContactServiceImpl getInstance() {
        return contactService;
    }

    @Override
    public List<ContactDTO> getAllUserContacts(String userId) {
        List<ContactEntity> contacts = contactRepository.getUserContacts(userId);
        List<ContactDTO> contactDTOS = new ArrayList<>();
        for (ContactEntity user : contacts) {
            contactDTOS.add(ContactDtoMapper.INSTANCE.contactEntityToDTO(user));
        }
        System.out.println("contact service: " + contactDTOS);
        return contactDTOS;
    }

    @Override
    public boolean sendInvitation(InvitationDTO invitationDTO) throws RemoteException {
        boolean added = false;
        boolean invited = iInvitationRepository.alreadyInvitedMe(invitationDTO.getReceiverPhoneNumber(), invitationDTO.getReceiverPhoneNumber());
        if (!invited) {
            iInvitationRepository.addInvitation(invitationDTO.getReceiverPhoneNumber(), invitationDTO.getSenderPhoneNumber(), invitationDTO.getDate());
            if (serverUtil.onlineUsers.containsKey(invitationDTO.getReceiverPhoneNumber())) {
                serverUtil.onlineUsers.get(invitationDTO.getReceiverPhoneNumber()).receiveInvitation(invitationDTO);
            }
        } else {

        }
        return false;
    }

    @Override
    public void acceptInvitation(InvitationDTO invitationDTO) throws RemoteException {

    }
}
