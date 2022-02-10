module gov.iti.jets.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;
    requires org.slf4j;
    requires MaterialFX;
    requires javafx.web;


    opens gov.iti.jets.server.presentation.controllers to javafx.fxml;
    exports gov.iti.jets.server;
    exports gov.iti.jets.server.controllers;
    opens gov.iti.jets.server.controllers to javafx.fxml;
}