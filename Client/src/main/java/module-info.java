module gov.iti.jets.client{
    requires javafx.controls;
    requires javafx.fxml;

    opens gov.iti.jets.client to javafx.fxml;



    exports gov.iti.jets.client;
    exports gov.iti.jets.client.presentation.controllers;
    opens gov.iti.jets.client.presentation.controllers to javafx.fxml;


}