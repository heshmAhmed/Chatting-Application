package gov.iti.jets.server.services.impls;

import gov.iti.jets.common.client.IClientCallback;
import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.dtos.UserDTO;
import gov.iti.jets.server.repository.interfaces.IUserRepository;
import gov.iti.jets.server.repository.util.ImageUtility;
import gov.iti.jets.server.repository.util.RepoFactory;
import gov.iti.jets.server.services.interfaces.IProfileService;
import gov.iti.jets.server.services.mapper.UserEntityMapper;
import gov.iti.jets.server.services.util.ServerUtil;

import java.rmi.RemoteException;
import java.util.List;

public class ProfileServiceImpl implements IProfileService {
    private final IUserRepository userRepository = RepoFactory.getInstance().getUserRepo();
    private final static ProfileServiceImpl profileService = new ProfileServiceImpl();
    private final ServerUtil serverUtil = ServerUtil.getInstance();
    private final ImageUtility imageUtility = ImageUtility.getInstance();
    private ProfileServiceImpl() {}

    public static ProfileServiceImpl getInstance() {
        return profileService;
    }

    @Override
    public boolean updateProfile(UserDTO userDTO) {
        return userRepository.updateUser(UserEntityMapper.INSTANCE.userDTOToEntity(userDTO));
    }

    @Override
    public boolean updateUserStatus(String phoneNumber, Status status, List<String> contacts) {
        if(!userRepository.updateStatus(phoneNumber, status)) {
            return false;
        }
        contacts.forEach(contact -> {
            IClientCallback iClientCallback = serverUtil.onlineUsers.get(contact);
            if(iClientCallback != null) {
                try {
                    iClientCallback.receiveStatusChange(phoneNumber, status);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }

    @Override
    public boolean updateUserImage(String phoneNumber,String imagePath, String decodedImage) {
       return imageUtility.writeImageToDisk(phoneNumber + "-" + imagePath,  decodedImage)
               && userRepository.updateUserImage(phoneNumber, phoneNumber + "-" + imagePath);
    }
}
