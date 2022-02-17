module gov.iti.jets.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;
    requires org.slf4j;
    requires MaterialFX;
    requires javafx.web;
    requires java.sql.rowset;
    requires Common;
    requires java.rmi;
    requires org.mapstruct;
    requires org.apache.commons.codec;


    opens gov.iti.jets.server.presentation.controllers to javafx.fxml;
    exports gov.iti.jets.server;
    exports gov.iti.jets.server.presentation.controllers;
    exports gov.iti.jets.server.repository.mapper;
}