package gov.iti.jets.server.network;

import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteProfileService;
import gov.iti.jets.server.services.interfaces.IProfileService;
import gov.iti.jets.server.services.util.ServerUtil;
import gov.iti.jets.server.services.util.ServiceFactory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RemoteProfileServiceImpl extends UnicastRemoteObject implements IRemoteProfileService {
    private final IProfileService profileService = ServiceFactory.getInstance().getProfileService();
    private final ServerUtil serverUtil = ServerUtil.getInstance();

    public RemoteProfileServiceImpl() throws RemoteException {
    }

    @Override
    public boolean updateProfile(UserDTO userDTO) throws RemoteException {
        return profileService.updateProfile(userDTO);
    }

    @Override
    public boolean updateUserStatus(String phoneNumber, Status status, List<String> contacts) throws RemoteException{
       return profileService.updateUserStatus(phoneNumber, status, contacts);
    }

    @Override
    public boolean updateUserImage(String phoneNumber,String imagePath, String encodedImage) throws RemoteException {
        return profileService.updateUserImage(phoneNumber, imagePath, encodedImage);
    }

    @Override
    public void logMeOut(String phoneNumber) {
        serverUtil.removeUserFromOnline(phoneNumber);
    }
}
