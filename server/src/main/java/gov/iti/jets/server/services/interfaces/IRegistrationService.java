package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.UserDTO;

import java.sql.SQLException;

public interface IRegistrationService {
    public boolean checkPhoneNumber(String userPhone);
    public boolean checkEmail(String userPhone);
    public boolean addNewUser(UserDTO userDTO);
}
