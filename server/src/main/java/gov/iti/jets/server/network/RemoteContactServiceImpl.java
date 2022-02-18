package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.server.IRemoteContactService;
import gov.iti.jets.server.services.impls.ContactServiceImpl;
import gov.iti.jets.server.services.interfaces.IContactService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteContactServiceImpl extends UnicastRemoteObject implements IRemoteContactService {

IContactService contactService=new ContactServiceImpl();
    public RemoteContactServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<ContactDTO> getAllUserContacts(String userId) throws RemoteException {
        System.out.println(userId);
        System.out.println(contactService.getAllUserContacts(userId));
        return  null;
    }
}
