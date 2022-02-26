package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.Status;
import gov.iti.jets.common.dtos.UserDTO;
import java.util.List;

public interface IProfileService {
    boolean updateProfile(UserDTO userDTO);
    boolean updateUserStatus(String phoneNumber, Status status, List<String> contacts);
    boolean updateUserImage(String phoneNumber, String imagePath, String decodedImage);
}
