package gov.iti.jets.server.repository.interfaces;

import gov.iti.jets.server.repository.entity.ContactEntity;

import java.util.List;

public interface IContactRepository {
    public List<ContactEntity> getUserContacts(String phoneNumber);

    boolean addNewContact(String user1Phone, String user2Phone);

    ContactEntity getContact(String phoneNumber);
}
