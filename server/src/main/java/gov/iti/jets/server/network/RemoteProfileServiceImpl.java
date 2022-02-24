package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteProfileService;
import gov.iti.jets.server.services.interfaces.IProfileService;
import gov.iti.jets.server.services.util.ServiceFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteProfileServiceImpl extends UnicastRemoteObject implements IRemoteProfileService {
    private final IProfileService profileService = ServiceFactory.getInstance().getProfileService();

    public RemoteProfileServiceImpl() throws RemoteException {
    }

    @Override
    public boolean updateProfile(UserDTO userDTO) throws RemoteException {
        return profileService.updateProfile(userDTO);
    }
}
