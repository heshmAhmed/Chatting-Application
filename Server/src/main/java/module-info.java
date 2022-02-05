module gov.iti.jets.server {
    requires javafx.controls;
    requires javafx.fxml;


    opens gov.iti.jets.server to javafx.fxml;
    exports gov.iti.jets.server;
    exports gov.iti.jets.server.controller;
    opens gov.iti.jets.server.controller to javafx.fxml;
}