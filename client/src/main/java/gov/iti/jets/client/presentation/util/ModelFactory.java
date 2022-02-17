package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.common.dtos.UserDTO;

public class ModelFactory {
    private final static ModelFactory modelFactory = new ModelFactory();
    private final UserModel userModel = new UserModel();
    private ModelFactory() {}

    public static ModelFactory getInstance() {
        return modelFactory;
    }

    public UserModel getUserModel(){
        return userModel;
    }


    public void fillUserModel(UserDTO userDTO) {
        userModel.setPhoneNumber(userDTO.getPhoneNumber());
        userModel.setUsername(userDTO.getUsername());
        userModel.setEmail(userDTO.getEmail());
        userModel.setBio(userDTO.getBio());
        userModel.setCountry(userDTO.getCountry());
        userModel.setGender(userDTO.getGender());
        // decode image
    }

}
