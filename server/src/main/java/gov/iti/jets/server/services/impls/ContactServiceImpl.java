package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.server.repository.entity.ContactEntity;
import gov.iti.jets.server.repository.interfaces.IContactRepository;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.mapper.ContactDtoMapper;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements IContactService {
    private final RepoFactory repoFactory = RepoFactory.getInstance();
    private final IContactRepository contactRepository = repoFactory.getContactRepo();
    private final static ContactServiceImpl contactService = new ContactServiceImpl();
    
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
}
