module gov.iti.jets.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;
    requires org.slf4j;
    requires MaterialFX;


    opens gov.iti.jets.server.presentation.controller to javafx.fxml;
    exports gov.iti.jets.server;
    exports gov.iti.jets.server.controller;
    opens gov.iti.jets.server.controller to javafx.fxml;
}