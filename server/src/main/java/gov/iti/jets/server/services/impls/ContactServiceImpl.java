package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.InvitationDTO;
import gov.iti.jets.server.repository.entity.ContactEntity;
import gov.iti.jets.server.repository.entity.InvitationEntity;
import gov.iti.jets.server.repository.interfaces.IContactRepository;
import gov.iti.jets.server.repository.interfaces.IInvitationRepository;
import gov.iti.jets.server.repository.util.ImageUtility;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.mapper.ContactDtoMapper;
import gov.iti.jets.server.services.mapper.InvitationDtoMapper;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements IContactService {
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IContactRepository contactRepository = repoFactory.getContactRepo();
    private final IInvitationRepository invitationRepo = repoFactory.getInvitationRepo();
    private final static ContactServiceImpl contactService = new ContactServiceImpl();
    private final ServerUtil serverUtil = ServerUtil.getInstance();
    private final ImageUtility imageUtility = ImageUtility.getInstance();

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
        boolean invited = invitationRepo.alreadyInvitedMe(invitationDTO.getReceiverPhoneNumber(), invitationDTO.getSenderPhoneNumber());
        if (invited==false) {
            invitationRepo.addInvitation(invitationDTO.getReceiverPhoneNumber(), invitationDTO.getSenderPhoneNumber(), invitationDTO.getDate());
            if (serverUtil.onlineUsers.containsKey(invitationDTO.getReceiverPhoneNumber())) {
                serverUtil.onlineUsers.get(invitationDTO.getReceiverPhoneNumber()).receiveInvitation(invitationDTO);
                return  true;
            }
        } else {
            acceptInvitation(invitationDTO);
        }
        return false;
    }


    @Override
    public void acceptInvitation(InvitationDTO invitationDTO) throws RemoteException {
        ContactDTO contactDTO= new ContactDTO();
        contactRepository.addNewContact(invitationDTO.getReceiverPhoneNumber(), invitationDTO.getSenderPhoneNumber());
        contactRepository.addNewContact(invitationDTO.getSenderPhoneNumber(), invitationDTO.getReceiverPhoneNumber());
        //send accept
        if(serverUtil.onlineUsers.containsKey(invitationDTO.getReceiverPhoneNumber())){
           ContactEntity entity= contactRepository.getContact(invitationDTO.getSenderPhoneNumber());
            contactDTO=ContactDtoMapper.INSTANCE.contactEntityToDTO(entity);
            serverUtil.onlineUsers.get(invitationDTO.getReceiverPhoneNumber()).receiveNewContact(contactDTO);
        }
        if(serverUtil.onlineUsers.containsKey(invitationDTO.getSenderPhoneNumber())){
            ContactEntity entity= contactRepository.getContact(invitationDTO.getReceiverPhoneNumber());
            contactDTO=ContactDtoMapper.INSTANCE.contactEntityToDTO(entity);
            serverUtil.onlineUsers.get(invitationDTO.getSenderPhoneNumber()).receiveNewContact(contactDTO);
        }
         ignoreInvitation(invitationDTO);
    }

    @Override
    public void ignoreInvitation(InvitationDTO invitationDTO) throws RemoteException {

        invitationRepo.deleteInvitation(invitationDTO.getReceiverPhoneNumber(),invitationDTO.getSenderPhoneNumber());
    }

    @Override
    public List<InvitationDTO> getAllUserInvitation(String userId) throws RemoteException {
        List<InvitationDTO> invitationDTOS = new ArrayList<>();
        List<InvitationEntity> invitationList = invitationRepo.getAllUserInvitations(userId);

        for (InvitationEntity entity : invitationList) {
            invitationDTOS.add(InvitationDtoMapper.INSTANCE.invitationDto(entity));

        }
        return invitationDTOS;

    }

}
