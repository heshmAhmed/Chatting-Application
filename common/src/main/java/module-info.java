module common {
    requires java.rmi;
    requires org.hibernate.validator;
    requires jakarta.validation;

    exports gov.iti.jets.common;
    exports gov.iti.jets.common.server;
    exports gov.iti.jets.common.dtos;
    exports gov.iti.jets.common.client;
}