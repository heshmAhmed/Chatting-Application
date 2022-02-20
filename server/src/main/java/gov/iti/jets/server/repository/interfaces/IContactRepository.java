package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.server.repository.entity.ContactEntity;
import gov.iti.jets.server.repository.entity.UserEntity;

import java.util.List;

public interface IContactRepository {
    public List<ContactEntity> getUserContacts(String phoneNumber) ;

}
