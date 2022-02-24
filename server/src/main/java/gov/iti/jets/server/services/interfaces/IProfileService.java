package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.UserDTO;

public interface IProfileService {
    boolean updateProfile(UserDTO userDTO);
}
