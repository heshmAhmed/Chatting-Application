package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.ModelFactory;
import gov.iti.jets.client.util.DateHandler;
import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteProfileService;
import java.rmi.RemoteException;

public class ProfileService {
    private static final ProfileService profileService = new ProfileService();
    private final IRemoteProfileService iRemoteProfileService = RegistryFactory.getInstance().getRemoteProfileService();
    private final UserModel userModel = ModelFactory.getInstance().getUserModel();
    private final DateHandler dateHandler = DateHandler.getInstance();
    private final ModelFactory modelFactory = ModelFactory.getInstance();

    private ProfileService(){};

    public static ProfileService getInstance() {
        return profileService;
    }

    public void updateProfile() {
        UserDTO userDTO = new UserDTO();
        userDTO.setPhoneNumber(userModel.getPhoneNumber());
        userDTO.setUsername(userModel.getUsername());
        userDTO.setCountry(userModel.getCountry());
        userDTO.setBio(userModel.getBio());
        userDTO.setDob(dateHandler.localDateToMillis(userModel.getDob()));
        try {
            iRemoteProfileService.updateProfile(userDTO);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void changeStatus(Status status) {
        try {
            iRemoteProfileService.updateUserStatus(userModel.getPhoneNumber(), status, modelFactory.getContactList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
