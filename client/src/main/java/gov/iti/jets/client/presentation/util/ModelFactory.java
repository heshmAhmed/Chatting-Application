package gov.iti.jets.client.presentation.util;

import gov.iti.jets.client.presentation.models.ContactModel;
import gov.iti.jets.client.presentation.models.UserModel;
import gov.iti.jets.client.util.DateHandler;
import gov.iti.jets.common.dtos.ContactDTO;
import gov.iti.jets.common.dtos.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
        userModel.setStatus(userDTO.getStatus());
        handleUserImage(userDTO.getImage());
    }

    private void handleUserImage(String encodedImage) {
        if(encodedImage.equals(""))
            userModel.setUserImageCircle(new Circle());
        else
            userModel.getUserImageCircle().setFill(new ImagePattern(decodeImage(encodedImage)));
    }

    public ContactModel mapContactModelToDTO(ContactDTO contactDTO) {
        ContactModel contactModel = new ContactModel();
        contactModel.setPhoneNumber(contactDTO.getPhoneNumber());
        contactModel.setUsername(contactDTO.getUsername());
        contactModel.setStatus(contactDTO.getStatus());
        if(!contactDTO.getImage().equals(""))
            contactModel.getImageCircle().setFill(new ImagePattern(decodeImage(contactDTO.getImage())));
        contactModel.setBio(contactDTO.getBio());
        return contactModel;
    }

    public void fillContactModels(List<ContactDTO> contacts) {
        contacts.forEach(contactDTO -> {
            ContactModel contactModel= mapContactModelToDTO(contactDTO);
            contactModels.add(contactModel);
            contactListHelper.loadContact(contactModel);
        });
    }

    public List<String> getContactList() {
        List<String> list = new ArrayList<>();
        this.contactModels.forEach(contactModel -> list.add(contactModel.getPhoneNumber()));
        return list;
    }

    // under testing & need refactoring
    public Image decodeImage(String encodedImage) {
        InputStream targetStream = new ByteArrayInputStream(Base64.getDecoder().decode(encodedImage));
        return new Image(targetStream);
    }

    public void addToContactModels(ContactModel contactModel) {
        this.contactModels.add(contactModel);
    }

    public ObservableList<ContactModel> getContactModels() {
        return contactModels;
    }

    public void clearDate() {
        this.contactModels.clear();
    }

}
