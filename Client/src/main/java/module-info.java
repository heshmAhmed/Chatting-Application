module gov.iti.jets.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    opens gov.iti.jets.client to javafx.fxml;
    opens gov.iti.jets.client.controllers to javafx.fxml;

    exports gov.iti.jets.client;
}