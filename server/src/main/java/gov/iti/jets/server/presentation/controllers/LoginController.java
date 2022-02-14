package gov.iti.jets.server.presentation.controllers;

import gov.iti.jets.server.presentation.util.PaneCoordinator;
import gov.iti.jets.server.presentation.util.StageCoordinator;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private PaneCoordinator paneCoordinator;
    private StageCoordinator stageCoordinator;
    @FXML
    private TextField enterYourNumberFiled;
    @FXML
    private TextField enterYourNumberField;
    @FXML
    private TextField enterYourPasswordField;
    @FXML
    private MFXButton forgetPassword;
    @FXML
    private MFXButton loginButton;

    @FXML
    void handelLoginAction(ActionEvent event) {
        stageCoordinator.switchToDashboardScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.stageCoordinator = StageCoordinator.getInstance();
    }
}
