package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.UserDTO;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class ModelFactory {
    private final static ModelFactory modelFactory = new ModelFactory();
    private final UserModel userModel = new UserModel();
    ContactListHelper contactListHelper = ContactListHelper.getInstance();
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
        userModel.setContactModels(mapContactList(userDTO.getContacts()));
    }

    public ListProperty<ContactModel> mapContactList(List<ContactDTO> contactDTOList) {
        ListProperty<ContactModel> contactModels = new SimpleListProperty<>();
        contactDTOList.forEach(contactDTO -> {
            ContactModel contactModel = new ContactModel();
            contactModel.setPhoneNumber(contactDTO.getPhoneNumber());
            contactModel.setUsername(contactDTO.getUsername());
            contactModel.setStatus(contactDTO.getStatus());
            contactModel.setImage(getImageFromString(contactDTO.getImage()));
            contactModel.setBio(contactDTO.getBio());
            contactModels.add(contactModel);
            contactListHelper.loadContact(contactModel);
        });
        return contactModels;
    }

    // under testing & need refactoring
    public Image getImageFromString(String decodedImage) {
        return new Image(Arrays.toString(Base64.getDecoder().decode(decodedImage)));
    }

}
