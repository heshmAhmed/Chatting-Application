module gov.iti.jets.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;
    requires org.slf4j;
    requires MaterialFX;
    requires javafx.web;
    requires java.sql.rowset;
    requires common;
    requires java.rmi;
    requires org.mapstruct;
    requires jakarta.validation;

    requires  org.apache.commons.io;
    opens gov.iti.jets.server.services.mapper to org.mapstruct;
    opens gov.iti.jets.server.presentation.controllers to javafx.fxml;
    exports gov.iti.jets.server;
    exports gov.iti.jets.server.presentation.controllers;
}