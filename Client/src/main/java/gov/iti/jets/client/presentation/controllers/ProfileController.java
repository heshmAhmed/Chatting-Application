package gov.iti.jets.client.presentation.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ProfileController {

    @FXML
    private VBox profileSlide;

    @FXML
    private AnchorPane anchorePane;

    private void controleSize(){
        profileSlide.setMinWidth(anchorePane.getWidth()/3);
    }

}
