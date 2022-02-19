package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.ContactDTO;

import java.util.List;

public interface IContactService {
    public List<ContactDTO> getAllUserContacts(String userId);
}
