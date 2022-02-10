module gov.iti.jets.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
<<<<<<< HEAD


=======
>>>>>>> e898d59dc42c0e3633a363fd65101df6f0b521f9
    opens gov.iti.jets.client to javafx.fxml;
    opens gov.iti.jets.client.controllers to javafx.fxml;


    exports gov.iti.jets.client;
}