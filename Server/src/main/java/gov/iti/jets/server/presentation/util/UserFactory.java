package gov.iti.jets.server.presentation.util;

import gov.iti.jets.server.presentation.model.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserFactory {
    public static ObservableList<UserModel> users() {
        return FXCollections.observableArrayList(
                new UserModel("0","hesham", "ahmed", "hesham@gmail", "Egypt","Connected"),
                new UserModel("1","hesham", "ahmed", "hesham@gmail", "Egypt","Connected"),
                new UserModel("2","hesham", "ahmed", "hesham@gmail", "Egypt","Connected"),
                new UserModel("3","hesham", "ahmed", "hesham@gmail", "Egypt","Connected"),
                new UserModel("4","hesham", "ahmed", "hesham@gmail", "Egypt","Connected"),
                new UserModel("5","hesham", "ahmed", "hesham@gmail", "Egypt","Discoonected"),
                new UserModel("6","hesham", "ahmed", "hesham@gmail", "Egypt","Connected"),
                new UserModel("7","hesham", "ahmed", "hesham@gmail", "Egypt","Connected")
                );
    }
}
