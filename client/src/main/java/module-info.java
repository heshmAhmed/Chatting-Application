module gov.iti.jets.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires org.controlsfx.controls;
    opens gov.iti.jets.client to javafx.fxml;
    opens gov.iti.jets.client.controllers to javafx.fxml;
    opens gov.iti.jets.client.controllers.custom to javafx.fxml;
    requires Common;

    exports gov.iti.jets.client;
}