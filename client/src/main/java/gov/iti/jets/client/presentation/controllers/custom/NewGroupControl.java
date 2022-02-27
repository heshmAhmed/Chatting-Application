package gov.iti.jets.client.presentation.controllers.custom;

import gov.iti.jets.client.presentation.util.GroupListHelper;
import gov.iti.jets.client.presentation.util.StageCoordinator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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


public class NewGroupControl extends AnchorPane{

    StageCoordinator stageCoordinator = StageCoordinator.getInstance();
    GroupListHelper groupListHelper = GroupListHelper.getInstance();

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
    }


    public void handleAddbutton(){
        String groupName = groupNameTextField.getText();

        if(groupName.length() > 0){
            groupListHelper.createNewGroup(groupName, groupPhotoImageView.getImage());
            stageCoordinator.closeAddNewGroupPopup();
        }else{
            notValidLabel.setText("Please enter a name");
        }
    }

    public void handlePhotoImageView(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile != null){
            System.out.println(selectedFile.getPath());

            Image image = new Image(String.valueOf(selectedFile.getAbsolutePath()));
            groupPhotoImageView.setImage(image);
        }
    }

}
