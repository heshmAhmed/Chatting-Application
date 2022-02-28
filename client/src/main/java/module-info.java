module gov.iti.jets.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires org.controlsfx.controls;
    opens gov.iti.jets.client to javafx.fxml;
    opens gov.iti.jets.client.presentation.controllers to javafx.fxml;
    opens gov.iti.jets.client.presentation.controllers.custom to javafx.fxml;
    requires common;
    requires java.rmi;
    requires com.google;

    exports gov.iti.jets.client;
}