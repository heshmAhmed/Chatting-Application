package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.server.IRemoteContactService;
import gov.iti.jets.server.services.impls.ContactServiceImpl;
import gov.iti.jets.server.services.interfaces.IContactService;
import gov.iti.jets.server.services.util.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteContactServiceImpl extends UnicastRemoteObject implements IRemoteContactService {
    private final IContactService contactService = ServiceFactory.getInstance().getContactService();

    public RemoteContactServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ContactDTO> getAllUserContacts(String phoneNumber) throws RemoteException {
        return contactService.getAllUserContacts(phoneNumber);
    }
}
