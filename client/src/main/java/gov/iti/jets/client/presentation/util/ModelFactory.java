package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.util.DateHandler;
import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class ModelFactory {
    private final static ModelFactory modelFactory = new ModelFactory();
    private final UserModel userModel = new UserModel();
    private final ContactListHelper contactListHelper = ContactListHelper.getInstance();
    private final ObservableList<ContactModel> contactModels = FXCollections.observableArrayList();
    private final DateHandler dateHandler = DateHandler.getInstance();

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
        userModel.setDob(dateHandler.millisToLocalDate(userDTO.getDob()));
    }

    public void fillContactModels(List<ContactDTO> contacts) {
        contacts.forEach(contactDTO -> {
            ContactModel contactModel= mapUserModelToDTO(contactDTO);
            contactModels.add(contactModel);
            contactListHelper.loadContact(contactModel);
        });
    }

    // under testing & need refactoring
    public Image getImageFromString(String decodedImage) {
        return new Image(Arrays.toString(Base64.getDecoder().decode(decodedImage)));
    }
    public ContactModel mapUserModelToDTO(ContactDTO contactDTO) {
        ContactModel contactModel = new ContactModel();
        contactModel.setPhoneNumber(contactDTO.getPhoneNumber());
        contactModel.setUsername(contactDTO.getUsername());
        contactModel.setStatus(contactDTO.getStatus());
        // contactModel.setImage(getImageFromString(contactDTO.getImage()));
        contactModel.setBio(contactDTO.getBio());
        return contactModel;
    }

}
