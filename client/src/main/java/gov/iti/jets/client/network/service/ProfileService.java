package gov.iti.jets.client.network.service;

import gov.iti.jets.client.network.util.RegistryFactory;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.presentation.util.*;
import gov.iti.jets.client.util.DateHandler;
import gov.iti.jets.common.dtos.GroupDTO;
import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.common.server.IRemoteProfileService;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Base64;

public class ProfileService {
    private static final ProfileService profileService = new ProfileService();
    private final IRemoteProfileService iRemoteProfileService = RegistryFactory.getInstance().getRemoteProfileService();
    private final UserModel userModel = ModelFactory.getInstance().getUserModel();
    private final DateHandler dateHandler = DateHandler.getInstance();
    private final ModelFactory modelFactory = ModelFactory.getInstance();
    private final ContactListHelper contactListHelper = ContactListHelper.getInstance();
    private final GroupListHelper groupListHelper = GroupListHelper.getInstance();
    private final SessionManager sessionManager = SessionManager.getInstance();
    private final InvitationsListHelper invitationsListHelper = InvitationsListHelper.getInstance();

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
            userModel.setStatus(status.name());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void updateProfilePicture(File imageFile, String imageName) {
        try {
            String encodedImage = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(imageFile));
            iRemoteProfileService.updateUserImage(userModel.getPhoneNumber(), imageName, encodedImage);
            this.userModel.getUserImageCircle().setFill(new ImagePattern(new Image(imageFile.getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        System.out.println(modelFactory.getContactList());
        profileService.changeStatus(Status.OFFLINE);
        contactListHelper.clearData();
        groupListHelper.clearData();
        sessionManager.endSession();
        invitationsListHelper.clearData();
        modelFactory.clearDate();
        try {
            iRemoteProfileService.logMeOut(userModel.getPhoneNumber());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
