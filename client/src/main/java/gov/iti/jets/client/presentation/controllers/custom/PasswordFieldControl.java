package gov.iti.jets.client.presentation.controllers.custom;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class PasswordFieldControl extends HBox{

    @FXML
    private PasswordField passwordField;
    Label passwordLabel;

    public String getPasswordFieldText(){
        return passwordField.getText();
    }

    public void setPasswordFieldText(String string){
       passwordField.setText(string);
    }

    public PasswordFieldControl(Label passwordLabel){
        this.passwordLabel = passwordLabel;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login/PasswordHBox.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try{
            loader.load();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void initialize(){
        passwordField.setOnMouseClicked(event -> {
            passwordLabel.setText("");
        });
    }

}
