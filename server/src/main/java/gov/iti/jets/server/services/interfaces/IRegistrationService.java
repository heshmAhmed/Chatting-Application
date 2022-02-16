package gov.iti.jets.server.services.interfaces;

import gov.iti.jets.common.dtos.RegistrationDTO;

public interface IRegistrationService {
    public boolean isPhoneExisted(String userPhone);
    public boolean isEmailExisted(String userPhone);
    public boolean createNewUser(RegistrationDTO registrationDTO);
}
