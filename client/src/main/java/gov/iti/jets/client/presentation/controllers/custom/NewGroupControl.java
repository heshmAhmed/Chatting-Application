package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


public class NewGroupControl extends AnchorPane{
    private final StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    private final GroupListHelper groupListHelper = GroupListHelper.getInstance();
    private FileChooser fileChooser;
    @FXML
    private TextField groupNameTextField;
    @FXML
    private ImageView groupPhotoImageView;
    @FXML
    private Button addButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label notValidLabel;
    @FXML
    private Label imageValidationLabel;
    private Optional<File> fileOptional = Optional.empty();

    public NewGroupControl(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/newcontact/new-group-view.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void initialize(){
        groupNameTextField.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e -> notValidLabel.setText(""));
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e -> handleAddbutton() );
        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e ->  stageCoordinator.closeAddNewGroupPopup());
        groupPhotoImageView.addEventHandler(MouseEvent.MOUSE_CLICKED,
                (EventHandler<MouseEvent>) e ->  handlePhotoImageView());
        initFileChooser();
    }

    public void handleAddbutton(){
        String groupName = groupNameTextField.getText();
        if(groupName.length() > 0){
            groupListHelper.createNewGroup(groupName, fileOptional);
            stageCoordinator.closeAddNewGroupPopup();
        }else{
            notValidLabel.setText("please enter a name");
        }
    }

    public void handlePhotoImageView(){
        fileOptional = Optional.ofNullable(fileChooser.showOpenDialog(stageCoordinator.getPrimaryStage()));
        fileOptional.ifPresent(file -> {
            if (file.length() <= 500000) {
                groupPhotoImageView.setImage(new Image(file.getPath()));
                this.imageValidationLabel.setText("");
            }
            else {
                this.imageValidationLabel.setText("image size exceeded 500kb");
                fileOptional = Optional.empty();
            }
        });
    }

    private void initFileChooser() {
        this.fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg"));
    }
}
