package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.UserDTO;

public interface ILoginService {
    public boolean isPhoneNumberExist(String phoneNumber);
    public boolean isPasswordCorrect(String phoneNumber, String password);
    public UserDTO getUserData(String phoneNumber);
}
